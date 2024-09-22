package com.portabull.security.validators;

import com.portabull.exception.UnAuthorizedException;
import com.portabull.security.jwt.JwtValidator;
import com.portabull.security.RequestHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginTokenValidator {

    private final JwtValidator jwtValidator;

    private final String clientId;

    public LoginTokenValidator(@Value("${portabull-clientId}") String clientId, JwtValidator jwtValidator) {
        this.clientId = clientId;
        this.jwtValidator = jwtValidator;
    }


    @Before("execution(* com.portabull.controllers.LoginController.*(..))")
    public void beforeAdvice() {
        HttpServletRequest currentRequest = RequestHelper.getCurrentRequest();
        String token = currentRequest.getHeader("X-Auth-Token");
        if (!jwtValidator.validateToken(token)) {
            throw new UnAuthorizedException("Invalid User");
        }

        if (!currentRequest.getHeader("clientId").equalsIgnoreCase(this.clientId)) {
            throw new UnAuthorizedException("Invalid User");
        }

        String userEmail = jwtValidator.extractUsername(token);

        currentRequest.getHeader("requestId");
    }


}
