package com.booklibrary.backend.exception;

import com.booklibrary.backend.error.BookErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReaderRestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exception) {

    BookErrorResponse error =
        new BookErrorResponse(
            HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<BookErrorResponse> handleException(Exception exception) {

    BookErrorResponse error =
        new BookErrorResponse(
            HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
