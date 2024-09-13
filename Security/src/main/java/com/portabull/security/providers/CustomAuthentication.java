package com.portabull.security.providers;

import com.portabull.exception.CustomOauthException;
import com.portabull.exception.CustomOauthExceptionUtil;
import com.portabull.exception.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;


@Component
public class CustomAuthentication implements AuthenticationProvider {


    @Autowired
    private PasswordEncoder userPasswordEncoder;

    @Autowired
    private DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher;

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthentication.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String userName = authentication.getPrincipal().toString();
            String password = authentication.getCredentials().toString();
//            if (!(userName.equalsIgnoreCase(user.getUsername()) &&
//                    userPasswordEncoder.matches(CodecUtil.pwdDecrypt(password), user.getPassword()))) {
//                logger.error("Authentication failed for native credentials....");
//                defaultAuthenticationEventPublisher.publishAuthenticationFailure(new BadCredentialsException("Authentication Failure"), authentication);
//                throw new CustomOauthException(String.valueOf(ErrorConstants.UNAUTHORIZED_CODE), CustomOauthExceptionUtil.AUTHENTICATION_FAILURE);
//            }
            Collection<GrantedAuthority> authorities = new HashSet<>();
            if (!password.equalsIgnoreCase("empty"))
                authorities.add(new SimpleGrantedAuthority(password));
            return new UsernamePasswordAuthenticationToken(userName, password, authorities);
        } catch (Exception e) {
            throw new CustomOauthException(String.valueOf(ErrorConstants.UNAUTHORIZED_CODE), CustomOauthExceptionUtil.AUTHENTICATION_FAILURE);
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
