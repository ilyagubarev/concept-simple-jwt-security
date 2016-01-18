package com.ilyagubarev.concepts.jwt.simple.server.security.impls;

import io.jsonwebtoken.Jwts;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityToken;
import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityTokenService;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserAuthentication;
import io.jsonwebtoken.Claims;
import java.time.Instant;


public class JwtSecurityTokenService implements SecurityTokenService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public SecurityToken tokenize(UserAuthentication authentication) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserAuthentication detokenize(SecurityToken token) {
        Claims body = getTokenBody(token);
        if (isTokenExpired(body)) {
            throw new RuntimeException("token is expired");
        }
        return readAuthentication(body.getSubject());
    }

    private Claims getTokenBody(SecurityToken token) {
        return Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token.toString())
                .getBody();
    }

    private boolean isTokenExpired(Claims tokenBody) {
        Instant expiration = Instant.ofEpochMilli(tokenBody.getExpiration().getTime());
        return Instant.now().isAfter(expiration);
    }

    private UserAuthentication readAuthentication(String json) {
        try {
            return MAPPER.readValue(json, UserAuthentication.class);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private String writeAuthentication(UserAuthentication authentication) {
        try {
            return MAPPER.writeValueAsString(authentication);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    } 
}
