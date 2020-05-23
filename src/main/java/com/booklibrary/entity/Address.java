package com.booklibrary.entity;

import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull private String address;

  @NotNull private String postCode;

  @NotNull private String city;

  @NotNull private String county;

  @OneToOne(
      mappedBy = "address",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private Reader reader;

  public Address(int id, String address, String postCode, String city, String county) {
    this.id = id;
    this.address = address;
    this.postCode = postCode;
    this.city = city;
    this.county = county;
  }
}
