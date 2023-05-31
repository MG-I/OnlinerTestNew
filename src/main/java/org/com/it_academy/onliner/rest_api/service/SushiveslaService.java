package org.com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import org.com.it_academy.onliner.rest_api.model.SushiveslaSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSearchEndpoint;
import static org.com.it_academy.onliner.rest_api.util.GetRequestUtils.makeGetRequestAndGetResponseBody;

public class SushiveslaService {
    protected static final Logger LOG = LoggerFactory.getLogger(SushiveslaService.class);

    public List<SushiveslaSearch> getSushiveslaSearch() {
        return makeGetRequestAndGetResponseBody(getCatalogSearchEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiveslaSearch.class);
    }

    public List<String> getSushiveslaSearchWithParams(String param) {
        List<String> list = makeGetRequestAndGetResponseBody(getCatalogSearchEndpoint(), configureHeaders(), configureParams(param))
                .jsonPath()
                .getList("products.name_prefix", String.class);
        LOG.warn(" List response {}", list);
        return list;
    }

    public List<String> getSushiveslaSearchName() {
        List<String> list = getSushiveslaSearch()
                .stream()
                .map(name -> name.getName())
                .collect(Collectors.toList());
        LOG.warn(" List response {}", list);
        return list;
    }

    private static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    private static Map<String, Object> configureParams(String param) {
        return ImmutableMap.of("sushi_typ[0]", param,
                "sushi_typ[operation]", "union");
    }
}
