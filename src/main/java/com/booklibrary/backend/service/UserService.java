package com.booklibrary.backend.service;

import com.booklibrary.backend.entity.Reader;
import com.booklibrary.backend.entity.User;
import com.booklibrary.backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(int id) {
    return userRepository.findById(id).get();
  }

  public void saveOrUpdate(User User) {
    userRepository.save(User);
  }

  public void deleteUser(int id) {
    userRepository.deleteById(id);
  }

  public List<User> filterByUserName(String userName) {
    return userRepository.findByUserNameContains(userName);
  }
}
