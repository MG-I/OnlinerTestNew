package org.com.it_academy.testonliner;

import org.com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    @AfterSuite
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
