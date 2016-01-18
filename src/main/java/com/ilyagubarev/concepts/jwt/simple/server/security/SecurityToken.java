package com.ilyagubarev.concepts.jwt.simple.server.security;

import java.io.Serializable;

public class SecurityToken implements Serializable {

    private String value;

    public SecurityToken(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
