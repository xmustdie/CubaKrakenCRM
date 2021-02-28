package com.dav.myapp.web.screens.requesttoorganization;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.screen.*;
import com.dav.myapp.entity.RequestToOrganization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@UiController("myapp_RequestToOrganization.edit")
@UiDescriptor("request-to-organization-edit.xml")
@EditedEntityContainer("requestToOrganizationDc")
@LoadDataBeforeShow()
public class RequestToOrganizationEdit extends StandardEditor<RequestToOrganization> {
    private static final Logger log = LoggerFactory.getLogger(RequestToOrganizationEdit.class);

    @Inject
    private Notifications notifications;

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Subscribe
    protected void onBeforeCommit(BeforeCommitChangesEvent event) {
        // ToDo - разобраться с инициализацией MySequence
        if (getEditedEntity().getNumberOfRequest() == null) {
            long autoRequestNumber = uniqueNumbersService.getNextNumber("MySequence");
            notifications.create()
                    .withHideDelayMs(4000)
                    .withCaption("Отсутствует номер запроса")
                    .withDescription("Запросу автоматически присвоен номер: " + autoRequestNumber)
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
            log.info("Request got autoincrement number {}", autoRequestNumber);
            getEditedEntity().setNumberOfRequest(autoRequestNumber);
        }
    }
}