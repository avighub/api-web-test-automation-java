package com.techiewolf.config;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

public final class ConfigurationFactory {

  /**
   * This class is restricted to be extended or to be instantiated, Leaving only option to use the
   * static methods via class name
   */
  private ConfigurationFactory() {}

  public static EnvironmentConfig getEnvironmentConfig() {
    ConfigFactory.setProperty("environment", getFrameworkConfig().environment());
    return ConfigCache.getOrCreate(EnvironmentConfig.class);
  }

  public static FrameworkConfig getFrameworkConfig() {
    return ConfigCache.getOrCreate(FrameworkConfig.class);
  }
}
