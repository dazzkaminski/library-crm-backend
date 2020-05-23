package com.booklibrary.controller;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.dto.BookDTO;
import com.booklibrary.exception.BookNotFoundException;
import com.booklibrary.mapper.BookMapper;
import com.booklibrary.service.BookService;
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
public class BookController {

  @Autowired private BookService bookService;

  @Autowired private BookMapper bookMapper;

  @GetMapping("/books")
  public List<BookDTO> getBooks() {
    return bookMapper.mapToBookDtoList(bookService.getBooks());
  }

  @GetMapping("/books/{bookId}")
  public BookDTO getBook(@PathVariable int bookId) {

    Book book = bookService.getBook(bookId);

    if (book == null) {
      throw new BookNotFoundException("Book id not found - " + bookId);
    }

    return bookMapper.mapToBookDto(bookService.getBook(bookId));
  }

  @PostMapping("/books")
  public void createBook(@RequestBody BookDTO bookDTO) {
    bookService.saveOrUpdate(bookMapper.mapToBook(bookDTO));
  }

  @PutMapping("/books")
  public void updateBook(@RequestBody BookDTO bookDTO) {
    bookService.saveOrUpdate(bookMapper.mapToBook(bookDTO));
  }

  @DeleteMapping("/books/{bookId}")
  public String deleteBook(@PathVariable int bookId) {

    Book book = bookService.getBook(bookId);

    if (book == null) {
      throw new BookNotFoundException("Book id not found - " + bookId);
    }

    bookService.deleteBook(bookId);

    return "Deleted the book id - " + bookId;
  }
}
