package com.portabull.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class CustomAuthenticationFailureHandler
        implements AuthenticationFailureHandler {
	
	//TODO - Single instance of object mapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authenticationException)
            throws IOException {
        
        if (null != authenticationException){

            if(authenticationException instanceof CustomOauthException) {
                OutputStream responseStream = null;
                CustomOauthException oauthException = (CustomOauthException) authenticationException;
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType(MediaType.APPLICATION_NDJSON_VALUE);
                Map<String, String> data = CustomOauthExceptionUtil.createErrorResponseMap(oauthException.getError().getErrorCode(), oauthException.getError().getDescription());
                if (null!= data && !data.isEmpty()){
                    try{
                        responseStream = response.getOutputStream();
                        responseStream.write(objectMapper.writeValueAsString(data).getBytes());
                    } finally {
                        if(null!=  responseStream){
                            responseStream.close();
                            responseStream.flush();
                        }
                    }
                }
            }
            else if(authenticationException instanceof OAuth2AuthenticationException) {
            	  OutputStream responseStream = null;
            	  OAuth2AuthenticationException oauthException = (OAuth2AuthenticationException) authenticationException;
                  response.setStatus(HttpStatus.BAD_REQUEST.value());
                  response.setContentType(MediaType.APPLICATION_NDJSON_VALUE);
                  Map<String, String> data = CustomOauthExceptionUtil.createErrorResponseMap(oauthException.getError().getErrorCode(), "session_expired");
                  if (null!= data && !data.isEmpty()){
                      try{
                          responseStream = response.getOutputStream();
                          responseStream.write(objectMapper.writeValueAsString(data).getBytes());
                      } finally {
                          if(null!=  responseStream){
                              responseStream.close();
                              responseStream.flush();
                          }
                      }
                  }              
            }            
            else {
            	
               throw authenticationException;
            }
        }
    }
}
