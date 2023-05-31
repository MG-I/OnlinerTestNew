package org.com.it_academy.testonliner.web;

import org.com.it_academy.onliner.pageobject.CatalogPage;
import org.com.it_academy.onliner.pageobject.Header;
import org.com.it_academy.onliner.pageobject.OnlinerURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SectionsExistTest extends BaseTest {

    protected static final Logger LOG = LoggerFactory.getLogger(SectionsExistTest.class);
    private Header header = new Header();

    @BeforeMethod
        public void navigationToHomePage() {
        LOG.info("Home page {} is opened", OnlinerURL.ONLINER_HOME);
        getWebDriver().get(OnlinerURL.ONLINER_HOME);
    }

    @Test
    public void testLinkExist() {
        LOG.info("Test LinkExist is started");
        header
                .clickOnMainNavigationLink("Каталог");
        assertThat(new CatalogPage().getClassifierLinksText())
                .containsAll(Arrays.asList("Электроника", "Компьютеры и сети",
                        "Бытовая техника", "На каждый день", "Стройка и ремонт",
                        "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"));
        LOG.info("Test LinkExist is passed");
    }

    @Test
    public void testVerticalListExist() {
        LOG.info("Test VerticalListExist is started");
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети");
        assertThat(new CatalogPage().getCatalogClassifierCategoryLinks())
                .containsAll(Arrays.asList("Электропитание", "Комплектующие", "Ноутбуки, компьютеры, мониторы"));
        LOG.info("Test VerticalListExist is passed");
    }

    @Test
    public void testElementsHaveNameQuantityPrice() {
        LOG.info("Test ElementsHaveNameQuantityPrice is started");
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие");
        assertThat(new CatalogPage().getCountOfItemsOnDropdownPage()).isEqualTo(new CatalogPage().getCountOfCommodityOnDropdownPage());
        assertThat(new CatalogPage().getCountOfItemsOnDropdownPage()).isEqualTo(new CatalogPage().getCountOfTitleOnDropdownPage());
        LOG.info("Test ElementsHaveNameQuantityPrice is passed");
    }

    @Test
    public void testProductHasElements() {
        LOG.info("Test ProductHasElements is started");
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
        LOG.info("Test ProductHasElements is passed");
    }
}