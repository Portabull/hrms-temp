package com.portabull.security.converters;

import com.portabull.security.model.OAuth2ResourceOwnerPasswordAuthenticationToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OAuth2ResourceOwnerPasswordAuthenticationConverter implements AuthenticationConverter {

    private static String ACCESS_TOKEN_REQUEST_ERROR_URI = "";

    @Override
    public Authentication convert(HttpServletRequest request) {
        String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
        if (!AuthorizationGrantType.PASSWORD.getValue().equals(grantType)) {
            return null;
        }

        MultiValueMap<String, String> parameters = getParameters(request);
        String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
        if (StringUtils.hasText(scope) &&
                parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
            throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    OAuth2ParameterNames.SCOPE,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        Set<String> requestedScopes = null;
        if (StringUtils.hasText(scope)) {
            requestedScopes = new HashSet<>(
                    Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
        }

        String username = parameters.getFirst(OAuth2ParameterNames.USERNAME);
        if (!StringUtils.hasText(username) || parameters.get(OAuth2ParameterNames.USERNAME).size() != 1) {
            throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    OAuth2ParameterNames.USERNAME,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        String password = parameters.getFirst(OAuth2ParameterNames.PASSWORD);
        if (!StringUtils.hasText(password) || parameters.get(OAuth2ParameterNames.PASSWORD).size() != 1) {
            throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    OAuth2ParameterNames.PASSWORD,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();
        if (clientPrincipal == null) {
            throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    OAuth2ErrorCodes.INVALID_CLIENT,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        Map<String, Object> additionalParameters = parameters
                .entrySet()
                .stream()
                .filter(e -> !e.getKey().equals(OAuth2ParameterNames.GRANT_TYPE) &&
                        !e.getKey().equals(OAuth2ParameterNames.SCOPE))
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get(0)));

        return new OAuth2ResourceOwnerPasswordAuthenticationToken(AuthorizationGrantType.PASSWORD, clientPrincipal, requestedScopes, additionalParameters);

    }


    static MultiValueMap<String, String> getParameters(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap(parameterMap.size());
        parameterMap.forEach((key, values) -> {
            if (values.length > 0) {
                String[] var3 = values;
                int var4 = values.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    String value = var3[var5];
                    parameters.add(key, value);
                }
            }

        });
        return parameters;
    }

    static void throwError(String errorCode, String parameterName, String errorUri) {
        OAuth2Error error = new OAuth2Error(errorCode, "OAuth 2.0 Parameter: " + parameterName, errorUri);
        throw new OAuth2AuthenticationException(error);
    }
}
