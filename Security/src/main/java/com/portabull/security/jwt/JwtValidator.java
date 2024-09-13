package com.portabull.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Date;

@Component
public class JwtValidator {

    private final KeyStoreUtil keyStoreUtil;

    public JwtValidator(KeyStoreUtil keyStoreUtil) {
        this.keyStoreUtil = keyStoreUtil;
    }

    public Claims extractAllClaims(String token) {
        PublicKey publicKey = keyStoreUtil.getPublicKey();
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
