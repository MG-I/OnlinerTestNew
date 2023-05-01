package org.com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class DriverManager {
    public static void initDriver() {
        Configuration.browser = DriverProvider.class.getName();
        Configuration.pageLoadTimeout = 200000;
        open();
    }
}
