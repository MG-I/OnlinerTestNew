package org.com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class DriverManager {
//    private static ThreadLocal<RemoteWebDriver> driver =
//            new ThreadLocal();
//    private static void setWebDriver() {
//        driver.set(new ChromeDriver());
//        driver.get().manage().window().maximize();
//        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//    }
//    public static WebDriver getWebDriver() {
//        if (driver.get() == null) {
//            setWebDriver();
//        }
//        return driver.get();
//    }
//    public static void closeBrowser() {
//        driver.get().close();
//        driver.remove();
//    }

    public static void initDriver(String type){
        Configuration.browser = DriverProvider.class.getName();
        Configuration.pageLoadTimeout = 200000;
        open();
    }
}
