package com.ilyagubarev.concepts.jwt.simple.server.domain.users;

import com.ilyagubarev.concepts.jwt.simple.server.domain.BaseEntity;
import com.ilyagubarev.concepts.jwt.simple.server.domain.companies.CompanyEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Basic user entity.
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "")
    private boolean active;

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFullname() {
        return fullname;
    }

    public boolean isActive() {
        return active;
    }

    public abstract CompanyEntity getCompany();

    public abstract Set<String> getRoles();
}
