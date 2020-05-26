package com.booklibrary.backend.controller;

import com.booklibrary.backend.entity.Mail;
import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.entity.dto.ReaderDTO;
import com.booklibrary.backend.exception.ReaderNotFoundException;
import com.booklibrary.backend.mapper.ReaderMapper;
import com.booklibrary.backend.service.EmailService;
import com.booklibrary.backend.service.ReaderService;
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
public class ReaderRestController {

  @Autowired private ReaderService readerService;

  @Autowired private ReaderMapper readerMapper;

  @Autowired private EmailService emailService;

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

    Mail mail =
        new Mail(readerDTO.getEmail(), "", "Welcome to our library", "Welcome to our library");

    emailService.send(mail);

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

  @GetMapping("/readers/search/{lastName}")
  public List<ReaderDTO> search(@PathVariable String lastName) {
    return readerMapper.mapToReaderDtoList(readerService.filterByLastName(lastName));
  }
}
