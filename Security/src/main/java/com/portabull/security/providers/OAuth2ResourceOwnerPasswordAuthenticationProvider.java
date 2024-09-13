package com.portabull.security.providers;

import com.portabull.security.model.OAuth2ResourceOwnerPasswordAuthenticationToken;
import com.portabull.security.service.OauthTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.util.Assert;

import java.util.Map;




@Slf4j
public class OAuth2ResourceOwnerPasswordAuthenticationProvider implements AuthenticationProvider {
	private final AuthenticationManager authenticationManager;
	private final OauthTokenService oauthTokenService;

	/**
	 * Constructs an {@code OAuth2ResourceOwnerPasswordAuthenticationProviderNew} using the provided parameters.
	 *
	 * @param authenticationManager the authentication manager
	 * @param oauthTokenService the authorization service
	 * @param tokenGenerator the token generator
	 * @since 0.2.3
	 */
	public OAuth2ResourceOwnerPasswordAuthenticationProvider(AuthenticationManager authenticationManager,OauthTokenService oauthTokenService) {
		Assert.notNull(oauthTokenService, "oauthTokenService cannot be null");
		this.authenticationManager = authenticationManager;
		this.oauthTokenService = oauthTokenService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		OAuth2ResourceOwnerPasswordAuthenticationToken resouceOwnerPasswordAuthentication = (OAuth2ResourceOwnerPasswordAuthenticationToken) authentication;
		OAuth2ClientAuthenticationToken clientPrincipal = getAuthenticatedClientElseThrowInvalidClient(resouceOwnerPasswordAuthentication);
		RegisteredClient registeredClient = clientPrincipal.getRegisteredClient();

		if ((registeredClient == null) || (registeredClient.getAuthorizationGrantTypes() == null || !registeredClient.getAuthorizationGrantTypes().contains(AuthorizationGrantType.PASSWORD))) {
	
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.UNAUTHORIZED_CLIENT);
		}

		Authentication usernamePasswordAuthentication = getUsernamePasswordAuthentication(resouceOwnerPasswordAuthentication);
		
		return this.oauthTokenService.createAccessToken(usernamePasswordAuthentication,registeredClient.getClientId());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		boolean supports = OAuth2ResourceOwnerPasswordAuthenticationToken.class.isAssignableFrom(authentication);
		log.debug("supports authentication=" + authentication + " returning " + supports);
		return supports;
	}

	private Authentication getUsernamePasswordAuthentication(OAuth2ResourceOwnerPasswordAuthenticationToken resouceOwnerPasswordAuthentication) {

		Map<String, Object> additionalParameters = resouceOwnerPasswordAuthentication.getAdditionalParameters();

		String username = (String) additionalParameters.get(OAuth2ParameterNames.USERNAME);
		String password = (String) additionalParameters.get(OAuth2ParameterNames.PASSWORD);

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		log.debug("got usernamePasswordAuthenticationToken=" + usernamePasswordAuthenticationToken);

		return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}

	private OAuth2ClientAuthenticationToken getAuthenticatedClientElseThrowInvalidClient(Authentication authentication) {

		OAuth2ClientAuthenticationToken clientPrincipal = null;

		if (OAuth2ClientAuthenticationToken.class.isAssignableFrom(authentication.getPrincipal().getClass())) {
			clientPrincipal = (OAuth2ClientAuthenticationToken) authentication.getPrincipal();
		}

		if (clientPrincipal != null && clientPrincipal.isAuthenticated()) {
			return clientPrincipal;
		}

		throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_CLIENT);
	}

}
