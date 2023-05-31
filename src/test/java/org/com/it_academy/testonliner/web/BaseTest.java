package org.com.it_academy.testonliner.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.com.it_academy.onliner.framework.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    @BeforeMethod
    public void init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        LOG.info("initDriver");
        DriverManager.initDriver();
    }
}
