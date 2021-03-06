package com.booklibrary.backend.service;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.repository.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired private AddressRepository addressRepository;

  public List<Address> getAddresses() {
    return addressRepository.findAll();
  }

  public Address getAddress(int id) {
    return addressRepository.findById(id).get();
  }

  public void saveOrUpdate(Address Address) {
    addressRepository.save(Address);
  }

  public void deleteAddress(int id) {
    addressRepository.deleteById(id);
  }
}
