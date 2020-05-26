package com.booklibrary.backend.mapper;

import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.entity.dto.ReaderDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

  public List<ReaderDTO> mapToReaderDtoList(List<Reader> readers) {
    return readers.stream()
        .map(
            reader ->
                new ReaderDTO(
                    reader.getId(),
                    reader.getFirstName(),
                    reader.getLastName(),
                    reader.getPhoneNumber(),
                    reader.getEmail(),
                    reader.getAddress(),
                    reader.getBooks()))
        .collect(Collectors.toList());
  }

  public Reader mapToReader(ReaderDTO readerDTO) {
    return new Reader(
        readerDTO.getId(),
        readerDTO.getFirstName(),
        readerDTO.getLastName(),
        readerDTO.getPhoneNumber(),
        readerDTO.getEmail(),
        readerDTO.getAddress(),
        readerDTO.getBooks());
  }

  public ReaderDTO mapToReaderDTO(Reader reader) {
    return new ReaderDTO(
        reader.getId(),
        reader.getFirstName(),
        reader.getLastName(),
        reader.getPhoneNumber(),
        reader.getEmail(),
        reader.getAddress(),
        reader.getBooks());
  }
}
