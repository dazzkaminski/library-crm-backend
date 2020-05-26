package com.booklibrary.backend.repository;

import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByUserNameContains(String userName);
}
