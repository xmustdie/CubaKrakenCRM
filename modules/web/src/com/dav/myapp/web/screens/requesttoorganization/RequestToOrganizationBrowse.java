package com.dav.myapp.web.screens.requesttoorganization;

import com.haulmont.cuba.gui.screen.*;
import com.dav.myapp.entity.RequestToOrganization;

@UiController("myapp_RequestToOrganization.browse")
@UiDescriptor("request-to-organization-browse.xml")
@LookupComponent("requestToOrganizationsTable")
@LoadDataBeforeShow
public class RequestToOrganizationBrowse extends StandardLookup<RequestToOrganization> {
}