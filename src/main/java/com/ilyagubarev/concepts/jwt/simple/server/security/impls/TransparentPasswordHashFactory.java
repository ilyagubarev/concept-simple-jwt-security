package com.ilyagubarev.concepts.jwt.simple.server.security.impls;

import org.springframework.stereotype.Component;

import com.ilyagubarev.concepts.jwt.simple.server.security.UserPasswordHashFactory;

@Component
public class TransparentPasswordHashFactory implements UserPasswordHashFactory {

    @Override
    public String create(String password) {
        return password;
    }
}
