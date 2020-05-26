package com.booklibrary.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

  private String mailTo;

  private String toCc;

  private String subject;

  private String message;
}
