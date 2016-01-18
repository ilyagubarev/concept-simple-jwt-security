package com.ilyagubarev.concepts.jwt.simple.server.security;

import java.io.Serializable;

import java.util.Set;
import java.util.UUID;
import java.time.Instant;

public class UserAuthentication implements Serializable {

    private UUID id;
    private String passwordHash;
    private String companyType;
    private Set<String> roles;
    private Instant authenticated;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Instant getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Instant authenticated) {
        this.authenticated = authenticated;
    }
}
