package com.techiewolf.api.auth;

import static io.restassured.RestAssured.given;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import io.restassured.response.Response;

public final class LoginApi {

  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private LoginApi() {}

  public static Response loginAsValidUser() {
    return login(ENV_CONFIG.username(), ENV_CONFIG.password());
  }

  public static Response login(String username, String password) {
    Login login =
        Login.builder().setType("LOGIN").setUsername(username).setPassword(password).build();

    return login(login);
  }

  public static Response login(Login login) {
    return given()
        .spec(SpecFactory.getBaseSpec())
        .when()
        .body(login)
        .post(ENV_CONFIG.login())
        .then()
        .log()
        .ifError()
        .extract()
        .response();
  }
}
