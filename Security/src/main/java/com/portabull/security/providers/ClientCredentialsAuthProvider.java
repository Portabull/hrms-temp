package com.portabull.security.providers;

import com.portabull.security.model.OAuth2ClientAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClaimAccessor;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientCredentialsAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsSet;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ClientCredentialsAuthProvider implements AuthenticationProvider {

	private final String issuerUrl;
	private final OAuth2TokenGenerator<OAuth2Token> tokenGenerator;
	private final OAuth2AuthorizationService oAuth2AuthorizationService;
	private final JdbcTemplate jdbcTemplate;

	private static final String ROLE = "system";
	private static final String COLUMN_NAME = "feature_name";
	private static final String QUERY = "select tf.feature_name as " + COLUMN_NAME
			+ " from t_role tr join t_role_feature trf on (tr.role_id = trf.role_id) join t_feature tf on (tf.feature_id = trf.feature_id) where tr.role_name = '"
			+ ROLE + "'";

	public ClientCredentialsAuthProvider(OAuth2TokenGenerator<OAuth2Token> tokenGenerator, String issuerUrl,
			OAuth2AuthorizationService oAuth2AuthorizationService, JdbcTemplate jdbcTemplate) {
		this.tokenGenerator = tokenGenerator;
		this.issuerUrl = issuerUrl;
		this.oAuth2AuthorizationService = oAuth2AuthorizationService;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		OAuth2ClientAuthenticationToken authenticationToken = (OAuth2ClientAuthenticationToken) authentication
				.getPrincipal();

		OAuth2Authorization authorization = this.oAuth2AuthorizationService
				.findById(authenticationToken.getRegisteredClient().getId());

		Instant currentTime = Instant.now();

		if (authorization == null || authorization.getAccessToken().getToken().getExpiresAt().isBefore(currentTime)) {

			authorization = createToken(authenticationToken,
					jdbcTemplate.query(QUERY, new RowMapper<GrantedAuthority>() {
						@Override
						public SimpleGrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
							return new SimpleGrantedAuthority(rs.getString(COLUMN_NAME));
						}
					}), authorization);
		} else {
			log.debug("Current token expires at: {} , current time: {} ",
					authorization.getAccessToken().getToken().getExpiresAt(), currentTime);
		}

		Map<String, Object> additionalParameters = new HashMap<>();

		additionalParameters.put("expires_in",
				Duration.between(Instant.now(), authorization.getAccessToken().getToken().getExpiresAt()).getSeconds());

		return new OAuth2AccessTokenAuthenticationToken(authenticationToken.getRegisteredClient(), authentication,
				authorization.getAccessToken().getToken(), null, additionalParameters);
	}

	public OAuth2Authorization createToken(OAuth2ClientAuthenticationToken authenticationToken,
			List<GrantedAuthority> authorities, OAuth2Authorization authorization) {

		Instant issuedAt = Instant.now();
		Instant expiresAt = issuedAt
				.plus(authenticationToken.getRegisteredClient().getTokenSettings().getAccessTokenTimeToLive());

		if (authorization != null)
			this.oAuth2AuthorizationService.remove(authorization);

		log.debug(
				"Creating new token with RegisteredClient: [id:{}, clientId:{}, clientName:{}] issuerUrl: {} , issuedAt: {} , expiresAt: {}",
				authenticationToken.getRegisteredClient().getId(),
				authenticationToken.getRegisteredClient().getClientId(),
				authenticationToken.getRegisteredClient().getClientName(), issuerUrl, issuedAt, expiresAt);

		OAuth2TokenContext accessTokenContext = OAuth2TokenClaimsContext
				.with(OAuth2TokenClaimsSet.builder().subject(authenticationToken.getRegisteredClient().getClientId())
						.expiresAt(expiresAt).issuedAt(issuedAt).issuer(issuerUrl))
				.authorizedScopes(authenticationToken.getRegisteredClient().getScopes())
				.principal(new OAuth2ClientAuthentication(authorities,
						authenticationToken.getRegisteredClient().getClientId(),
						authenticationToken.getClientAuthenticationMethod(), authenticationToken.getCredentials(),
						authenticationToken.getAdditionalParameters()))
				.tokenType(OAuth2TokenType.ACCESS_TOKEN).registeredClient(authenticationToken.getRegisteredClient())
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.authorizationServerContext(AuthorizationServerContextHolder.getContext()).build();

		OAuth2Token accessToken = tokenGenerator.generate(accessTokenContext);

		OAuth2Authorization.Builder authorizationBuilder = OAuth2Authorization
				.withRegisteredClient(authenticationToken.getRegisteredClient())
				.principalName(authenticationToken.getRegisteredClient().getClientName())
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.authorizedScopes(authenticationToken.getRegisteredClient().getScopes())
				.id(authenticationToken.getRegisteredClient().getId());

		if (accessToken instanceof ClaimAccessor) {
			authorizationBuilder.token(
					new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER, accessToken.getTokenValue(),
							accessToken.getIssuedAt(), accessToken.getExpiresAt(),
							authenticationToken.getRegisteredClient().getScopes()),
					(metadata) -> metadata.put(OAuth2Authorization.Token.CLAIMS_METADATA_NAME,
							((ClaimAccessor) accessToken).getClaims()));
		} else {
			authorizationBuilder.accessToken(new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER,
					accessToken.getTokenValue(), accessToken.getIssuedAt(), accessToken.getExpiresAt(),
					authenticationToken.getRegisteredClient().getScopes()));
		}

		authorization = authorizationBuilder.build();

		this.oAuth2AuthorizationService.save(authorization);

		return authorization;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		boolean supports = OAuth2ClientCredentialsAuthenticationToken.class.isAssignableFrom(authentication);
		log.debug("ClientCredentialsAuthProvider supports authentication = {} returning = {} ", authentication,
				supports);
		return supports;
	}

}
