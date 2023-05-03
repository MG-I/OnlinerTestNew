package org.com.it_academy.testonliner;

import org.com.it_academy.onliner.pageobject.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class FrameSearchTest extends BaseTest {
    private Header header = new Header();

    @BeforeMethod
    public void navigationToHomePage() {
        getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testSearchElement() {
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Наушники")
                .SwitchToFrame()
                .verifyTitleElementSearched("Наушники");
        header.ExistFromFrame();
    }

    @Test
    public void testCloseSearchForm() {
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Сумка")
                .SwitchToFrame()
                .clickCLoseIcon()
                .ExistFromFrame();
        assertThat(new Header().getUrlForCurrentPage().contains("https://www.onliner.by/"));
    }

    @Test
    public void testReSearch() {
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Градусник")
                .SwitchToFrame()
                .addTextInFastSearchInFrame("стол")
                .verifyTitleElementSearched("тол");
        header.ExistFromFrame();
    }
}
