package com.dav.myapp.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ForTaxesTypeOrganization implements EnumClass<String> {

    RESIDENT("Резидент"),
    NONRESIDENT("Нерезидент");

    private String id;

    ForTaxesTypeOrganization(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ForTaxesTypeOrganization fromId(String id) {
        for (ForTaxesTypeOrganization at : ForTaxesTypeOrganization.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}