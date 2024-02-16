package com.techiewolf.api.user;

import static com.techiewolf.utility.faker.FakerUtil.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(setterPrefix = "set")
public final class UserCreation {
  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String username;
  private String password;
  private String confirmPassword;
  private String avatar;
  private int balance;
  private String defaultPrivacyLevel;

  public static UserCreation getInstance() {
    String password = getRandomPassword();
    return UserCreation.builder()
        .setFirstName(getRandomFirstName())
        .setLastName(getRandomLastName())
        .setEmail(getRandomEmail())
        .setPhoneNumber(getRandomPhoneNumber())
        .setUsername(getRandomUsername())
        .setPassword(password)
        .setConfirmPassword(password)
        .setAvatar(ENV_CONFIG.avatar())
        .setBalance(100)
        .setDefaultPrivacyLevel(PrivacyLevel.PUBLIC.toString())
        .build();
  }
}
