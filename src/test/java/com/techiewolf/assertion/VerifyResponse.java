package com.techiewolf.assertion;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

// Restricting to extend this class and abuse inheritance
public final class VerifyResponse {
  private Response response;
  private SoftAssertions softAssertions;

  // Restricting to create instance of this class
  private VerifyResponse(Response response) {
    this.response = response;
    this.softAssertions = new SoftAssertions();
  }

  // Only possible entry point for the assertion class
  public static VerifyResponse assertThat(Response response) {
    return new VerifyResponse(response);
  }

  // Method chaining can only happen via above entry method
  // Using hard assertion for status code as fatal validation
  public VerifyResponse matchStatusCode(int statusCode) {
    Assertions.assertThat(response.statusCode()).describedAs("Status Code").isEqualTo(statusCode);

    return this;
  }

  // Using soft assertion for non fatal validations
  public VerifyResponse contains(String value) {
    softAssertions
        .assertThat(response.getBody().asString())
        .describedAs("Contains")
        .contains(value);

    return this;
  }

  public VerifyResponse matchesSchema(String schemaFilePath) {
    softAssertions
        .assertThat(response.then().body(matchesJsonSchemaInClasspath(schemaFilePath)))
        .describedAs("")
        .getWritableAssertionInfo();

    return this;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }
}
