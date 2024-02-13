package com.techiewolf.tests.unit;

import com.techiewolf.annotations.UnitTest;
import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.ConfigurationFactory;
import com.techiewolf.config.EnvironmentConfig;
import com.techiewolf.config.FrameworkConfig;
import com.techiewolf.utility.faker.FakerUtil;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FrameworkSanityTest {

  private final EnvironmentConfig environmentConfig = ConfigurationFactory.getEnvironmentConfig();


  @Test
  @UnitTest
  void testFrameworkConfig() {
    FrameworkConfig frameworkConfig = ConfigurationFactory.getFrameworkConfig();
    Assertions.assertThat(frameworkConfig.environment()).isNotNull();
  }

  @Test
  @UnitTest
  void testEnvironmentConfig() {
    Assertions.assertThat(environmentConfig.apiBaseUrl()).isNotNull();
  }

  @Test
  @UnitTest
  void testSpecFactory() {
    RequestSpecification requestSpecification = SpecFactory.getBaseSpec();
    Assertions.assertThat(requestSpecification).isNotNull();
  }

  @Test
  @UnitTest
  void testFakerUtil() {
    Assertions.assertThat(FakerUtil.getRandomEmail()).isNotNull();
  }
}
