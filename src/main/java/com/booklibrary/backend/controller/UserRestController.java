package com.booklibrary.backend.controller;

import com.booklibrary.backend.entity.User;
import com.booklibrary.backend.entity.dto.ReaderDTO;
import com.booklibrary.backend.entity.dto.UserDTO;
import com.booklibrary.backend.exception.UserNotFoundException;
import com.booklibrary.backend.mapper.UserMapper;
import com.booklibrary.backend.service.UserService;
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
public class UserRestController {

  @Autowired private UserService userService;

  @Autowired private UserMapper userMapper;

  @GetMapping("/users")
  public List<UserDTO> getUsers() {
    return userMapper.mapToUserDtoList(userService.getUsers());
  }

  @GetMapping("/users/{userId}")
  public UserDTO getUser(@PathVariable int userId) {

    User user = userService.getUser(userId);

    if (user == null) {
      throw new UserNotFoundException("User with id: " + userId + " not found");
    }

    return userMapper.mapToUserDto(user);
  }

  @PostMapping("/users")
  public void createUser(@RequestBody UserDTO userDTO) {
    userService.saveOrUpdate(userMapper.mapToUser(userDTO));
  }

  @PutMapping("/users")
  public void updateUser(@RequestBody UserDTO userDTO) {
    userService.saveOrUpdate(userMapper.mapToUser(userDTO));
  }

  @DeleteMapping("/users/{userId}")
  public void deleteUser(@PathVariable int userId) {

    User user = userService.getUser(userId);

    if (user == null) {
      throw new UserNotFoundException("User with id: " + userId + " not found");
    }

    userService.deleteUser(userId);
  }

  @GetMapping("/users/search/{userName}")
  public List<UserDTO> search(@PathVariable String userName) {
    return userMapper.mapToUserDtoList(userService.filterByUserName(userName));
  }
}
