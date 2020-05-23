package com.booklibrary.exception;

import com.booklibrary.error.AddressErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressRestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<AddressErrorResponse> handleException(AddressNotFoundException exception) {

    AddressErrorResponse error =
        new AddressErrorResponse(
            HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<AddressErrorResponse> handleException(Exception exception) {

    AddressErrorResponse error =
        new AddressErrorResponse(
            HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
