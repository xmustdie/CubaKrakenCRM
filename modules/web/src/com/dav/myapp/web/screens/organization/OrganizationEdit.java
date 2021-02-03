package com.dav.myapp.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import com.dav.myapp.entity.Organization;

@UiController("myapp_Organization.edit")
@UiDescriptor("organization-edit.xml")
@EditedEntityContainer("organizationDc")
@LoadDataBeforeShow
public class OrganizationEdit extends StandardEditor<Organization> {
}