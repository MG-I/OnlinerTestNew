package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class FrameSearch extends BasePage {
    public static final String TITLE_SEARCHED_ELEMENTS_PATTERN = "//div[contains(@class, 'product__title')]/a[contains(text(), '%s')]";
    public final SelenideElement searchCloseIconForFrame = $x("//span[contains(@class, 'search__close')]");
    private final SelenideElement frame = $x("//iframe[@class = 'modal-iframe']");
    private final SelenideElement fastSearchInFrame = $x("//input[contains(@class, 'search__input')]");

    @Step("Go to Frame")
    public FrameSearch switchToFrame() {
        switchTo().frame(frame);
        return this;
    }

    @Step("Verify correct search")
    public void verifyTitleElementSearched(String text) {
        $x(format(TITLE_SEARCHED_ELEMENTS_PATTERN, text))
                .shouldBe(visible, ofSeconds(30));
    }

    @Step("Click on close icon ")
    public Header clickCLoseIcon() {
        searchCloseIconForFrame
                .shouldBe(visible, ofSeconds(30))
                .click();
        return new Header();
    }

    @Step("Add {text} in search field")
    public FrameSearch addTextInFastSearchInFrame(String text) {
        fastSearchInFrame.clear();
        fastSearchInFrame.sendKeys(text);
        return new FrameSearch();
    }
}
