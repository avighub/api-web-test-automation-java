package com.techiewolf.basespec;

import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import java.util.List;

/** Restricting this class to be extended and instantiated */
public final class SpecFactory {

  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private SpecFactory() {}

  public static RequestSpecification getBaseSpec() {
    // Blacklisting headers would mask the sensitive token info in logs or reports
    RestAssuredConfig blacklistCookieHeader =
        RestAssuredConfig.config()
            .logConfig(LogConfig.logConfig().blacklistHeaders(List.of("Cookie", "Authorization")));

    return new RequestSpecBuilder()
        .addHeader("Content-Type", "application/json")
        .setBaseUri(ENV_CONFIG.apiBaseUrl())
        .build()
        .config(blacklistCookieHeader);
  }
}
