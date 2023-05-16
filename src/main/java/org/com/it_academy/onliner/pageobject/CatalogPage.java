package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private final ElementsCollection catalogClassifierLink
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
            $$x("//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]/" +
                    "/span[contains(@class, 'dropdown-description')] [contains(text(), ' товар' )] ");

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

    public List<String> getCatalogClassifierCategoryLinks() {
        return catalogClassifierCategoryLink.texts();
    }

    public ProductPage clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(visible, ofSeconds(20))
                .click();
        return new ProductPage();
    }

    public List<String> getClassifierLinksText() {
        return catalogClassifierLink.texts();
    }

    public int getCountOfItemsOnDropdownPage() {
        return productsDropdown.size();
    }

    public int getCountOfTitleOnDropdownPage() {
        return productsDropdownTitle.size();
    }

    public int getCountOfCommodityOnDropdownPage() {
        return productsDropdownDescriptionCommodity.size();
    }

}
