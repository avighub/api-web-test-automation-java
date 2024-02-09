package com.techiewolf.config;

import org.aeonbits.owner.Config;

/**
 * Owner library makes it painless to manage properties file configuration
 * Refer documentation for more.
 */
@Config.Sources({
        "classpath:framework-config.properties",
})
public interface FrameworkConfig extends Config {
  /**
   * Everytime there is a new key added to Framework properties file
   * ensure to add it here. Similarly remove from here if there is a need.
   */
  @Key("test.environment")
  @DefaultValue("local")
  String environment();

  @Key("browser")
  @DefaultValue("chrome")
  String browser();

  @Key("browser.isHeadless")
  @DefaultValue("true")
  boolean isBrowserHeadless();

  @Key("log.level")
  @DefaultValue("DEBUG")
  String logLevel();

}
