package com.rashidi.rashidi.practice.test.junit5.helper;

import com.rashidi.rashidi.practice.test.junit5.helper.EmailHelper;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class EmailAddressCreatorTest {

  @DataPoints
  public static String[] names() {
    return new String[]{"first", "second", "abc", "123", null};
  }

  @DataPoint
  public static String name = "mina";

  @Theory
  public void testCreateEmailAddress(String firstPart, String secondPart) throws Exception {

    assumeNotNull(firstPart, secondPart);
//    System.out.println(String.format("Testing with %s and %s", firstPart, secondPart));

    String actual = EmailHelper.createEmailAddress(firstPart, secondPart);

    assertThat(actual, is(allOf(containsString(firstPart), containsString(secondPart))));

  }
}
