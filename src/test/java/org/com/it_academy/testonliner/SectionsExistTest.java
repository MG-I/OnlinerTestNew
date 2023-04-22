package org.com.it_academy.testonliner;

import org.com.it_academy.onliner.framework.DriverManager;
import org.com.it_academy.onliner.pageobject.CatalogPage;
import org.com.it_academy.onliner.pageobject.Header;
import org.com.it_academy.onliner.pageobject.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class SectionsExistTest extends BaseTest {
    private Header header = new Header();

    @BeforeClass
    public void navigationToHomePage() {
        DriverManager.getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testLinkExist() {
        header
                .clickOnMainNavigationLink("Каталог");
        assertThat(new CatalogPage().getClassifierLinkList())
                .containsAll(Arrays.asList("Электроника", "Компьютеры и сети",
                        "Бытовая техника", "На каждый день", "Стройка и ремонт",
                        "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"));
    }

    @Test
    public void testVerticalListExist() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети");
        assertThat(new CatalogPage().getCatalogClassifierCategoryLinkList())
                .containsAll(Arrays.asList("Электропитание", "Комплектующие", "Ноутбуки, компьютеры, мониторы"));
    }

    @Test
    public void testElementsHaveNameQuantityPrice() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие");
        assertThat(new CatalogPage().isProductQuantityComparison())
                .isTrue();
    }

    @Test
    public void testProductHasElements() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierCategoryLink("Аудиотехника")
                .clickOnProductLink("Наушники");
        assertThat(new ProductPage().isAllElementsForProductIsDisplayed())
                .as("All Elements for product is not displayed")
                .isTrue();
    }
}
