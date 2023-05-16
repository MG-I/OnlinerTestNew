package org.com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import org.com.it_academy.onliner.rest_api.model.SushiveslaSearch;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSearchEndpoint;
import static org.com.it_academy.onliner.rest_api.util.GetRequestUtils.makeGetRequestAndGetResponseBody;

public class SushiveslaService {

    public List<SushiveslaSearch> getSushiveslaSearch() {
        return makeGetRequestAndGetResponseBody(getCatalogSearchEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiveslaSearch.class);
    }

    public List<String> getSushiveslaSearchWithParams(String param) {
        return makeGetRequestAndGetResponseBody(getCatalogSearchEndpoint(), configureHeaders(), configureParams(param))
                .jsonPath()
                .getList("products.name_prefix", String.class);
    }

    public List<String> getSushiveslaSearchName() {
        return getSushiveslaSearch()
                .stream()
                .map(name -> name.getName())
                .collect(Collectors.toList());
    }

    private static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    private static Map<String, Object> configureParams(String param) {
        return ImmutableMap.of("sushi_typ[0]", param,
                "sushi_typ[operation]", "union");
    }
}
