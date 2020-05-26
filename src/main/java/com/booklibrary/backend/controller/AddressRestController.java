package com.booklibrary.backend.controller;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.entity.dto.AddressDTO;
import com.booklibrary.backend.exception.AddressNotFoundException;
import com.booklibrary.backend.mapper.AddressMapper;
import com.booklibrary.backend.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddressRestController {

  @Autowired private AddressService addressService;

  @Autowired private AddressMapper addressMapper;

  @GetMapping("/addresses")
  public List<AddressDTO> getAddresses() {
    return addressMapper.mapToAddressDtoList(addressService.getAddresses());
  }

  @GetMapping("/addresses/{addressId}")
  public AddressDTO getAddress(@PathVariable int addressId) {

    Address address = addressService.getAddress(addressId);

    if (address == null) {
      throw new AddressNotFoundException("Address with id: " + addressId + " not found");
    }

    return addressMapper.mapToAddressDto(address);
  }

  @PostMapping("/addresses")
  public void createAddress(@RequestBody AddressDTO addressDTO) {
    addressService.saveOrUpdate(addressMapper.mapToAddress(addressDTO));
  }

  @PutMapping("/addresses")
  public void updateAddress(@RequestBody AddressDTO addressDTO) {
    addressService.saveOrUpdate(addressMapper.mapToAddress(addressDTO));
  }

  @DeleteMapping("/addresses/{addressId}")
  public void deleteAddress(@PathVariable int addressId) {

    Address address = addressService.getAddress(addressId);

    if (address == null) {
      throw new AddressNotFoundException("Address with id: " + addressId + " not found");
    }

    addressService.deleteAddress(addressId);
  }
}
