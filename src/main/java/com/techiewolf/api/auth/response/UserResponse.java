package com.techiewolf.api.auth.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techiewolf.api.user.PrivacyLevel;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
  private String id;
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private String avatar;
  private PrivacyLevel defaultPrivacyLevel;
  private Long balance;
  private String createdAt;
  private String modifiedAt;
}
