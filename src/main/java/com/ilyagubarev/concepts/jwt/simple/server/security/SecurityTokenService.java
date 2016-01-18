package com.ilyagubarev.concepts.jwt.simple.server.security;

public interface SecurityTokenService {

    SecurityToken tokenize(UserAuthentication authentication);

    UserAuthentication detokenize(SecurityToken token);
}
