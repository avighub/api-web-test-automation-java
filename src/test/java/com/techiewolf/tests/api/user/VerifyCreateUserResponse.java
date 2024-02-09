package com.techiewolf.tests.api.user;

import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

// TODO: Implement SELF_TYPE to use Both VerifyResponse and API Specific response
// Restricting to extend this class and abuse inheritance
public final class VerifyCreateUserResponse {
  private Response response;
  private SoftAssertions softAssertions;

  // Restricting to create instance of this class
  private VerifyCreateUserResponse(Response response) {
    this.response = response;
    this.softAssertions = new SoftAssertions();
  }

  // Only possible entry point for the assertion class
  public static VerifyCreateUserResponse assertThat(Response response) {
    return new VerifyCreateUserResponse(response);
  }

  public VerifyCreateUserResponse hasUUID() {
    softAssertions.assertThat(
                    response.getBody().jsonPath().getString("user.uuid"))
            .describedAs("UUID")
            // regex for v4 UUID
            .matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$");

    return this;
  }


  public void assertAll() {
    softAssertions.assertAll();
  }


}
