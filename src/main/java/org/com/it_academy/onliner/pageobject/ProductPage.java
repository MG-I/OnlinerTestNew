package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage {
    private final SelenideElement productFullName
            = $x("//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'product.full_name')]");
    private final SelenideElement productDescription
            = $x("//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'product.description')]");
    private final SelenideElement productRating
            = $x("//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'reviews.rating')]");
    private final SelenideElement productPrise
            = $x("//div[contains(@class, 'schema-product__group')]//a[contains(@class,'schema-product__price-value ')]");
    private final SelenideElement productImage
            = $x("//div[contains(@class, 'schema-product__group')]//a[contains(@class,'js-product-image-link')]");
    private final SelenideElement productControl
            = $x("//div[contains(@class, 'schema-product__group')]//label[contains(@class,'schema-product__control')]");

    public ProductPage verifyProductFullNameDisplayed() {
        productFullName
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductRatingDisplayed() {
        productRating
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductDescriptionDisplayed() {
        productDescription
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductPriceDisplayed() {
        productPrise
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductImageDisplayed() {
        productImage.shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductControlDisplayed() {
        productControl
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
    public ProductPage verifyProductGroupDisplayed() {
        productControl
                .shouldBe(visible, ofSeconds(30));
        return new ProductPage();
    }
}
