package com.booklibrary.entity.dto;

import com.booklibrary.entity.Reader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

  private int id;

  private String title;

  private String description;

  private String author;

  private String releaseDate;

  private boolean isAvailable;

  @JsonProperty("readerId")
  private Reader reader;

  public BookDTO(String title, String description, String author,
      String releaseDate, boolean isAvailable) {
    this.title = title;
    this.description = description;
    this.author = author;
    this.releaseDate = releaseDate;
    this.isAvailable = isAvailable;
  }
}
