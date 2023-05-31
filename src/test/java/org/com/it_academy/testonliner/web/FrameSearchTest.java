package org.com.it_academy.testonliner.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.com.it_academy.onliner.pageobject.Header;
import org.com.it_academy.onliner.pageobject.OnlinerURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class FrameSearchTest extends BaseTest {
    protected static final Logger LOG = LoggerFactory.getLogger(FrameSearchTest.class);
    private Header header = new Header();

    @BeforeMethod
    public void navigationToHomePage() {
        LOG.info("Home page {} is opened", OnlinerURL.ONLINER_HOME);
        getWebDriver().get(OnlinerURL.ONLINER_HOME);
    }

    @Test
    public void testSearchElement() {
        LOG.info("Test Search element is started");
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Наушники")
                .switchToFrame()
                .verifyTitleElementSearched("Наушники");
        LOG.info("Test Search element is passed");
    }

    @Test
    @Description("Checking the operation of the close icon of the search window")
    @Story("SF125")
    @Severity(SeverityLevel.CRITICAL)
    public void testCloseSearchForm() {
        LOG.info("Test Close Search Form is started");
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Сумка")
                .switchToFrame()
                .clickCLoseIcon();
        assertThat(new Header().getUrlForCurrentPage().contains("https://www.onliner.by/"));
        LOG.info("Test Close Search Form is passed");
    }

    @Test
    public void testReSearch() {
        LOG.info("Test ReSearch is started");
        header
                .clearInSearchField()
                .clickInSearchField()
                .addTextInSearch("Градусник")
                .switchToFrame()
                .addTextInFastSearchInFrame("стол")
                .verifyTitleElementSearched("тол");
        LOG.info("Test ReSearch is passed");
    }
}
