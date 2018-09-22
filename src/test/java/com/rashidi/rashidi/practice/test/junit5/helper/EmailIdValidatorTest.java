package com.rashidi.rashidi.practice.test.junit5.helper;

import com.rashidi.rashidi.practice.test.junit5.helper.EmailHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(value = Parameterized.class)
public class EmailIdValidatorTest {

  private String emailAddress;

  private boolean expected;

  public EmailIdValidatorTest(String emailAddress, boolean expected) {
    this.emailAddress = emailAddress;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: isValid({0})={1}")
  public static Iterable<Object[]> data() {

    return Arrays.asList(new Object[][]{
        {"mina@gmail.com", true},
        {"mina.smith@gmail.com", true},
        {"mina_smith123@gmail.com", true},
        {"mina@gmaildotcom", false},
        {"mina-smith@gmail", false},
        {"gmail.com", false}
      }
    );
  }

  @Test
  public void testEmailAddress() throws Exception {

    boolean actual = EmailHelper.isValid(emailAddress);
    assertThat(actual, is(equalTo(expected)));
  }
}
