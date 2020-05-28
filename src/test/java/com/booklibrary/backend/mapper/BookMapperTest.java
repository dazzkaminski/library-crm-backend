package com.booklibrary.backend.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.booklibrary.backend.entity.Book;
import com.booklibrary.backend.entity.dto.BookDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

  @Autowired private BookMapper bookMapper;

  @Test
  public void mapToBookDtoList() {
    // Given
    Book book = new Book(1, "Title", "Desc", "Author", "ReleaseDate", LocalDate.now(), true);
    List<Book> bookes = new ArrayList<>();
    bookes.add(book);

    // When
    List<BookDTO> bookDTOs = bookMapper.mapToBookDtoList(bookes);

    // Then
    assertEquals(1, bookDTOs.size());
  }

  @Test
  public void mapToBookDto() {
    // Given
    Book book = new Book(1, "Title", "Desc", "Author", "ReleaseDate", LocalDate.now(), true);

    // When
    BookDTO bookDTO = bookMapper.mapToBookDto(book);

    // Then
    assertNotNull(bookDTO);
    assertEquals(Integer.valueOf(1), bookDTO.getId());
    assertEquals("Title", bookDTO.getTitle());
    assertEquals("Desc", bookDTO.getDescription());
    assertEquals("Author", bookDTO.getAuthor());
    assertEquals("ReleaseDate", bookDTO.getReleaseDate());
    assertEquals(LocalDate.now(), bookDTO.getDateOfBorrowing());
    assertEquals(true, bookDTO.isAvailable());
  }

  @Test
  public void mapToBook() {
    // Given
    BookDTO bookDTO =
        new BookDTO(1, "Title", "Desc", "Author", "ReleaseDate", LocalDate.now(), true);

    // When
    Book book = bookMapper.mapToBook(bookDTO);

    // Then
    assertNotNull(book);
    assertEquals("Title", book.getTitle());
    assertEquals("Desc", book.getDescription());
    assertEquals("Author", book.getAuthor());
    assertEquals("ReleaseDate", book.getReleaseDate());
    assertEquals(LocalDate.now(), book.getDateOfBorrowing());
    assertEquals(true, book.isAvailable());
  }
}
