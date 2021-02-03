package com.dav.myapp.entity;

import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "MYAPP_REQUEST_TO_ORGANIZATION")
@Entity(name = "myapp_RequestToOrganization")
public class RequestToOrganization extends StandardEntity {
    private static final long serialVersionUID = -1102640884418197394L;

    @NumberFormat(pattern = "########")
    @Column(name = "NUMBER_OF_REQUEST", unique = true)
    private Long numberOfRequest;

    @JoinColumn(name = "ORGANIZATION_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(DeletePolicy.UNLINK)
    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @OnDeleteInverse(DeletePolicy.DENY)
    private Organization organization;

    @Lob
    @Column(name = "TEXT_BODY_OF_REQUEST")
    private String textBodyOfRequest;

    @JoinTable(name = "MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK",
            joinColumns = @JoinColumn(name = "REQUEST_TO_ORGANIZATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    private List<User> mailingList;

    public List<User> getMailingList() {
        return mailingList;
    }

    public void setMailingList(List<User> mailingList) {
        this.mailingList = mailingList;
    }

    public String getTextBodyOfRequest() {
        return textBodyOfRequest;
    }

    public void setTextBodyOfRequest(String textBodyOfRequest) {
        this.textBodyOfRequest = textBodyOfRequest;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Long getNumberOfRequest() {
        return numberOfRequest;
    }

    public void setNumberOfRequest(Long numberOfRequest) {
        this.numberOfRequest = numberOfRequest;
    }
}