package com.dav.myapp.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "MYAPP_ORGANIZATION")
@Entity(name = "myapp_Organization")
public class Organization extends StandardEntity {
    private static final long serialVersionUID = 8612800900809283157L;

    @NotNull
    @Column(name = "NAME_ORGANIZATION", nullable = false)
    private String nameOrganization;

    @NotNull
    @Column(name = "SHORT_NAME_ORGANIZATION", nullable = false)
    private String shortNameOrganization;

    @Column(name = "EMAIL", length = 50)
    @NotEmpty
    private String email;

    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

    @Column(name = "TAXES_TYPE_ORGANIZATION")
    private String taxesTypeOrganization;

    public ForTaxesTypeOrganization getTaxesTypeOrganization() {
        return taxesTypeOrganization == null ? null : ForTaxesTypeOrganization.fromId(taxesTypeOrganization);
    }

    public void setTaxesTypeOrganization(ForTaxesTypeOrganization taxesTypeOrganization) {
        this.taxesTypeOrganization = taxesTypeOrganization == null ? null : taxesTypeOrganization.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShortNameOrganization() {
        return shortNameOrganization;
    }

    public void setShortNameOrganization(String shortNameOrganization) {
        this.shortNameOrganization = shortNameOrganization;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }
}