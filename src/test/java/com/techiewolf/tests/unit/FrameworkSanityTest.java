package com.techiewolf.tests.unit;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.annotations.UnitTest;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import com.techiewolf.config.properties.FrameworkConfig;
import com.techiewolf.utility.faker.FakerUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FrameworkSanityTest {

  private final EnvironmentConfig environmentConfig = ConfigurationFactory.getEnvironmentConfig();

  @Test
  @UnitTest
  @Description("Test framework config")
  @Severity(SeverityLevel.BLOCKER)
  void testFrameworkConfig() {
    FrameworkConfig frameworkConfig = ConfigurationFactory.getFrameworkConfig();
    Assertions.assertThat(frameworkConfig.environment()).isNotNull();
  }

  @Test
  @UnitTest
  @Severity(SeverityLevel.BLOCKER)
  void testEnvironmentConfig() {
    Assertions.assertThat(environmentConfig.apiBaseUrl()).isNotNull();
  }

  @Test
  @UnitTest
  @Severity(SeverityLevel.BLOCKER)
  void testSpecFactory() {
    RequestSpecification requestSpecification = SpecFactory.getBaseSpec();
    Assertions.assertThat(requestSpecification).isNotNull();
  }

  @Test
  @UnitTest
  @Severity(SeverityLevel.BLOCKER)
  @Link("JIRA-123")
  void testFakerUtil() {
    Assertions.assertThat(FakerUtil.getRandomEmail()).isNotNull();
  }
}
