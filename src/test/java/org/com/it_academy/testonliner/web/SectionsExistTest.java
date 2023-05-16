package org.com.it_academy.testonliner.web;

import org.com.it_academy.onliner.pageobject.CatalogPage;
import org.com.it_academy.onliner.pageobject.Header;
import org.com.it_academy.onliner.pageobject.OnlinerURL;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SectionsExistTest extends BaseTest {
    private Header header = new Header();

    @BeforeMethod
    public void navigationToHomePage() {
        getWebDriver().get(OnlinerURL.ONLINER_HOME);
    }

    @Test
    public void testLinkExist() {
        header
                .clickOnMainNavigationLink("Каталог");
        assertThat(new CatalogPage().getClassifierLinksText())
                .containsAll(Arrays.asList("Электроника", "Компьютеры и сети",
                        "Бытовая техника", "На каждый день", "Стройка и ремонт",
                        "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"));
    }

    @Test
    public void testVerticalListExist() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети");
        assertThat(new CatalogPage().getCatalogClassifierCategoryLinks())
                .containsAll(Arrays.asList("Электропитание", "Комплектующие", "Ноутбуки, компьютеры, мониторы"));
    }

    @Test
    public void testElementsHaveNameQuantityPrice() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие");
        assertThat(new CatalogPage().getCountOfItemsOnDropdownPage()).isEqualTo(new CatalogPage().getCountOfCommodityOnDropdownPage());
        assertThat(new CatalogPage().getCountOfItemsOnDropdownPage()).isEqualTo(new CatalogPage().getCountOfTitleOnDropdownPage());
    }

    @Test
    public void testProductHasElements() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierCategoryLink("Аудиотехника")
                .clickOnProductLink("Наушники")
                .verifyProductGroupDisplayed()
                .verifyProductFullNameDisplayed()
                .verifyProductControlDisplayed()
                .verifyProductDescriptionDisplayed()
                .verifyProductImageDisplayed()
                .verifyProductRatingDisplayed()
                .verifyProductPriceDisplayed();
    }
}