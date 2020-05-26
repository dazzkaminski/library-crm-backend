package com.booklibrary.backend.service;

import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.repository.ReaderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

  @Autowired private ReaderRepository readerRepository;

  public List<Reader> getReaders() {
    return readerRepository.findAll();
  }

  public Reader getReader(int id) {
    return readerRepository.findById(id).get();
  }

  public void saveOrUpdate(Reader reader) {
    readerRepository.save(reader);
  }

  public void deleteReader(int id) {
    readerRepository.deleteById(id);
  }

  public List<Reader> filterByLastName(String lastName) {
    return readerRepository.findByLastNameContains(lastName);
  }
}
