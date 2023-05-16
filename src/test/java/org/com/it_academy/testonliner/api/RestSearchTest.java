package org.com.it_academy.testonliner.api;

import org.assertj.core.api.Assertions;
import org.com.it_academy.onliner.rest_api.service.SushiveslaService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestSearchTest {

    @Test
    public void checkingThatNameAreNotEmpty() {
        List<String> name = new SushiveslaService().getSushiveslaSearchName();
        for (int i = 0; i < name.size(); i++) {
            Assert.assertFalse(name.get(i).isEmpty());
        }
    }

    @Test
    public void checkingThatNamePrefixContainsValueFilterSelected() {
        List<String> name_prefix = new SushiveslaService().getSushiveslaSearchWithParams("roll");
        Assertions.assertThat(name_prefix).allMatch(name -> name.equals("Роллы"));
    }
}

