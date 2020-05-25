package com.booklibrary.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String title;

  private String description;

  private String author;

  private String releaseDate;

  private boolean isAvailable;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id &&
        isAvailable == book.isAvailable &&
        Objects.equals(title, book.title) &&
        Objects.equals(description, book.description) &&
        Objects.equals(author, book.author) &&
        Objects.equals(releaseDate, book.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, author, releaseDate, isAvailable);
  }
}
