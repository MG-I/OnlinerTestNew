package org.com.it_academy.testonliner;

import com.codeborne.selenide.Selenide;
import org.com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public  void init(){
       DriverManager.initDriver(System.getProperty("driverType"));
     //   DriverManager.initDriver("chrome");
    }

   @AfterTest
    public void closeBrowser() {
       Selenide.closeWebDriver();
   }
}
