package com.ilyagubarev.concepts.jwt.simple.server.security;

public interface UserPasswordHashFactory {

    String create(String password);
}
