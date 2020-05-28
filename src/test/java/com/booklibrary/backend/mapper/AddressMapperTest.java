package com.booklibrary.backend.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.entity.dto.AddressDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddressMapperTest {

  @Autowired
  private AddressMapper addressMapper;

  @Test
  void mapToAddressDtoList() {
    // Given
    Address address = new Address(1, "Address", "Postcode", "City", "Country");
    List<Address> addresses = new ArrayList<>();
    addresses.add(address);

    // When
    List<AddressDTO> addressDTOs = addressMapper.mapToAddressDtoList(addresses);

    // Then
    assertEquals(1, addressDTOs.size());
  }

  @Test
  void mapToAddressDto() {
    // Given
    Address address = new Address(1, "Address", "Postcode", "City", "County");

    // When
    AddressDTO addressDTO = addressMapper.mapToAddressDto(address);

    //Then
    assertNotNull(addressDTO);
    assertEquals(Integer.valueOf(1), addressDTO.getId());
    assertEquals("Address", addressDTO.getAddress());
    assertEquals("Postcode", addressDTO.getPostCode());
    assertEquals("City", addressDTO.getCity());
    assertEquals("County", addressDTO.getCounty());
  }

  @Test
  void mapToAddress() {
    // Given
    AddressDTO addressDTO = new AddressDTO(1, "Address", "Postcode", "City", "County");

    // When
    Address address = addressMapper.mapToAddress(addressDTO);

    // Then
    assertNotNull(address);
    assertEquals("Address", address.getAddress());
    assertEquals("Postcode", address.getPostCode());
    assertEquals("City", address.getCity());
    assertEquals("County", address.getCounty());
  }
}