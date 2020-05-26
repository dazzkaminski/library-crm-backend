package com.booklibrary.backend.repository;

import com.booklibrary.backend.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByTitleContains(String title);
}
