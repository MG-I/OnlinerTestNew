package org.com.it_academy.onliner.pageobject;

import org.com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {
    private final WebDriver driver;
    public BasePage() {
        driver = DriverManager.getWebDriver();
    }
    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(30));
        return wait.until(elementToBeClickable(by));
    }
    public List<String> getListElements(By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
    public int getCountElements(By by) {
        List<WebElement> elements = driver.findElements(by);
        return (int) elements.stream()
                .map(element -> element.getText())
                .count();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void fillInFieldWithValue(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }
    public boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void performValidationInLastOpenedWindowTabAndCloseItAfter(Supplier action) {
        String currentWindowHandle = driver.getWindowHandle();
        switchToLastOpenedWindow(currentWindowHandle);
        try {
            action.get();
        } finally {
            driver.close();
            driver.switchTo().window(currentWindowHandle);
        }
    }
    public void switchToLastOpenedWindow(String currentWindowHandle) {
        String lastWindowHandle = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentWindowHandle))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("No window handle found"));
        driver.switchTo().window(lastWindowHandle);
    }
}
