package com.booklibrary.backend.exception;

public class AddressNotFoundException extends RuntimeException {

  public AddressNotFoundException(String message) {
    super(message);
  }

  public AddressNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressNotFoundException(Throwable cause) {
    super(cause);
  }

  protected AddressNotFoundException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}