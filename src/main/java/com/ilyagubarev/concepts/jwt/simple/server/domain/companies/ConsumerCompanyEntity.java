package com.ilyagubarev.concepts.jwt.simple.server.domain.companies;

import com.ilyagubarev.concepts.jwt.simple.server.domain.users.ConsumerUserEntity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Consuming company entity.
 */
@Entity
@Table(name = "consumer_companies")
public class ConsumerCompanyEntity extends CompanyEntity {

    @OneToMany(mappedBy = "employees")
    private Collection<ConsumerUserEntity> employees;

    @Override
    public String getType() {
        return "CONSUMER";
    }
}
