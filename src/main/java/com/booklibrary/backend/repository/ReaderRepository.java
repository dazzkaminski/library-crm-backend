package com.booklibrary.backend.repository;

import com.booklibrary.backend.entity.Reader;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

  List<Reader> findByLastNameContains(String lastName);
}
