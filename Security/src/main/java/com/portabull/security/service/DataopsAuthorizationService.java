package com.portabull.security.service;

import com.portabull.exception.ErrorConstants;
import com.portabull.exception.GreatDataException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Slf4j
public class DataopsAuthorizationService extends JdbcOAuth2AuthorizationService {
	
	private static final String COLUMN_NAMES = "id, "
			+ "registered_client_id, "
			+ "principal_name, "
			+ "authorization_grant_type, "
			+ "attributes, "
			+ "state, "
			+ "authorization_code_value, "
			+ "authorization_code_issued_at, "
			+ "authorization_code_expires_at,"
			+ "authorization_code_metadata,"
			+ "access_token_value,"
			+ "access_token_issued_at,"
			+ "access_token_expires_at,"
			+ "access_token_metadata,"
			+ "access_token_type,"
			+ "access_token_scopes,"
			+ "oidc_id_token_value,"
			+ "oidc_id_token_issued_at,"
			+ "oidc_id_token_expires_at,"
			+ "oidc_id_token_metadata,"
			+ "refresh_token_value,"
			+ "refresh_token_issued_at,"
			+ "refresh_token_expires_at,"
			+ "refresh_token_metadata";
	
	private static final String AUTH_COLUMN_NAMES = "a.id, "
			+ "registered_client_id, "
			+ "principal_name, "
			+ "authorization_grant_type, "
			+ "attributes, "
			+ "state, "
			+ "authorized_scopes, "
			+ "authorization_code_value, "
			+ "authorization_code_issued_at, "
			+ "authorization_code_expires_at,"
			+ "authorization_code_metadata,"
			+ "access_token_value,"
			+ "access_token_issued_at,"
			+ "access_token_expires_at,"
			+ "access_token_metadata,"
			+ "access_token_type,"
			+ "access_token_scopes,"
			+ "oidc_id_token_value,"
			+ "oidc_id_token_issued_at,"
			+ "oidc_id_token_expires_at,"
			+ "oidc_id_token_metadata,"
			+ "refresh_token_value,"
			+ "refresh_token_issued_at,"
			+ "refresh_token_expires_at,"
			+ "refresh_token_metadata, "
			+ "user_code_value, "
		    + "user_code_issued_at, " 
		    + "user_code_expires_at, "
		    + "user_code_metadata, " 
		    + "device_code_value,"
		    + "device_code_issued_at, "
		    + "device_code_expires_at, "
		    +"device_code_metadata ";
	
	private Environment environment;
	
	private static final String UI_CLIENT = "client_id";
	

	private static final String TABLE_NAME = "oauth2_authorization";
	
	private static final String GET_AUTHORIZATION_SQL = "SELECT " + COLUMN_NAMES
			+ " FROM " + TABLE_NAME
			+ " WHERE ";
	
	private static final String GET_ACTIVE_LOGINS = "SELECT " + AUTH_COLUMN_NAMES + " FROM " + TABLE_NAME + " a join oauth2_registered_client c on a.registered_client_id=c.id join t_users u on a.principal_name=u.user_name where " ;

	private static final String DELETE_ACCESS_TOKEN = "delete from "  + TABLE_NAME + " where ";

	private static final String METADATA_ACCESS_TOKEN = "SELECT access_token_metadata FROM " + TABLE_NAME + " WHERE ";

	private static final String UPDATE_METADATA_ACCESS_TOKEN = "UPDATE " + TABLE_NAME + " SET ";

	ObjectMapper objectMapper = new ObjectMapper();

	public DataopsAuthorizationService(JdbcOperations jdbcOperations,
			RegisteredClientRepository registeredClientRepository, Environment environment) {
		
		super(jdbcOperations, registeredClientRepository);
		this.environment = environment;
	}
	
	public DataopsAuthorizationService(JdbcOperations jdbcOperations,
			RegisteredClientRepository registeredClientRepository, LobHandler lobHandler) {
		super(jdbcOperations, registeredClientRepository, lobHandler);
	}
	
//	@Nullable
//	public List<OAuth2Authorization> findActiveLogins(String clientId) {
//
//		String uiClientId = environment.getProperty(UI_CLIENT);
//		String filter = "access_token_expires_at > now() and u.role_id<>4 and principal_name !='system' and client_id= "+"'"+ uiClientId +"'" ;
//
//		List<OAuth2Authorization> authList = getJdbcOperations().query(GET_ACTIVE_LOGINS + filter,
//				getAuthorizationRowMapper());
//
//		// Filter the OAuth2Authorization which have metadata.token.invalidated = false
//		// to find the active users.
//		authList = authList.stream()
//				.filter(eachAuth -> eachAuth.getAccessToken().getMetadata("metadata.token.invalidated") != null
//						&& false == (Boolean) eachAuth.getAccessToken().getMetadata("metadata.token.invalidated"))
//				.collect(Collectors.toList());
//
//		return authList;
//
//	}
	
	public void deleteAccessToken(String userName) {
		log.info("Deleting access token for userName {}", userName);
		String filter = "principal_name = " +"'"+ userName +"'" ;
		getJdbcOperations().update(DELETE_ACCESS_TOKEN + filter);
	}

	public void updateAccessTokenMetadata(String token) throws GreatDataException {
		try {
			List<String> metaData = getJdbcOperations().query(new StringBuilder(METADATA_ACCESS_TOKEN).append(" access_token_value = '").append(token).append("'").toString(), new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("access_token_metadata");
				}
			});
			if (!CollectionUtils.isEmpty(metaData)) {
				Map<String, Object> map = objectMapper.readValue(metaData.get(0), Map.class);
				map.put("logoutCount", 1);
				getJdbcOperations().update(new StringBuilder(UPDATE_METADATA_ACCESS_TOKEN).append( " access_token_metadata='").append(objectMapper.writeValueAsString(map)).append("' WHERE  access_token_value = '").append(token).append("'").toString());
			}
		}catch(Exception e){
			log.error("updating access token metadata {}", e);
            throw new GreatDataException(ErrorConstants.INTERNAL_SERVER_CODE, ErrorConstants.GDP500000_MESSAGE);
		}
	}

}
