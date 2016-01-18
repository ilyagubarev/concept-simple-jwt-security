package com.ilyagubarev.concepts.jwt.simple.server.security;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("securityContext")
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SecurityContext implements Serializable {

    private Optional<UserAuthentication> authentication;

    public SecurityContext() {
        this.authentication = Optional.empty();
    }

    public Optional<UserAuthentication> getAuthentication() {
        return authentication;
    }

    public void setAuthentication(UserAuthentication authentication) {
        this.authentication = Optional.of(authentication);
    }

    public boolean hasCompanyType(String companyType) {
        return authentication.isPresent() ? authentication.get().getCompanyType().equals(companyType) : false;
    }

    public boolean hasRole(String role) {
        return authentication.isPresent() ? authentication.get().getRoles().contains(role) : false;
    }
}
