package org.com.it_academy.onliner.rest_api.util;

import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class GetRequestUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(GetRequestUtils.class);

    private GetRequestUtils() {
    }

    public static ResponseBody makeGetRequestAndGetResponseBody(String endpoint, Map<String, Object> headers, Map<String, Object> params) {
        LOG.info("request endpoint {} {} {}", endpoint, headers, params);
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }
}
