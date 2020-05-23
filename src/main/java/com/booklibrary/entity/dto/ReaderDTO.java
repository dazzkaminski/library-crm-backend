package com.booklibrary.entity.dto;

import com.booklibrary.entity.Address;
import com.booklibrary.entity.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderDTO {

  private int id;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private Address address;

  private List<Book> books;
}
