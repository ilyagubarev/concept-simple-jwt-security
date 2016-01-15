package com.ilyagubarev.concepts.jwt.simple.server.domain.companies;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Suppling company entity.
 */
@Entity
@Table(name = "supplier_companies")
public class SupplierCompanyEntity extends CompanyEntity {

    @Override
    public String getType() {
        return "SUPPLIER";
    }
}
