package com.dav.myapp;

import com.haulmont.cuba.web.testsupport.TestContainer;

import java.util.ArrayList;
import java.util.Arrays;

public class MyappWebTestContainer extends TestContainer {

    public MyappWebTestContainer() {
        appComponents = Arrays.asList(
                "com.haulmont.cuba",
                "com.haulmont.charts",
                "com.haulmont.addon.dashboard");
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the web module
                "com/dav/myapp/web-app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "com/haulmont/cuba/web/testsupport/test-web-app.properties"
        );
    }

    public static class Common extends MyappWebTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
        public static final MyappWebTestContainer.Common INSTANCE = new MyappWebTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}