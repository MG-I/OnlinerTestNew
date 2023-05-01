package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.com.it_academy.onliner.framework.DriverManager;

public class BasePage {
    public BasePage() {
        DriverManager.initDriver();
    }
    public int getCountOfElementsWithText(ElementsCollection elementsCollection) {
        return elementsCollection.size();
    }
    public String getUrlForCurrentPage() {
        return WebDriverRunner.url();
    }
}
