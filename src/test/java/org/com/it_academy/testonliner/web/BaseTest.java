package org.com.it_academy.testonliner.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        DriverManager.initDriver();
    }
}
