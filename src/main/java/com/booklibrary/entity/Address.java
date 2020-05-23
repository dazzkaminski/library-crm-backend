package com.booklibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String address;

  private String postCode;

  private String city;

  private String county;

  @OneToOne(mappedBy = "address")
  @JsonIgnore
  private Reader reader;

  public Address(int id,String address, String postCode, String city, String county) {
    this.id = id;
    this.address = address;
    this.postCode = postCode;
    this.city = city;
    this.county = county;
  }
}
