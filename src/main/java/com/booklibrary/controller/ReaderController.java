package com.booklibrary.controller;

import com.booklibrary.entity.Reader;
import com.booklibrary.entity.dto.ReaderDTO;
import com.booklibrary.exception.ReaderNotFoundException;
import com.booklibrary.mapper.BookMapper;
import com.booklibrary.mapper.ReaderMapper;
import com.booklibrary.service.ReaderService;
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
public class ReaderController {

  @Autowired private ReaderService readerService;

  @Autowired private ReaderMapper readerMapper;

  @Autowired private BookMapper bookMapper;

  @GetMapping("/readers")
  public List<ReaderDTO> getReaders() {
    return readerMapper.mapToReaderDtoList(readerService.getReaders());
  }

  @GetMapping("/readers/{readerId}")
  public ReaderDTO getReader(@PathVariable int readerId) {

    Reader reader = readerService.getReader(readerId);

    if (reader == null) {
      throw new ReaderNotFoundException("Reader with id: " + readerId + " not found");
    }

    return readerMapper.mapToReaderDTO(reader);
  }

  @PostMapping("/readers")
  public void createReader(@RequestBody ReaderDTO readerDTO) {
    readerService.saveOrUpdate(readerMapper.mapToReader(readerDTO));
  }

  @PutMapping("/readers")
  public void updateReader(@RequestBody ReaderDTO readerDTO) {
    readerService.saveOrUpdate(readerMapper.mapToReader(readerDTO));
  }

  @DeleteMapping("/readers/{readerId}")
  public void deleteReader(@PathVariable int readerId) {

    Reader reader = readerService.getReader(readerId);

    if (reader == null) {
      throw new ReaderNotFoundException("Reader with id: " + readerId + " not found");
    }

    readerService.deleteReader(readerId);
  }
}
