package com.rashidi.rashidi.practice.test.junit5.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
