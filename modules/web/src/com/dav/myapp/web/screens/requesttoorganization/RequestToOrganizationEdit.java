package com.dav.myapp.web.screens.requesttoorganization;

import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.EmailInfoBuilder;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
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

    @Inject
    private EmailService emailService;

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

    @Subscribe("saveAndSendBtn")
    public void onSaveAndSendBtnClick(Button.ClickEvent event) {
        commitChanges();
        RequestToOrganization requestToOrganization = getEditedEntity();
        String address = requestToOrganization.getOrganization().getEmail();
        String caption = String.format("Запрос в организацию № %d", requestToOrganization.getNumberOfRequest());
        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(address)
                .setBody(requestToOrganization.getTextBodyOfRequest())
                .setCaption(caption)
                .build();
        try {
            emailService.sendEmail(emailInfo);
        } catch (EmailException e) {
            log.info("email sending failed - {} ", e.getMessages());
            return;
        }
        notifications.create()
                .withHideDelayMs(4000)
                .withCaption("Запрос успешно отправлен")
                .withType(Notifications.NotificationType.TRAY)
                .show();
    }
}