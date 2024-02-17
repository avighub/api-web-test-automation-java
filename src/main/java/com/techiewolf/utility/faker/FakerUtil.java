package com.techiewolf.utility.faker;

import java.util.List;
import java.util.Random;
import net.datafaker.Faker;

public final class FakerUtil {
  private static final Faker FAKER = new Faker();
  private static Random random = new Random();

  private FakerUtil() {}

  public static String getRandomFirstName() {
    return getAlphabetsOnlyString(FAKER.name().firstName());
  }

  private static String getAlphabetsOnlyString(String input) {
    return input.replaceAll("[^a-zA-Z]+", "");
  }

  public static String getRandomLastName() {
    return getAlphabetsOnlyString(FAKER.name().lastName());
  }

  public static String getRandomString(int length) {
    return FAKER.lorem().characters(length);
  }

  public static String getRandomUsername() {
    return FAKER.internet().username();
  }

  public static String getRandomPhoneNumber() {
    return FAKER.phoneNumber().phoneNumber();
  }

  public static int getRandomNumber() {
    return FAKER.number().randomDigit();
  }

  public static int getRandomNumberInBetween(int min, int max) {
    return FAKER.number().numberBetween(min, max);
  }

  public static String getRandomValueFromList(List<String> values) {
    int randomIndex = random.nextInt(values.size());
    return values.get(randomIndex);
  }

  public static String getRandomEmail() {
    return "automation_" + FAKER.internet().safeEmailAddress();
  }

  public static String getRandomPassword() {
    return FAKER.internet().password(8, 10, true);
  }
}
