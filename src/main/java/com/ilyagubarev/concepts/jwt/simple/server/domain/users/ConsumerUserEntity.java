package com.ilyagubarev.concepts.jwt.simple.server.domain.users;

import com.ilyagubarev.concepts.jwt.simple.server.domain.companies.ConsumerCompanyEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Consumer user (consuming company employee).
 */
@Entity
@Table(name = "consumer_users")
public class ConsumerUserEntity extends UserEntity {

    @Column(name = "customer_enabled")
    private boolean customerEnabled;

    @Column(name = "manager_enabled")
    private boolean managerEnabled;

    @Column(name = "company_id")
    private ConsumerCompanyEntity company;

    public boolean isCustomerEnabled() {
        return customerEnabled;
    }

    public boolean isManagerEnabled() {
        return managerEnabled;
    }

    @Override
    public Set<String> getRoles() {
        Set<String> result = new HashSet<>();
        if (customerEnabled) {
            result.add("CUSTOMER");
        }
        if (managerEnabled) {
            result.add("MANAGER");
        }
        return result;
    }

    @Override
    public ConsumerCompanyEntity getCompany() {
        return company;
    }
}
