package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class Header extends BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";
    private final SelenideElement fastSearch = $x("//div[@id='fast-search']//input[contains(@class, 'fast-search__input')]");
    private final SelenideElement fastSearchButton = $x("//div[@id='fast-search']//button[contains(@class, 'fast-search__submit')]");
    public CatalogPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))
                .shouldBe(and("clickable", visible, enabled), ofSeconds(30))
                .click();
        return new CatalogPage();
    }
    @Step("Click on search field")
    public Header clickInSearchField() {
        fastSearch.shouldBe(visible, ofSeconds(10))
                .click();
        return this;
    }
    @Step("Clear search field")
    public Header clearInSearchField() {
        fastSearch.shouldBe(visible, ofSeconds(10))
                .clear();
        return this;
    }
    @Step("Add {text} in search field")
    public FrameSearch addTextInSearch(String text) {
        fastSearch.clear();
        fastSearch.sendKeys(text);
        return new FrameSearch();
    }
    public Header ExistFromFrame() {
        switchTo().defaultContent();
        return new Header();
    }
}
