package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private final ElementsCollection CATALOG_CLASSIFIER_LINK_LIST
            = $$x("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");
    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";
    private final ElementsCollection catalogClassifierCategoryLink =
            $$x("//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') ]");
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private final ElementsCollection productsDropdown =
            $$x("//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]//a");
    private final ElementsCollection productsDropdownTitle =
            $$x("//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-title')]");
    private final ElementsCollection productsDropdownDescriptionCommodity =
            $$x("//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-description')] [contains(text(), ' товар' )] ");
    private final ElementsCollection productsDropdownAveragePrice =
            $$x("//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-description')]/br[normalize-space(text())]");
    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(40))
                .click();
        return this;
    }
    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        $x(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(40))
                .click();
        return this;
    }
    public List<String> getCatalogClassifierCategoryLink() {
        return catalogClassifierCategoryLink.texts();
    }
    public ProductPage clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(visible, ofSeconds(20))
                .click();
        return new ProductPage();
    }
    public List<String> getClassifierLinkText() {
        return CATALOG_CLASSIFIER_LINK_LIST.texts();
    }
    public int getCountOfItemsOnDropdownPage() {
        return getCountOfElementsWithText(productsDropdown);
    }
    public int getCountOfTitleOnDropdownPage() {
        return getCountOfElementsWithText(productsDropdownTitle);
    }
    public int getCountOfCommodityOnDropdownPage() {
        return getCountOfElementsWithText(productsDropdownDescriptionCommodity);
    }
    public int getCountOfAveragePriceOnDropdownPage() {
        return getCountOfElementsWithText(productsDropdownAveragePrice);
    }
    public boolean isProductQuantityComparison() {
        int countItems = getCountOfItemsOnDropdownPage();
        int countTitle = getCountOfTitleOnDropdownPage();
        int countCommodity = getCountOfCommodityOnDropdownPage();
        int countAveragePrice = getCountOfAveragePriceOnDropdownPage();
        int countParameters = 4;
        int[] countsList = {countItems, countTitle, countCommodity, countAveragePrice};
        int sumValue = Arrays.stream(countsList).sum();
        return sumValue / countParameters == countItems;
    }
}
