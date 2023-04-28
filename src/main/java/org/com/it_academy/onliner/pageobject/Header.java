package org.com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class Header extends BasePage{
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";
       public CatalogPage clickOnMainNavigationLink(String link) {
           $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))
                   .shouldBe(and("clickable",visible, enabled), ofSeconds(40))
                   .click();
        return new CatalogPage();
    }
}
