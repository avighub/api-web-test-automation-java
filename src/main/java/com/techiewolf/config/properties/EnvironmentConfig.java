package com.techiewolf.config.properties;

import org.aeonbits.owner.Config;

/**
 * Owner library makes it painless to manage properties file configuration Refer documentation for
 * more.
 */
@Config.Sources({
  "file:src/main/resources/environment-config/${environment}.properties",
})
public interface EnvironmentConfig extends Config {

  /**
   * Everytime there is a new key added to Environment properties file ensure to add it here.
   * Similarly remove from here if there is a need.
   */
  @Key("webLoginPageUrl")
  String webLoginPageUrl();

  @Key("apiBaseUrl")
  String apiBaseUrl();

  @Key("username")
  String username();

  @Key("password")
  String password();

  @Key("avatar")
  String avatar();

  @Key("login")
  String login();

  @Key("logout")
  String logout();

  @Key("users")
  String users();

  @Key("resetDb")
  String resetDb();
}
