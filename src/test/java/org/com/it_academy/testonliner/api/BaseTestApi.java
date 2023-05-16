package org.com.it_academy.testonliner.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

public class BaseTestApi {

    @BeforeMethod
    public void init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true));
    }
}
