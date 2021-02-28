package com.dav.myapp.web.screens;

import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@UiController("myapp_Statistics")
@UiDescriptor("statistics.xml")
@LoadDataBeforeShow
public class Statistics extends Screen {
}