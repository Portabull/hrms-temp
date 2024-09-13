package com.portabull.controllers;

import com.portabull.models.UserLoginResponse;
import com.portabull.security.RequestHelper;
import com.portabull.security.jwt.JwtValidator;
import com.portabull.security.service.OauthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JwtValidator jwtValidator;

    @Autowired
    OauthTokenService service;


    @PostMapping("login")
    public ResponseEntity<?> login() {

        String userName = jwtValidator.extractUsername(RequestHelper.getCurrentRequest().getHeader("X-Auth-Token"));

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, "password");

        OAuth2AccessTokenAuthenticationToken accessToken = service.createAccessToken(usernamePasswordAuthenticationToken, "dataopssuite-application-client");

        UserLoginResponse response = new UserLoginResponse();

        response.setJwtToken(accessToken.getAccessToken().getTokenValue());

        response.setRedirectURI("http://localhost:8798/");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
