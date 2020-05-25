package com.booklibrary.repository;

import com.booklibrary.entity.Book;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByTitleContains(String title);
}
