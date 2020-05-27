package com.booklibrary.backend.mapper;

import com.booklibrary.backend.entity.Book;
import com.booklibrary.backend.entity.dto.BookDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  public List<BookDTO> mapToBookDtoList(List<Book> books) {
    return books.stream()
        .map(
            book ->
                new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getDescription(),
                    book.getAuthor(),
                    book.getReleaseDate(),
                    book.getDateOfBorrowing(),
                    book.isAvailable()))
        .collect(Collectors.toList());
  }

  public BookDTO mapToBookDto(Book book) {
    return new BookDTO(
        book.getId(),
        book.getTitle(),
        book.getDescription(),
        book.getAuthor(),
        book.getReleaseDate(),
        book.getDateOfBorrowing(),
        book.isAvailable());
  }

  public Book mapToBook(BookDTO bookDTO) {
    return new Book(
        bookDTO.getId(),
        bookDTO.getTitle(),
        bookDTO.getDescription(),
        bookDTO.getAuthor(),
        bookDTO.getReleaseDate(),
        bookDTO.getDateOfBorrowing(),
        bookDTO.isAvailable());
  }
}
