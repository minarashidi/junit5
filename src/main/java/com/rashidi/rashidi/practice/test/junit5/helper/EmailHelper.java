package com.rashidi.rashidi.practice.test.junit5.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class EmailHelper {

  static String createEmailAddress(String firstPart, String secondPart) {
    return firstPart + "." + secondPart + "@gmail.com";
  }

  static boolean isValid(String email) {

    String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(email);
    return m.matches();

  }
}
