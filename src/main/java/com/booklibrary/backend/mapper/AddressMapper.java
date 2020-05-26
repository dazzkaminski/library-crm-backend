package com.booklibrary.backend.mapper;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.entity.dto.AddressDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

  public List<AddressDTO> mapToAddressDtoList(List<Address> addresses) {
    return addresses.stream()
        .map(
            address ->
                new AddressDTO(
                    address.getId(),
                    address.getAddress(),
                    address.getPostCode(),
                    address.getCity(),
                    address.getCounty()))
        .collect(Collectors.toList());
  }

  public AddressDTO mapToAddressDto(Address address) {
    return new AddressDTO(
        address.getId(),
        address.getAddress(),
        address.getPostCode(),
        address.getCity(),
        address.getCounty());
  }

  public Address mapToAddress(AddressDTO addressDTO) {
    return new Address(
        addressDTO.getId(),
        addressDTO.getAddress(),
        addressDTO.getPostCode(),
        addressDTO.getCity(),
        addressDTO.getCounty());
  }
}
