package com.techiewolf.config.extensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
  private static final ThreadLocal<Double> testExecutionTimeThread = new ThreadLocal<>();
  private long testStartTime;

  public static Double getTestExecutionTime() {
    return testExecutionTimeThread.get();
  }

  public static void resetTestExecutionTime() {
    testExecutionTimeThread.remove();
    log.debug("Removed test execution time from thread.");
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) {
    testStartTime = System.currentTimeMillis();
  }

  @Override
  public void afterTestExecution(ExtensionContext context) {
    // Calculate test execution duration in seconds
    double testExecutionDuration = (System.currentTimeMillis() - testStartTime) / 1000.0;
    log.info(
        "Test: {} took {} second(s).",
        context.getRequiredTestMethod().getName(),
        String.format("%.2f", testExecutionDuration));
    testExecutionTimeThread.set(testExecutionDuration);
  }
}
