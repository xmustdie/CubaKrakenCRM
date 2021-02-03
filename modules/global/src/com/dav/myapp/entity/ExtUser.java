package com.dav.myapp.entity;

import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "myapp_ExtUser")
@Extends(User.class)
public class ExtUser extends User {

    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}