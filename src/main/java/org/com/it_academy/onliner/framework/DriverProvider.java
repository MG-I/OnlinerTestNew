package org.com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

public class DriverProvider implements WebDriverProvider {
    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull Capabilities capabilities) {
        return Driver.getByDriverType(System.getProperty("driverType")).getWebDriverCreator().create();
    }
}
