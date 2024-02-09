package com.techiewolf.tests.api.auth;

import com.techiewolf.api.auth.Login;
import com.techiewolf.api.auth.LoginApi;
import com.techiewolf.api.user.UserApi;
import com.techiewolf.api.user.UserCreation;
import com.techiewolf.assertion.VerifyResponse;
import com.techiewolf.tests.api.user.VerifyCreateUserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Set;


final class LoginTest {

  private UserCreation userCreation;
  private String usernname;
  private String password;

  @AfterAll
  static void tearDown() {
    UserApi.resetUsers();
  }

  @BeforeEach
  void setup(final TestInfo testInfo) {
    // Adding tag to skip BeforeEach for the tests that do not need
    final Set<String> testTags = testInfo.getTags();
    if (testTags.stream()
            .anyMatch(tag -> tag.equals("skipBeforeEach"))
    ) {
      return;
    }
    userCreation = UserCreation.getInstance();
    usernname = userCreation.getUsername();
    password = userCreation.getPassword();
    UserApi.createUser(userCreation);
  }

  @Test
  void testLoginUsingValidCredentialsShouldReturnUserInfo() {
    // Arrange
    String loginValidUserSchemaPath = "schemas/login-valid-user-schema.json";

    // Act
    Response loginResponse = LoginApi.login(usernname, password);

    // Assert
    VerifyResponse.assertThat(loginResponse)
            .matchStatusCode(200)
            .matchesSchema(loginValidUserSchemaPath)
            .assertAll();
    VerifyCreateUserResponse.assertThat(loginResponse)
            .hasUUID()
            .assertAll();
  }

  @Test
  @Tag("skipBeforeEach")
  void testLoginUsingInValidCredentialsShouldReturn401() {

    // Act
    Response loginResponse = LoginApi.login("InvalidUsername", "InvalidPassword");

    // Assert
    VerifyResponse.assertThat(loginResponse)
            .matchStatusCode(401)
            .contains("Unauthorized")
            .assertAll();
  }

  @Test
  @Tag("skipBeforeEach")
  void testRequestWithMissingUsernameShouldReturn400() {
    // Arrange
    Login login = Login.builder()
            .setType("Login")
            .setPassword("dummyPassword")
            .build();
    // Act
    Response loginResponse = LoginApi.login(login);

    // Assert
    VerifyResponse.assertThat(loginResponse)
            .matchStatusCode(400)
            .contains("Bad Request")
            .assertAll();
  }

}