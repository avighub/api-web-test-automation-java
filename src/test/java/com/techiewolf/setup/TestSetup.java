package com.techiewolf.setup;

import com.techiewolf.api.testdata.TestDataApi;
import com.techiewolf.config.extensions.TimingExtension;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
public class TestSetup {
  @Step("Reset Database")
  @AfterAll
  static void resetDatabase() {
    TestDataApi.resetDatabase();
  }

  @Step("Remove Test Execution Time Thread")
  @AfterEach
  public void removeTestExecutionTimeThread() {
    TimingExtension.resetTestExecutionTime();
  }
}
