package com.portabull.security.repository;

import com.portabull.exception.ErrorConstants;
import com.portabull.exception.GreatDataException;
import com.portabull.utils.CodecUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.*;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;

@Slf4j
public class JdbcClientRegistrationRepository implements ClientRegistrationRepository, Iterable<ClientRegistration> {
    
	private static final String COLUMN_NAMES = "registration_id,client_id,client_secret,client_authentication_method,authorization_grant_type,client_name,redirect_uri,scopes,authorization_uri,token_uri,jwk_set_uri,issuer_uri,user_info_uri,user_info_authentication_method,user_name_attribute_name,configuration_metadata";   
    private static final String TABLE_NAME = "t_sso_provider_registered_client";
    private static final String LOAD_CLIENT_REGISTERED_SQL = "SELECT " + COLUMN_NAMES + " FROM " + TABLE_NAME;
    private static final String LOAD_CLIENT_REGISTERED_QUERY_SQL = LOAD_CLIENT_REGISTERED_SQL + " WHERE ";
    private static final String INSERT_CLIENT_REGISTERED_SQL = "INSERT INTO " + TABLE_NAME + "(" + COLUMN_NAMES + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_CLIENT_REGISTERED_SQL = "UPDATE " + TABLE_NAME + " SET client_id = ?,client_secret = ?,client_authentication_method = ?,authorization_grant_type = ?,client_name = ?,redirect_uri = ?,scopes = ?,authorization_uri = ?,token_uri = ?,jwk_set_uri = ?,issuer_uri = ?,user_info_uri = ?,user_info_authentication_method = ?,user_name_attribute_name = ? WHERE registration_id = ?";
    private static final String DELETE_ALL_CLIENT_REGISTERED_SQL = "DELETE FROM " + TABLE_NAME;
    private final JdbcOperations jdbcOperations;
    private RowMapper<ClientRegistration> clientRegistrationRowMapper;
    private Function<ClientRegistration, List<SqlParameterValue>> clientRegistrationListParametersMapper;

    public JdbcClientRegistrationRepository(JdbcOperations jdbcOperations) {
        Assert.notNull(jdbcOperations, "JdbcOperations can not be null");
        this.jdbcOperations = jdbcOperations;
        this.clientRegistrationRowMapper = new ClientRegistrationRowMapper();
        this.clientRegistrationListParametersMapper = new ClientRegistrationParametersMapper();
    }

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        Assert.hasText(registrationId, "registrationId cannot be empty");
        return this.findBy("registration_id = ?", registrationId);
    }

    private ClientRegistration findBy(String filter, Object... args) {
        List<ClientRegistration> result = this.jdbcOperations.query(LOAD_CLIENT_REGISTERED_QUERY_SQL + filter, this.clientRegistrationRowMapper, args);
        return !result.isEmpty() ? result.get(0) : null;
    }

    public void save(ClientRegistration clientRegistration) {
        Assert.notNull(clientRegistration, "clientRegistration cannot be null");
        ClientRegistration existingClientRegistration = this.findByRegistrationId(clientRegistration.getRegistrationId());
        if (existingClientRegistration != null) {
            this.updateRegisteredClient(clientRegistration);
        } else {
            this.insertClientRegistration(clientRegistration);
        }
    }
    
    public void deleteAll(){    	
    	 this.jdbcOperations.update(DELETE_ALL_CLIENT_REGISTERED_SQL);
    } 
    
    private void updateRegisteredClient(ClientRegistration clientRegistration) {
        List<SqlParameterValue> parameterValues = this.clientRegistrationListParametersMapper.apply(clientRegistration);
        PreparedStatementSetter statementSetter = new ArgumentPreparedStatementSetter(parameterValues.toArray());
        this.jdbcOperations.update(UPDATE_CLIENT_REGISTERED_SQL, statementSetter);
    }

    private void insertClientRegistration(ClientRegistration clientRegistration) {
        List<SqlParameterValue> parameterValues = this.clientRegistrationListParametersMapper.apply(clientRegistration);
        PreparedStatementSetter statementSetter = new ArgumentPreparedStatementSetter(parameterValues.toArray());
        this.jdbcOperations.update(INSERT_CLIENT_REGISTERED_SQL, statementSetter);
    }

	public List<ClientRegistration> findAny() throws GreatDataException {
		try {
			List<ClientRegistration> result = this.jdbcOperations.query(LOAD_CLIENT_REGISTERED_SQL,
					this.clientRegistrationRowMapper);
			return result.isEmpty() ? Collections.emptyList() : result;
		} catch (Exception e) {
			log.error("An unexpected error occurred: {}", e);
			if (e.getMessage() == null) {
				throw new GreatDataException(ErrorConstants.INTERNAL_SERVER_ERROR_CODE,
						ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500000_DETAILS);
			} else {
				throw new GreatDataException(ErrorConstants.INTERNAL_SERVER_ERROR_CODE,
						ErrorConstants.GDP500000_MESSAGE, e.getMessage());
			}
		}
	}

	public Iterator<ClientRegistration> iterator() {
		try {
			return this.findAny().iterator();
		} catch (GreatDataException e) {
			throw new IllegalStateException("Error fetching client registrations", e);
		}
	}
    public static class ClientRegistrationRowMapper implements RowMapper<ClientRegistration> {
        private ObjectMapper objectMapper = new ObjectMapper();

        public ClientRegistrationRowMapper() {
            ClassLoader classLoader = JdbcClientRegistrationRepository.class.getClassLoader();
            List<Module> securityModules = SecurityJackson2Modules.getModules(classLoader);
            this.objectMapper.registerModules(securityModules);
            this.objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        }

        @Override
        public ClientRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
            Set<String> scopes = StringUtils.commaDelimitedListToSet(rs.getString("scopes"));
            try {
            	ClientRegistration.Builder builder;
			
				builder = ClientRegistration.withRegistrationId(rs.getString("registration_id"))
				        .clientId(rs.getString("client_id"))				        
				        .clientSecret(CodecUtil.pwdDecrypt(rs.getString("client_secret")))
				        .clientAuthenticationMethod(resolveClientAuthenticationMethod(rs.getString("client_authentication_method")))
				        .authorizationGrantType(resolveAuthorizationGrantType(rs.getString("authorization_grant_type")))
				        .clientName(rs.getString("client_name"))
				        .redirectUri(rs.getString("redirect_uri"))
				        .scope(scopes)
				        .authorizationUri(rs.getString("authorization_uri"))
				        .tokenUri(rs.getString("token_uri"))
				        .jwkSetUri(rs.getString("jwk_set_uri"))
				        .issuerUri(rs.getString("issuer_uri"))
				        .userInfoUri(rs.getString("user_info_uri"))
				        .userInfoAuthenticationMethod(resolveUserInfoAuthenticationMethod(rs.getString("user_info_authentication_method")))
				        .userNameAttributeName(rs.getString("user_name_attribute_name"));
				 return builder.build();
			} catch ( GreatDataException e) {				
				log.error("GreatDataException while decrypting client_secret {}", e);				
			}      
           return null;
        }

        private static AuthorizationGrantType resolveAuthorizationGrantType(String authorizationGrantType) {
            if (AuthorizationGrantType.AUTHORIZATION_CODE.getValue().equals(authorizationGrantType)) {
                return AuthorizationGrantType.AUTHORIZATION_CODE;
            } else if (AuthorizationGrantType.CLIENT_CREDENTIALS.getValue().equals(authorizationGrantType)) {
                return AuthorizationGrantType.CLIENT_CREDENTIALS;
            } else {
                return AuthorizationGrantType.REFRESH_TOKEN.getValue().equals(authorizationGrantType) ? AuthorizationGrantType.REFRESH_TOKEN : new AuthorizationGrantType(authorizationGrantType);
            }
        }

        private static ClientAuthenticationMethod resolveClientAuthenticationMethod(String clientAuthenticationMethod) {
            if (ClientAuthenticationMethod.CLIENT_SECRET_BASIC.getValue().equals(clientAuthenticationMethod)) {
                return ClientAuthenticationMethod.CLIENT_SECRET_BASIC;
            } else if (ClientAuthenticationMethod.CLIENT_SECRET_POST.getValue().equals(clientAuthenticationMethod)) {
                return ClientAuthenticationMethod.CLIENT_SECRET_POST;
            } else {
                return ClientAuthenticationMethod.NONE.getValue().equals(clientAuthenticationMethod) ? ClientAuthenticationMethod.NONE : new ClientAuthenticationMethod(clientAuthenticationMethod);
            }
        }

        private static AuthenticationMethod resolveUserInfoAuthenticationMethod(String userInfoAuthenticationMethod) {
            if (AuthenticationMethod.FORM.getValue().equals(userInfoAuthenticationMethod)) {
                return AuthenticationMethod.FORM;
            } else if (AuthenticationMethod.HEADER.getValue().equals(userInfoAuthenticationMethod)) {
                return AuthenticationMethod.HEADER;
            } else {
                return AuthenticationMethod.QUERY.getValue().equals(userInfoAuthenticationMethod) ? AuthenticationMethod.QUERY : new AuthenticationMethod(userInfoAuthenticationMethod);
            }
        }

        private Map<String, Object> parseMap(String data) {
            try {
                return this.objectMapper.readValue(data, new TypeReference<Map<String, Object>>() {
                });
            } catch (Exception var3) {
                throw new IllegalArgumentException(var3.getMessage(), var3);
            }
        }
    }

    public static class ClientRegistrationParametersMapper implements Function<ClientRegistration, List<SqlParameterValue>> {
        private ObjectMapper objectMapper = new ObjectMapper();

        public ClientRegistrationParametersMapper() {
            ClassLoader classLoader = JdbcClientRegistrationRepository.class.getClassLoader();
            List<Module> securityModules = SecurityJackson2Modules.getModules(classLoader);
            this.objectMapper.registerModules(securityModules);
        }

        @Override
        public List<SqlParameterValue> apply(ClientRegistration clientRegistration) {
            return Arrays.asList(new SqlParameterValue(12, clientRegistration.getRegistrationId()), new SqlParameterValue(12, clientRegistration.getClientId()), new SqlParameterValue(12, clientRegistration.getClientSecret()), new SqlParameterValue(12, clientRegistration.getClientAuthenticationMethod().getValue()), new SqlParameterValue(12, clientRegistration.getAuthorizationGrantType().getValue()), new SqlParameterValue(12, clientRegistration.getClientName()), new SqlParameterValue(12, clientRegistration.getRedirectUri()), new SqlParameterValue(12, StringUtils.collectionToCommaDelimitedString(clientRegistration.getScopes())), new SqlParameterValue(12, clientRegistration.getProviderDetails().getAuthorizationUri()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getTokenUri()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getJwkSetUri()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getIssuerUri()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getUserInfoEndpoint().getUri()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getUserInfoEndpoint().getAuthenticationMethod().getValue()), new SqlParameterValue(12, clientRegistration.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName()), new SqlParameterValue(12, this.writeMap(clientRegistration.getProviderDetails().getConfigurationMetadata())));
        }

        private String writeMap(Map<String, Object> data) {
            try {
                return this.objectMapper.writeValueAsString(data);
            } catch (Exception var3) {
                throw new IllegalArgumentException(var3.getMessage(), var3);
            }
        }
    }	
}
