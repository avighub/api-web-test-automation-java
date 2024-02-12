package com.techiewolf.tests.unit;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.ConfigurationFactory;
import com.techiewolf.config.EnvironmentConfig;
import com.techiewolf.config.FrameworkConfig;
import com.techiewolf.utility.faker.FakerUtil;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FrameworkSanityTest {

  private final EnvironmentConfig environmentConfig = ConfigurationFactory.getEnvironmentConfig();


  @Test
  @Tag("unittest")
  void testFrameworkConfig() {
    FrameworkConfig frameworkConfig = ConfigurationFactory.getFrameworkConfig();
    Assertions.assertThat(frameworkConfig.environment()).isNotNull();
  }

  @Test
  @Tag("unittest")
  void testEnvironmentConfig() {
    Assertions.assertThat(environmentConfig.apiBaseUrl()).isNotNull();
  }

  @Test
  @Tag("unittest")
  void testSpecFactory() {
    RequestSpecification requestSpecification = SpecFactory.getBaseSpec();
    Assertions.assertThat(requestSpecification).isNotNull();
  }

  @Test
  @Tag("unittest")
  void testFakerUtil() {
    Assertions.assertThat(FakerUtil.getRandomEmail()).isNotNull();
  }
}
