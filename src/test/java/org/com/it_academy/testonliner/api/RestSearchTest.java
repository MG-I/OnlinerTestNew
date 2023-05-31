package org.com.it_academy.testonliner.api;

import org.assertj.core.api.Assertions;
import org.com.it_academy.onliner.rest_api.service.SushiveslaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestSearchTest extends BaseTestApi {

    protected static final Logger LOG = LoggerFactory.getLogger(RestSearchTest.class);

    @Test
    public void checkingThatNameAreNotEmpty() {
        LOG.info("Test checkingThatNameAreNotEmpty is started");
        List<String> name = new SushiveslaService().getSushiveslaSearchName();
        for (int i = 0; i < name.size(); i++) {
            Assert.assertFalse(name.get(i).isEmpty());
        }
        LOG.info("Test checkingThatNameAreNotEmpty is passed");
    }

    @Test
    public void checkingThatNamePrefixContainsValueFilterSelected() {
        LOG.info("Test checkingThatNamePrefixContainsValueFilterSelected is started");
        List<String> name_prefix = new SushiveslaService().getSushiveslaSearchWithParams("roll");
        Assertions.assertThat(name_prefix).allMatch(name -> name.equals("Роллы"));
        LOG.info("Test checkingThatNamePrefixContainsValueFilterSelected is passed");
    }
}

