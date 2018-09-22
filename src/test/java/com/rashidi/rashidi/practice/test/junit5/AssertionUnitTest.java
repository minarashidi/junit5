package com.rashidi.rashidi.practice.test.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test case for assertions")
class AssertionUnitTest {

  @Test
  void usingSupplierInFailMessage() {
    assertTrue(IntStream.of(1, 2, 3)
      .sum() > 5, () -> "Sum should be greater than 5");
  }

  @Test
  void groupAssertions() {
    int[] numbers = {0, 1, 2, 3, 4};
    assertAll("numbers",
      () -> assertEquals(numbers[0], 0),
      () -> assertEquals(numbers[3], 3),
      () -> assertEquals(numbers[4], 4)
    );
  }

  @Test
  @DisplayName("Comparing arrays; Arrays should be equals")
  void whenAssertingArraysEquality_thenEqual() {
    char[] expected = {'J', 'u', 'n', 'i', 't'};
    char[] actual = "Junit".toCharArray();

    assertArrayEquals(expected, actual, "Arrays should be equal");
  }

  @Test
  @DisplayName("comparing lists; Should contain the same elements")
  void shouldContainSameElements() {
    List<Integer> FIRST = Arrays.asList(1, 2, 3);
    List<Integer> SECOND = Arrays.asList(1, 2, 3);

    assertIterableEquals(FIRST, SECOND);
  }

  @Test
  @DisplayName("Should throw an exception with the correct message")
  void shouldThrowAnExceptionWithCorrectMessage() {

    final RuntimeException thrown = assertThrows(
      RuntimeException.class,
      () -> {
        throw new RuntimeException("Hello World!");
      }
    );

    assertEquals("Hello World!", thrown.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenConvertingToInteger() {
    String age = "eighteen";
    assertThrows(NumberFormatException.class, () -> {
      convertToInt(age);
    });
  }

  private static Integer convertToInt(String str) {
    if (str == null) {
      return null;
    }
    return Integer.valueOf(str);
  }

}
