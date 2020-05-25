package com.booklibrary.service;

import com.booklibrary.entity.Book;
import com.booklibrary.repository.BookRepository;
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
