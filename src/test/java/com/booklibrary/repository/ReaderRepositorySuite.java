//package com.booklibrary.repository;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import com.booklibrary.entity.Address;
//import com.booklibrary.entity.Reader;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ReaderRepositorySuite {
//
//  @Autowired private ReaderRepository readerRepository;
//
//  @Test
//  public void createReaderTest() {
//    // Given
//    Address address = new Address("111 Poplar Avenue", "B178El", "Birmingham", "West Midlands");
//    Reader reader = new Reader("John", "Smith", "0789123456", "john@mail.com", address);
//
//    // When
//    readerRepository.save(reader);
//    Reader tempReader = readerRepository.findById(reader.getId()).get();
//
//    // Then
//    System.out.println(reader);
//    assertNotNull(tempReader);
//  }
//}
