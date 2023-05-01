package org.com.it_academy.testonliner;

import com.codeborne.selenide.Selenide;
import org.com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void init() {
        DriverManager.initDriver();
    }
    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
