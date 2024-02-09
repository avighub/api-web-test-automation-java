package com.techiewolf.api.user;

public enum PrivacyLevel {
  PUBLIC, PRIVATE, CONTACTS;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
