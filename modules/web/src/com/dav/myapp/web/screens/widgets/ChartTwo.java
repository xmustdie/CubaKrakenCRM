package com.dav.myapp.web.screens.widgets;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.model.KeyValueCollectionContainer;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("myapp_Charttwo")
@UiDescriptor("ChartTwo.xml")
@DashboardWidget("ChartOne")
public class ChartTwo extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader keyOrgByTypesDl;

    @Inject
    private KeyValueCollectionContainer keyOrgByTypesDc;

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        keyOrgByTypesDl.load();
    }
}