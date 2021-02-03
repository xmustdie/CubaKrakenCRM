package com.dav.myapp.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import com.dav.myapp.entity.Organization;

@UiController("myapp_Organization.browse")
@UiDescriptor("organization-browse.xml")
@LookupComponent("organizationsTable")
@LoadDataBeforeShow
public class OrganizationBrowse extends StandardLookup<Organization> {
}