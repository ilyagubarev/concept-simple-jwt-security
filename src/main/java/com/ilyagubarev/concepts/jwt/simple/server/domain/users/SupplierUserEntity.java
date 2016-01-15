package com.ilyagubarev.concepts.jwt.simple.server.domain.users;

import com.ilyagubarev.concepts.jwt.simple.server.domain.companies.SupplierCompanyEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Supplier user (suppling company employee).
 */
@Entity
@Table(name = "supplier_users")
public class SupplierUserEntity extends UserEntity {

    @Column(name = "delivery_enabled")
    private boolean deliveryEnabled;

    @Column(name = "manager_enabled")
    private boolean managerEnabled;

    @ManyToOne
    @Column(name = "company_id")
    private SupplierCompanyEntity company;

    public boolean isDeliveryEnabled() {
        return deliveryEnabled;
    }

    public boolean isManagerEnabled() {
        return managerEnabled;
    }

    @Override
    public Set<String> getRoles() {
        Set<String> result = new HashSet<>();
        if (deliveryEnabled) {
            result.add("DELIVERY");
        }
        if (managerEnabled) {
            result.add("MANAGER");
        }
        return result;
    }

    @Override
    public SupplierCompanyEntity getCompany() {
        return company;
    }
}
