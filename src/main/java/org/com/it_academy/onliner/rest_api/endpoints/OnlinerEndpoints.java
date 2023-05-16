package org.com.it_academy.onliner.rest_api.endpoints;

import org.com.it_academy.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String getCatalogSearchEndpoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla");
    }
}
