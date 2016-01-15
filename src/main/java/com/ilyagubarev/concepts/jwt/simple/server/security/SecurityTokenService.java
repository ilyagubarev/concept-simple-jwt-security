package com.ilyagubarev.concepts.jwt.simple.server.security;

public interface SecurityTokenService {

    String create(UserAuthentication claims);
}
