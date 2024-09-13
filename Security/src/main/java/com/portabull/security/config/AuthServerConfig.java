package com.portabull.security.config;

import com.portabull.security.converters.OAuth2ResourceOwnerPasswordAuthenticationConverter;
import com.portabull.security.repository.JdbcClientRegistrationRepository;
import com.portabull.security.service.DataopsAuthorizationService;
import com.portabull.security.service.OauthTokenService;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.portabull.exception.CustomAuthenticationFailureHandler;
import com.portabull.security.providers.ClientCredentialsAuthProvider;
import com.portabull.security.providers.OAuth2ResourceOwnerPasswordAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.authorization.token.*;
import org.springframework.security.oauth2.server.authorization.web.authentication.DelegatingAuthenticationConverter;
import org.springframework.security.oauth2.server.authorization.web.authentication.OAuth2AuthorizationCodeAuthenticationConverter;
import org.springframework.security.oauth2.server.authorization.web.authentication.OAuth2ClientCredentialsAuthenticationConverter;
import org.springframework.security.oauth2.server.authorization.web.authentication.OAuth2RefreshTokenAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class AuthServerConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUrl;

    @Value("${oidc.token.max.clock.skew:60}")
    private Long maxClockSkew;

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http, OauthTokenService oauthTokenService,
                                                             CustomAuthenticationFailureHandler customAuthenticationFailureHandler, OAuth2TokenGenerator tokenGenerator,
                                                             RegisteredClientRepository registeredClientRepository, PasswordEncoder passwordEncoder,
                                                             OAuth2AuthorizationService oAuth2AuthorizationService) throws Exception {
        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();

        http.apply(authorizationServerConfigurer.tokenEndpoint((tokenEndpoint) -> {
            tokenEndpoint.accessTokenRequestConverter(
                    new DelegatingAuthenticationConverter(Arrays.asList(
                            new OAuth2AuthorizationCodeAuthenticationConverter(),
                            new OAuth2RefreshTokenAuthenticationConverter(),
                            new OAuth2ClientCredentialsAuthenticationConverter(),
                            new OAuth2ResourceOwnerPasswordAuthenticationConverter()))
            );
            tokenEndpoint.errorResponseHandler(customAuthenticationFailureHandler);
        }));

        RequestMatcher endpointsMatcher = authorizationServerConfigurer.getEndpointsMatcher();
        http.securityMatcher(endpointsMatcher)
                //.requestMatcher(endpointsMatcher)
                // .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher))
                .apply(authorizationServerConfigurer);

        SecurityFilterChain securityFilterChain = http.formLogin(Customizer.withDefaults()).build();

        /**
         * Custom configuration for Resource Owner Password grant type. Current
         * implementation has no support for Resource Owner Password grant type
         */
        addCustomOAuth2ResourceOwnerPasswordAuthenticationProvider(http, oauthTokenService, tokenGenerator,
                registeredClientRepository, passwordEncoder, oAuth2AuthorizationService);

        return securityFilterChain;
    }

    @Bean
    public OAuth2AuthorizationService authorizationService(RegisteredClientRepository registeredClientRepository, Environment environment) {
        // JdbcOAuth2AuthorizationService jdbcOAuth2AuthorizationService = new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
        DataopsAuthorizationService jdbcOAuth2AuthorizationService = new DataopsAuthorizationService(jdbcTemplate, registeredClientRepository, environment);

        return jdbcOAuth2AuthorizationService;
    }

    private void addCustomOAuth2ResourceOwnerPasswordAuthenticationProvider(HttpSecurity http,
                                                                            OauthTokenService oauthTokenService, OAuth2TokenGenerator tokenGenerator,
                                                                            RegisteredClientRepository registeredClientRepository, PasswordEncoder passwordEncoder,
                                                                            OAuth2AuthorizationService oAuth2AuthorizationService) {

        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);

        OAuth2ResourceOwnerPasswordAuthenticationProvider resourceOwnerPasswordAuthenticationProvider = new OAuth2ResourceOwnerPasswordAuthenticationProvider(
                authenticationManager, oauthTokenService);

        http.authenticationProvider(resourceOwnerPasswordAuthenticationProvider);
        http.authenticationProvider(
                new ClientCredentialsAuthProvider(tokenGenerator, issuerUrl, oAuth2AuthorizationService, jdbcTemplate));

    }

    //todo: is this unecessary??
    public TokenSettings tokenSettings() {
        return TokenSettings.builder()
                .accessTokenTimeToLive(Duration.ofMinutes(30L))
                .build();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcTemplate);
        return registeredClientRepository;
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        RSAKey rsaKey = generateRsa();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }

    private static RSAKey generateRsa() {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
//                .keyID(UUID.randomUUID().toString())
                .keyID("DUGIUDHNJDGNHNDKJD767DKJFKJK")
                .build();
    }

    private static KeyPair generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return keyPair;
    }

    @Bean
    public AuthorizationServerSettings providerSettings() {
        log.info("Issuer url is {}", issuerUrl);
        return AuthorizationServerSettings.builder()
                .issuer(issuerUrl)
                .build();
    }

    @Bean
    OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer() {
        return context -> {
            if (context.getTokenType() == OAuth2TokenType.ACCESS_TOKEN) {
                Authentication principal = context.getPrincipal();
                Set<String> authorities = principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet());
                context.getClaims().claim("user-authorities", authorities);
            }
        };
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OAuth2TokenGenerator oAuth2TokenGenerator(JWKSource<SecurityContext> jwkSource, OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer) {
        JwtGenerator jwtGenerator = new JwtGenerator(new NimbusJwtEncoder(jwkSource));
        jwtGenerator.setJwtCustomizer(jwtCustomizer);
        return new DelegatingOAuth2TokenGenerator(jwtGenerator, new OAuth2AccessTokenGenerator(), new OAuth2RefreshTokenGenerator());
    }

    @Bean
    public OauthTokenService oauthTokenService(RegisteredClientRepository registeredClientRepository, OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator, OAuth2AuthorizationService authorizationService) {
        OauthTokenService oauthTokenService = new OauthTokenService(registeredClientRepository, tokenGenerator, authorizationService);
        return oauthTokenService;
    }

    @Bean
    public JdbcClientRegistrationRepository clientRegistrationRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcClientRegistrationRepository(jdbcTemplate);
    }

    @Bean
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder userPasswordEncoder() {
        log.info("userPasswordEncoder :{} ");
        return new BCryptPasswordEncoder(8);
    }
}
