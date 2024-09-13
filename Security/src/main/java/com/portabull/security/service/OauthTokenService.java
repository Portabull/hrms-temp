package com.portabull.security.service;


import com.portabull.security.model.OAuth2ResourceOwnerPasswordAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.*;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.util.CollectionUtils;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class OauthTokenService {
    RegisteredClientRepository registeredClientRepository;
    OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator;
    OAuth2AuthorizationService authorizationService;

    private static final String ERROR_URI = "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2";

    public OauthTokenService(RegisteredClientRepository registeredClientRepository, OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator, OAuth2AuthorizationService authorizationService) {
        this.registeredClientRepository = registeredClientRepository;
        this.tokenGenerator = tokenGenerator;
        this.authorizationService = authorizationService;
    }


    public OAuth2AccessTokenAuthenticationToken createAccessToken(Authentication usernamePasswordAuthentication, String clientId) {

        RegisteredClient registeredClient = registeredClientRepository.findByClientId(clientId);
        if (null != registeredClient) {

            boolean isCLI = clientId.contains("-cli-");
            boolean isRestClient = clientId.contains("-restapi-");

            OAuth2ClientAuthenticationToken clientPrincipal = new OAuth2ClientAuthenticationToken(registeredClient, ClientAuthenticationMethod.CLIENT_SECRET_BASIC, registeredClient.getClientSecret()); //decode secret while setting

            DataopsAuthorizationService dataopsAuth = (DataopsAuthorizationService) authorizationService;
//            List<OAuth2Authorization>  activeLogins = dataopsAuth.findActiveLogins(clientId);
//            log.info("activeLogins== {}", activeLogins!=null? activeLogins.size() : 0);

//            boolean isReadOnlyUser ;
//            try {
//            	isReadOnlyUser = productDetailService.isReadOnlyAccess(usernamePasswordAuthentication.getName());
//			}
//            catch (GreatDataException ex) {
//            	log.error("Exception while checking readonly user",  ex);
//        		throw new CustomOauthException(String.valueOf(HttpStatus.FORBIDDEN.value()), CustomOauthExceptionUtil.USER_NOT_FOUND);
//			}

            //If concurrent limit is set then check if active logins < concurrentUserLimit
            //If the same user then allow to generate access token
//            if( !isCLI && !isRestClient && !isReadOnlyUser && (!CollectionUtils.isEmpty(activeLogins) &&
//            	!activeLogins.stream().anyMatch(activeAuth -> StringUtils.equals(activeAuth.getPrincipalName(),usernamePasswordAuthentication.getName())))) {
//
//            	Integer maxConcurrentLogin;
//				try {
//					maxConcurrentLogin = productDetailService.getLicensedConcurrentUserCount();
//
//					if(maxConcurrentLogin!=null && activeLogins.size() >= maxConcurrentLogin ) {
//	            		log.error("Maximum limit reached for login. Total active users = {}",  activeLogins.size());
//	            		throw new CustomOauthException(String.valueOf(HttpStatus.FORBIDDEN.value()), CustomOauthExceptionUtil.MAX_CONCURRENT_USER_lIMIT);
//	            	}
//				} catch (GreatDataException e) {
//					log.error("License details are not available.");
//					throw new CustomOauthException(String.valueOf(HttpStatus.FORBIDDEN.value()), CustomOauthExceptionUtil.LICENSE_DETAILS_NOT_AVAILABLE);
//				}
//
//            }

            OAuth2ResourceOwnerPasswordAuthenticationToken resourceOwnerPasswordAuthentication = new OAuth2ResourceOwnerPasswordAuthenticationToken(AuthorizationGrantType.PASSWORD, clientPrincipal, Collections.emptySet(), Collections.emptyMap());

            Set<String> authorizedScopes = registeredClient.getScopes();
            Set<String> requestedScopes = resourceOwnerPasswordAuthentication.getScopes();
            if (!CollectionUtils.isEmpty(requestedScopes)) {
                Set<String> unauthorizedScopes = requestedScopes.stream()
                        .filter(requestedScope -> !registeredClient.getScopes().contains(requestedScope))
                        .collect(Collectors.toSet());
                if (!CollectionUtils.isEmpty(unauthorizedScopes)) {
                    throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_SCOPE);
                }

                authorizedScopes = new LinkedHashSet<>(requestedScopes);
            }

            DefaultOAuth2TokenContext.Builder tokenContextBuilder = DefaultOAuth2TokenContext.builder()
                    .registeredClient(registeredClient)
                    .principal(usernamePasswordAuthentication)
                    .authorizedScopes(authorizedScopes)
                    .authorizationServerContext(AuthorizationServerContextHolder.getContext())
                    //.providerContext(ProviderContextHolder.getProviderContext())
                    .authorizationGrantType(AuthorizationGrantType.PASSWORD)
                    .authorizationGrant(resourceOwnerPasswordAuthentication);

            // ----- Access token -----
            OAuth2TokenContext tokenContext = tokenContextBuilder.tokenType(OAuth2TokenType.ACCESS_TOKEN).build();
            OAuth2Token generatedAccessToken = this.tokenGenerator.generate(tokenContext);
            if (generatedAccessToken == null) {
                OAuth2Error error = new OAuth2Error(OAuth2ErrorCodes.SERVER_ERROR,
                        "The token generator failed to generate the access token.", ERROR_URI);
                throw new OAuth2AuthenticationException(error);
            }

            OAuth2AccessToken accessToken = new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER,
                    generatedAccessToken.getTokenValue(), generatedAccessToken.getIssuedAt(),
                    generatedAccessToken.getExpiresAt(), tokenContext.getAuthorizedScopes());

            // ----- Refresh token -----
            OAuth2RefreshToken refreshToken = null;
            if (registeredClient.getAuthorizationGrantTypes().contains(AuthorizationGrantType.REFRESH_TOKEN) &&
                    // Do not issue refresh token to public client
                    !clientPrincipal.getClientAuthenticationMethod().equals(ClientAuthenticationMethod.NONE)) {

                tokenContext = tokenContextBuilder.tokenType(OAuth2TokenType.REFRESH_TOKEN).build();
                OAuth2Token generatedRefreshToken = this.tokenGenerator.generate(tokenContext);
                if (!(generatedRefreshToken instanceof OAuth2RefreshToken)) {
                    OAuth2Error error = new OAuth2Error(OAuth2ErrorCodes.SERVER_ERROR,
                            "The token generator failed to generate the refresh token.", ERROR_URI);
                    throw new OAuth2AuthenticationException(error);
                }
                refreshToken = (OAuth2RefreshToken) generatedRefreshToken;

            }

            String id = (isRestClient || isCLI || "system".equalsIgnoreCase(usernamePasswordAuthentication.getName())) ? UUID.randomUUID().toString() : usernamePasswordAuthentication.getName();

            // @formatter:off
            OAuth2Authorization.Builder authorizationBuilder = OAuth2Authorization.withRegisteredClient(registeredClient)
                    .principalName(usernamePasswordAuthentication.getName())
                    .authorizationGrantType(AuthorizationGrantType.PASSWORD)
                    .authorizedScopes(authorizedScopes)
                    // .attribute(OAuth2Authorization.AUTHORIZED_SCOPE_ATTRIBUTE_NAME, authorizedScopes)
                    .attribute(Principal.class.getName(), usernamePasswordAuthentication)
                    .id(id);

            // @formatter:on
            if (generatedAccessToken instanceof ClaimAccessor) {
                authorizationBuilder.token(accessToken, (metadata) ->
                        metadata.put(OAuth2Authorization.Token.CLAIMS_METADATA_NAME, ((ClaimAccessor) generatedAccessToken).getClaims()));
            } else {
                authorizationBuilder.accessToken(accessToken);
            }

            if (null != refreshToken) {
                authorizationBuilder.refreshToken(refreshToken);
            }

            OAuth2Authorization authorization = authorizationBuilder.build();

            this.authorizationService.save(authorization);

            Map<String, Object> additionalParameters = Collections.emptyMap();
            return new OAuth2AccessTokenAuthenticationToken(registeredClient, clientPrincipal, accessToken, refreshToken, additionalParameters);

        }
        return null;
    }

    public void deleteAccessToken(String userName) {
        try {
            DataopsAuthorizationService dataopsAuth = (DataopsAuthorizationService) authorizationService;
            dataopsAuth.deleteAccessToken(userName);
        } catch (Exception e) {
            log.error("Error while deleting access token for uerName {}", userName);
        }
    }

}
