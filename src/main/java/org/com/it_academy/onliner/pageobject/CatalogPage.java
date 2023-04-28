package org.com.it_academy.onliner.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
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
    private static final String CATALOG_CLASSIFIER_LINK_LIST =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]";
    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";
    private final String CATALOG_CLASSIFIER__CATEGORY_LINK_LIST =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') ]";
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final String PRODUCT_DROPDOWN_LIST =
            "//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]//a";
    private static final String PRODUCT_DROPDOWN_TITLE_LIST =
            "//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-title')]";
    private static final String PRODUCT_DROPDOWN_DESCRIPTION_LIST_COMMODITY =
            "//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-description')] [contains(text(), ' товар' )] ";
    private static final String PRODUCT_DROPDOWN_DESCRIPTION_LIST_AVERAGE_PRICE =
            "//div[contains(@class, 'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]" +
                    "//span[contains(@class, 'dropdown-description')]/br[contains(text(), '')]";
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
    public List<String> getCatalogClassifierCategoryLinkList() {
        return getListElements(By.xpath(format(CATALOG_CLASSIFIER__CATEGORY_LINK_LIST)));
    }

        public ProductPage clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(visible, ofSeconds(40))
                .click();

        return new ProductPage();
    }
    public List<String> getClassifierLinkList() {
        return getListElements(By.xpath(format(CATALOG_CLASSIFIER_LINK_LIST)));
    }
    public int getCountOfItemsOnDropdownPage() {
        return getCountElements(By.xpath(format(PRODUCT_DROPDOWN_LIST)));
    }
    public int getCountOfTitleOnDropdownPage() {
        return getCountElements(By.xpath(format(PRODUCT_DROPDOWN_TITLE_LIST)));
    }
    public int getCountOfCommodityOnDropdownPage() {
        return getCountElements(By.xpath(format(PRODUCT_DROPDOWN_DESCRIPTION_LIST_COMMODITY)));
    }
    public int getCountOfAveragePriceOnDropdownPage() {
        return getCountElements(By.xpath(format(PRODUCT_DROPDOWN_DESCRIPTION_LIST_AVERAGE_PRICE)));
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
