package com.techiewolf.api.user;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class UserApi {
  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private UserApi() {}

  public static Response createRandomUser() {
    UserCreation userCreation = UserCreation.getInstance();
    log.debug("New Random User is created: {}", userCreation);
    return createUser(userCreation);
  }

  public static Response createUser(UserCreation userCreation) {
    log.debug("New User is created: {}", userCreation);
    return RestAssured.given()
        .spec(SpecFactory.getBaseSpec())
        .body(userCreation)
        .when()
        .post(ENV_CONFIG.users())
        .then()
        .log()
        .ifError()
        .extract()
        .response();
  }
}
