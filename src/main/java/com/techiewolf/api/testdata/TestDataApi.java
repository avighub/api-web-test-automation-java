package com.techiewolf.api.testdata;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TestDataApi {
  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private TestDataApi() {}

  public static void resetDatabase() {
    log.debug("Database  is reset");
    RestAssured.given()
        .spec(SpecFactory.getBaseSpec())
        .when()
        .post(ENV_CONFIG.resetDb())
        .then()
        .log()
        .ifError()
        .extract()
        .response();
  }
}
