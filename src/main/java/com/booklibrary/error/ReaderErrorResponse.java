package com.booklibrary.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReaderErrorResponse {

  private int status;

  private String message;

  private long timeStamp;
}
