package com.ilyagubarev.concepts.jwt.simple.server.domain.companies;

import com.ilyagubarev.concepts.jwt.simple.server.domain.users.SupplierUserEntity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Suppling company entity.
 */
@Entity
@Table(name = "supplier_companies")
public class SupplierCompanyEntity extends CompanyEntity {

    @OneToMany(mappedBy = "employees")
    private Collection<SupplierUserEntity> employees;

    @Override
    public String getType() {
        return "SUPPLIER";
    }
}
