package org.com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;
import static java.lang.String.format;
public class ProductPage extends BasePage {
    private static final String PRODUCT_PAGE_TITLE_XPATH_PATTERN =
            "//*[contains(@class, 'header_title') and contains(text(), '%s')]";
    private static final String PRODUCT_FULL_NAME =
            "//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'product.full_name')]";
    private static final String PRODUCT_DESCRIPTION =
            "//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'product.description')]";
    private static final String PRODUCT_RATING =
            "//div[contains(@class, 'schema-product__group')]//span[contains(@data-bind,'reviews.rating')]";
    private static final String PRODUCT_PRICE =
            "//div[contains(@class, 'schema-product__group')]//a[contains(@class,'schema-product__price-value ')]";
    private static final String PRODUCT_IMAGE =
            "//div[contains(@class, 'schema-product__group')]//a[contains(@class,'js-product-image-link')]";
    private static final String PRODUCT_CONTROL =
            "//div[contains(@class, 'schema-product__group')]//label[contains(@class,'schema-product__control')]";
    public boolean isProductFullNameDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_FULL_NAME)));
    }
    public boolean isProductRatingDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_RATING)));
    }
    public boolean isProductDescriptionDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_DESCRIPTION)));
    }
    public boolean isProductPriceDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_PRICE)));
    }
    public boolean isProductImageDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_IMAGE)));
    }
    public boolean isProductControlDisplayed() {
        return isElementDisplayed(By.xpath(format(PRODUCT_CONTROL)));
    }
    public boolean isAllElementsForProductIsDisplayed() {
        boolean fullNameIsDisplayed = isProductFullNameDisplayed();
        boolean ratingIsDisplayed = isProductRatingDisplayed();
        boolean descriptionIsDisplayed = isProductDescriptionDisplayed();
        boolean priceIsDisplayed = isProductPriceDisplayed();
        boolean imageIsDisplayed = isProductImageDisplayed();
        boolean controlIsDisplayed = isProductControlDisplayed();
        return fullNameIsDisplayed && ratingIsDisplayed && descriptionIsDisplayed && priceIsDisplayed &&
                imageIsDisplayed && controlIsDisplayed;
    }
}
