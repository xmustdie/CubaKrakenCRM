package com.dav.myapp.web.screens.widgets;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.model.KeyValueCollectionContainer;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("myapp_Chart")
@UiDescriptor("ChartOne.xml")
@DashboardWidget("ChartOne")
public class ChartOne extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader keyOrgDl;

    @Inject
    private KeyValueCollectionContainer keyOrgDc;

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        keyOrgDl.load();
    }


}
