package com.techiewolf.tests.api.user;

import com.techiewolf.api.user.UserApi;
import com.techiewolf.api.user.UserCreation;
import com.techiewolf.assertion.VerifyResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


final class CreateUserTest {

  @AfterAll
  static void tearDown() {
    UserApi.resetUsers();
  }

  @Test
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
    VerifyCreateUserResponse.assertThat(createUser)
            .hasUUID()
            .assertAll();
    // TODO: Add assertion for response body by deserializing response to POJO
  }

}
