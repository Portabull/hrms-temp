package com.portabull.exception;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CustomOauthExceptionUtil {

    private static final String CODE = "code";

    private static final String MESSAGE = "message";

    private static final String DETAILS = "details";

    public static final String USER_NOT_FOUND = "user_not_found";

    public static final String USER_DISABLED = "user_disabled";

    public static final String LDAP_AUTH_FAILED = "ldap_authentication_failed";

    public static final String AUTHENTICATION_FAILURE = "authentication_failure";

    public static final String MAX_CONCURRENT_USER_lIMIT = "max_concurrent_user_limit";

    public static final String LICENSE_DETAILS_NOT_AVAILABLE = "license_details_not_available";

    public static final String LOGIN_METHOD_NOT_AVAILABLE = "login_method_not_available";

    public static final String SUBSCRIPTION_NOT_VALID = "subscription_not_valid";

    public static final String SESSION_EXPIRED = "session_expired";

    public static final String REST_API_ACCESS_DISABLED = "rest_api_access_disabled";

    public static final String PASSWORD_EXPIRED = "password_expired";

    public static Map<String, String> createErrorResponseMap(String errorCode, String errorMessage) {
        Map<String, String> errorResponseMap = new HashMap<>();
        errorResponseMap.put(CODE, errorCode);
        errorResponseMap.put(MESSAGE, ErrorConstants.GDP401000_MESSAGE);

        if (StringUtils.isEmpty(errorMessage)) {
            errorResponseMap.put(DETAILS, ErrorConstants.GDP401007_DETAILS);
        } else {
            switch (errorMessage) {
                case USER_DISABLED:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401001_DETAILS);
                    break;
                case USER_NOT_FOUND:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401002_DETAILS);
                    break;
                case LDAP_AUTH_FAILED:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401003_DETAILS);
                    break;
                case MAX_CONCURRENT_USER_lIMIT:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401004_DETAILS);
                    break;
                case LICENSE_DETAILS_NOT_AVAILABLE:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401005_DETAILS);
                    break;
                case LOGIN_METHOD_NOT_AVAILABLE:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401006_DETAILS);
                    break;
                case SESSION_EXPIRED:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401008_DETAILS);
                    break;
                case SUBSCRIPTION_NOT_VALID:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401009_DETAILS);
                    break;
                case REST_API_ACCESS_DISABLED:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401011_DETAILS);
                    break;
                case PASSWORD_EXPIRED:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401905_DETAILS);
                    break;
                case AUTHENTICATION_FAILURE:
                default:
                    errorResponseMap.put(DETAILS, ErrorConstants.GDP401007_DETAILS);
                    break;
            }
        }

        return errorResponseMap;
    }

}
