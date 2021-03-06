package com.booklibrary.backend.entity.dto;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.entity.Book;
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

  private List<Book> books;
}
