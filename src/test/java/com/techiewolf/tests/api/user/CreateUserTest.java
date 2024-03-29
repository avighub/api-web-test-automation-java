package com.techiewolf.tests.api.user;

import com.techiewolf.api.user.UserApi;
import com.techiewolf.api.user.UserCreation;
import com.techiewolf.assertion.VerifyResponse;
import com.techiewolf.config.annotations.SanityTest;
import com.techiewolf.config.annotations.SignUpFeature;
import com.techiewolf.setup.TestSetup;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

final class CreateUserTest extends TestSetup {

  @Test
  @SignUpFeature
  @SanityTest
  void testNewUserCanBeCreated() {
    // Arrange
    UserCreation user = UserCreation.getInstance();
    String createUserSchemaPath = "schemas/create-user-schema.json";

    // Act
    Response createUser = UserApi.createUser(user);

    // Assert
    // TODO: Merge two assertions into one
    VerifyResponse.assertThat(createUser)
        .matchStatusCode(201)
        .matchesSchema(createUserSchemaPath)
        .assertAll();
    VerifyCreateUserResponse.assertThat(createUser).hasUUID().assertAll();
    // TODO: Add assertion for response body by deserializing response to POJO
  }
}
