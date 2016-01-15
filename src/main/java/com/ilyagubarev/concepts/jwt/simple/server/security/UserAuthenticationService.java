package com.ilyagubarev.concepts.jwt.simple.server.security;

public interface UserAuthenticationService {

    UserAuthentication authenticate(UserCredentials credentials);
}
