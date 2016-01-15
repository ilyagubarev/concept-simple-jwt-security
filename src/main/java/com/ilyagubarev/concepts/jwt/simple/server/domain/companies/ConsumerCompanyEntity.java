package com.ilyagubarev.concepts.jwt.simple.server.domain.companies;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Consuming company entity.
 */
@Entity
@Table(name = "consumer_companies")
public class ConsumerCompanyEntity extends CompanyEntity {

    @Override
    public String getType() {
        return "CONSUMER";
    }
}
