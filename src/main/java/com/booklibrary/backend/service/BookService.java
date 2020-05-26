package com.booklibrary.backend.service;

import com.booklibrary.backend.entity.Book;
import com.booklibrary.backend.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired private BookRepository bookRepository;

  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

  public Book getBook(int id) {
    return bookRepository.findById(id).get();
  }

  public void saveOrUpdate(Book Book) {
    bookRepository.save(Book);
  }

  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }

  public List<Book> filterByTitle(String title) {
    return bookRepository.findByTitleContains(title);
  }
}
