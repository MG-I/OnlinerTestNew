package org.com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.rmi.Remote;

public class DriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
  public RemoteWebDriver createDriver(Capabilities capabilities){
      return Driver.getByDriverType(System.getProperty("driverType")).getWebDriverCreator().create();
  }
}
