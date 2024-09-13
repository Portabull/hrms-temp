package com.portabull.exception;

import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

public class CustomOauthException extends OAuth2AuthenticationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomOauthException(String code, String message) {
		super(new OAuth2Error(code, message, null));
	}

}
