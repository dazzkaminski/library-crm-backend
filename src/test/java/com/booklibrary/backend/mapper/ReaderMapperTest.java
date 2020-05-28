package com.booklibrary.backend.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.booklibrary.backend.entity.Address;
import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.entity.dto.ReaderDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderMapperTest {

  @Autowired private ReaderMapper readerMapper;

  @Test
  public void mapToReaderDtoList() {
    // Given
    Reader reader = new Reader(1, "FirstName", "LastName", "Phone Number", "Email", new Address(), new ArrayList<>());
    List<Reader> readeres = new ArrayList<>();
    readeres.add(reader);

    // When
    List<ReaderDTO> readerDTOs = readerMapper.mapToReaderDtoList(readeres);

    // Then
    assertEquals(1, readerDTOs.size());
  }

  @Test
  public void mapToReader() {}

  @Test
  public void mapToReaderDTO() {}
}