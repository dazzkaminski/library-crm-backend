package com.booklibrary.entity.dto;

import com.booklibrary.entity.Reader;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

  private int id;

  private String address;

  private String postCode;

  private String city;

  private String county;

  @JsonProperty("readerId")
  private Reader reader;

  public AddressDTO(int id, String address, String postCode, String city, String county) {
    this.id = id;
    this.address = address;
    this.postCode = postCode;
    this.city = city;
    this.county = county;
  }
}
