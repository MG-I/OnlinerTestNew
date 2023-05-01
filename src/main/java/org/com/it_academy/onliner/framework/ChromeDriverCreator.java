package org.com.it_academy.onliner.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public RemoteWebDriver create() {
             return new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
    }
}
