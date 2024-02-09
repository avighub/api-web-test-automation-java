package com.techiewolf.api.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder(setterPrefix = "set")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Accessors(chain = true)
public class Login {
  private String type;
  private String username;
  private String password;
}
