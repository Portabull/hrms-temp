package com.portabull.security.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtDecoder jwtDecoder;

    public static final String UNAUTHENTICATED_ERROR_PAGE_URL = "login/unauthenticated";

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

		/* http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.requestMatchers("/oauth2/token", "/login/**","/sso/providers", "/login**", "/callback/", "/webjars/**", "/error**",
						"/oauth2/authorization/**", "/sw.js", "/h2-console/**").permitAll()*/
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(mvcMatcherBuilder.pattern("/oauth2/token"),
                                mvcMatcherBuilder.pattern("/login/**"),
                                mvcMatcherBuilder.pattern("/sso/providers"),
                                mvcMatcherBuilder.pattern("/sso/user/sync"),
                                mvcMatcherBuilder.pattern("/login**"),
                                mvcMatcherBuilder.pattern("/callback/"),
                                mvcMatcherBuilder.pattern("/webjars/**"),
                                mvcMatcherBuilder.pattern("/hrms/**"),
                                mvcMatcherBuilder.pattern("/test/**"),
                                mvcMatcherBuilder.pattern("/error**"),
                                mvcMatcherBuilder.pattern("/oauth2/authorization/**"),
                                mvcMatcherBuilder.pattern("/sw.js"), mvcMatcherBuilder.pattern("/h2-console/**"))
                        .permitAll()
                        .anyRequest().authenticated()).csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->

//						httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults())
                                httpSecurityOAuth2ResourceServerConfigurer.authenticationManagerResolver(
                                        this.tokenManagerResolver(jwtDecoder)
                                )

                );

        //.authorizeHttpRequests()
        //.antMatchers("/oauth2/token", "/login/**","/sso/providers", "/login**", "/callback/", "/webjars/**", "/error**",
        //"/oauth2/authorization/**", "/sw.js", "/h2-console/**")
        //.permitAll()
        //.anyRequest().authenticated()
        //.and().csrf().disable().oauth2ResourceServer().jwt();

//        http.oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
//            httpSecurityOAuth2LoginConfigurer.defaultSuccessUrl("/sso/success", true);
//            httpSecurityOAuth2LoginConfigurer.loginPage(uiUrl + "login");
//            httpSecurityOAuth2LoginConfigurer.failureUrl(uiUrl + UNAUTHENTICATED_ERROR_PAGE_URL);
//        });

        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.NEVER));

        return http.build();
    }

    @Bean
    public AuthenticationManagerResolver<HttpServletRequest> tokenManagerResolver(JwtDecoder jwtDecoder) {
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtDecoder);
        jwtAuthenticationProvider.setJwtAuthenticationConverter(this.jwtAuthenticationConverter());
        AuthenticationManager manager = new ProviderManager(jwtAuthenticationProvider);

        return (request) -> manager;
    }

    //    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
//        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        grantedAuthoritiesConverter.setAuthorityPrefix("");
//        grantedAuthoritiesConverter.setAuthoritiesClaimName("user-authorities");
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
//        return jwtAuthenticationConverter;
//    }
    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("");
        grantedAuthoritiesConverter.setAuthoritiesClaimName("user-authorities");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);

        return jwt -> {
            AbstractAuthenticationToken authentication = jwtAuthenticationConverter.convert(jwt);
            // Log the claims and authorities for debugging
            System.out.println("JWT Claims: " + jwt.getClaims());
            System.out.println("Authorities: " + authentication.getAuthorities());
            return authentication;
        };
    }


}
