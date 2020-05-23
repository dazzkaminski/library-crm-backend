package com.booklibrary.mapper;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.dto.BookDTO;
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
                    book.isAvailable(),
                    book.getReader()))
        .collect(Collectors.toList());
  }

  public Book mapToBook(BookDTO bookDTO) {
    return new Book(
        bookDTO.getId(),
        bookDTO.getTitle(),
        bookDTO.getDescription(),
        bookDTO.getAuthor(),
        bookDTO.getReleaseDate(),
        bookDTO.isAvailable());
  }

  public BookDTO mapToBookDto(Book book) {
    return new BookDTO(
        book.getId(),
        book.getTitle(),
        book.getDescription(),
        book.getAuthor(),
        book.getReleaseDate(),
        book.isAvailable(),
        book.getReader());
  }
}
