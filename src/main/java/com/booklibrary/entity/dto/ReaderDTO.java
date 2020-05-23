package com.booklibrary.entity.dto;

import com.booklibrary.entity.Address;
import com.booklibrary.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDTO {

  private int id;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private Address address;

  @JsonProperty("title")
  private List<Book> books;

  public ReaderDTO(
      int id,
      String firstName,
      String lastName,
      String phoneNumber,
      String email,
      Address address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }
}
