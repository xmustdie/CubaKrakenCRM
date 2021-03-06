package com.dav.myapp.web.screens.requesttoorganization;


import com.dav.myapp.entity.RequestToOrganization;
import com.dav.myapp.service.MailingListMemberService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.ContentMode;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@UiController("myapp_RequestToOrganization.browse")
@UiDescriptor("request-to-organization-browse.xml")
@LookupComponent("requestToOrganizationsTable")
@LoadDataBeforeShow
public class RequestToOrganizationBrowse extends StandardLookup<RequestToOrganization> {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RequestToOrganizationBrowse.class);
    @Inject
    protected Table<RequestToOrganization> requestToOrganizationsTable;

    @Inject
    protected DataManager dataManager;

    @Inject
    private MailingListMemberService memberService;

    @Inject
    private Notifications notifications;

    @Inject
    private CollectionLoader<RequestToOrganization> requestToOrganizationsDl;

    @Inject
    private Dialogs dialogs;


    @Subscribe("requestToOrganizationsTable.makeCanceled")
    public void onRequestToOrganizationsTableMakeCanceled(Action.ActionPerformedEvent event) {
        RequestToOrganization requestToOrganization = requestToOrganizationsTable.getSingleSelected();
        String myCaption;
        String myDescription;
        if (requestToOrganization != null && requestToOrganization.getIsCanceled() != null && !requestToOrganization.getIsCanceled()) {
            requestToOrganization.setIsCanceled(true);
            dataManager.commit(requestToOrganization);
            requestToOrganizationsDl.load();
            myCaption = "Операция выполнена";
            myDescription = "Запрос отменён";
        } else {
            myCaption = "Предупреждение";
            myDescription = "Невозможно отменить запрос повторно";
        }
        notifications.create()
                .withCaption(myCaption)
                .withHideDelayMs(3000)
                .withType(Notifications.NotificationType.TRAY)
                .withDescription(myDescription)
                .show();
    }

    @Subscribe("requestToOrganizationsTable.showMailingList")
    public void onRequestToOrganizationsTableShowMailingList(Action.ActionPerformedEvent event) {
        List<String> listMembers = memberService.findListMembers();
        String dialogMessage = listMembers.stream()
                .map(listMember -> "<center>" + listMember + "</center><br>")
                .collect(Collectors.joining());
        log.info(dialogMessage);
        dialogs.createMessageDialog()
                .withCaption("Участники списка рассылки")
                .withMessage(dialogMessage)
                .withCloseOnClickOutside(true)
                .withContentMode(ContentMode.HTML)
                .withWidth("250px")
                .withHeight("200px")
                .show();
    }
}
