package com.ilyagubarev.concepts.jwt.simple.server.domain.companies;

import com.ilyagubarev.concepts.jwt.simple.server.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Basic company entity.
 */
@Entity
@Table(name = "companies")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CompanyEntity extends BaseEntity {

    public abstract String getType();
}
