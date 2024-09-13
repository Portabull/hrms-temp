package com.portabull.security.model;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.util.SpringAuthorizationServerVersion;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Transient
public class OAuth2ClientAuthentication extends AbstractAuthenticationToken {
	private static final long serialVersionUID = SpringAuthorizationServerVersion.SERIAL_VERSION_UID;
	private final String clientId;
	private final RegisteredClient registeredClient;
	private final ClientAuthenticationMethod clientAuthenticationMethod;
	private final Object credentials;
	private final Map<String, Object> additionalParameters;

	/**
	 * Constructs an {@code OAuth2ClientAuthenticationToken} using the provided
	 * parameters.
	 *
	 * @param clientId                   the client identifier
	 * @param clientAuthenticationMethod the authentication method used by the
	 *                                   client
	 * @param credentials                the client credentials
	 * @param additionalParameters       the additional parameters
	 * @param authorities                token authorities
	 */

	public OAuth2ClientAuthentication(Collection<? extends GrantedAuthority> authorities, String clientId,
			ClientAuthenticationMethod clientAuthenticationMethod, @Nullable Object credentials,
			@Nullable Map<String, Object> additionalParameters) {
		super(authorities);
		Assert.hasText(clientId, "clientId cannot be empty");
		Assert.notNull(clientAuthenticationMethod, "clientAuthenticationMethod cannot be null");
		this.clientId = clientId;
		this.registeredClient = null;
		this.clientAuthenticationMethod = clientAuthenticationMethod;
		this.credentials = credentials;
		this.additionalParameters = Collections
				.unmodifiableMap(additionalParameters != null ? additionalParameters : Collections.emptyMap());
	}

	/**
	 * Constructs an {@code OAuth2ClientAuthenticationToken} using the provided
	 * parameters.
	 *
	 * @param registeredClient           the authenticated registered client
	 * @param clientAuthenticationMethod the authentication method used by the
	 *                                   client
	 * @param credentials                the client credentials
	 * @param authorities                token authorities
	 */
	public OAuth2ClientAuthentication(Collection<? extends GrantedAuthority> authorities,
			RegisteredClient registeredClient, ClientAuthenticationMethod clientAuthenticationMethod,
			@Nullable Object credentials) {
		super(authorities);
		Assert.notNull(registeredClient, "registeredClient cannot be null");
		Assert.notNull(clientAuthenticationMethod, "clientAuthenticationMethod cannot be null");
		this.clientId = registeredClient.getClientId();
		this.registeredClient = registeredClient;
		this.clientAuthenticationMethod = clientAuthenticationMethod;
		this.credentials = credentials;
		this.additionalParameters = Collections.unmodifiableMap(Collections.emptyMap());
		setAuthenticated(true);
	}

	@Override
	public Object getPrincipal() {
		return this.clientId;
	}

	@Nullable
	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	/**
	 * Returns the authenticated {@link RegisteredClient registered client}, or
	 * {@code null} if not authenticated.
	 *
	 * @return the authenticated {@link RegisteredClient}, or {@code null} if not
	 *         authenticated
	 */
	@Nullable
	public RegisteredClient getRegisteredClient() {
		return this.registeredClient;
	}

	/**
	 * Returns the {@link ClientAuthenticationMethod authentication method} used by
	 * the client.
	 *
	 * @return the {@link ClientAuthenticationMethod} used by the client
	 */
	public ClientAuthenticationMethod getClientAuthenticationMethod() {
		return this.clientAuthenticationMethod;
	}

	/**
	 * Returns the additional parameters.
	 *
	 * @return the additional parameters
	 */
	public Map<String, Object> getAdditionalParameters() {
		return this.additionalParameters;
	}

}