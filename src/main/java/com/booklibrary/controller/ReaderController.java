package com.booklibrary.controller;

import com.booklibrary.entity.Reader;
import com.booklibrary.entity.dto.ReaderDTO;
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

  @GetMapping("/readers")
  public List<Reader> getReaders() {
    return readerService.getReaders();
  }

  @GetMapping("/readers/{readerId}")
  public ReaderDTO getReader(@PathVariable int readerId) {
    return readerMapper.mapToReaderDTO(readerService.getReader(readerId));
  }

  @PostMapping("/readers")
  public void createReader(@RequestBody Reader reader) {
    readerService.saveOrUpdate(reader);
  }

  @PutMapping("/readers")
  public void updateReader(@RequestBody Reader reader) {
    readerService.saveOrUpdate(reader);
  }

  @DeleteMapping("/readers/{readerId}")
  public void deleteReader(@PathVariable int readerId) {
    readerService.deleteReader(readerId);
  }
}
