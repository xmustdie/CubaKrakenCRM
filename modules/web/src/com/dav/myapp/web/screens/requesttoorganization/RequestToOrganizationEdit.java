package com.dav.myapp.web.screens.requesttoorganization;

import com.haulmont.cuba.gui.screen.*;
import com.dav.myapp.entity.RequestToOrganization;

@UiController("myapp_RequestToOrganization.edit")
@UiDescriptor("request-to-organization-edit.xml")
@EditedEntityContainer("requestToOrganizationDc")
public class RequestToOrganizationEdit extends StandardEditor<RequestToOrganization> {
}