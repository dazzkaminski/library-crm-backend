package com.booklibrary.controller;

import com.booklibrary.entity.dto.UserDTO;
import com.booklibrary.mapper.UserMapper;
import com.booklibrary.service.UserService;
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
public class UserController {

  @Autowired private UserService userService;

  @Autowired private UserMapper userMapper;

  @GetMapping("/users")
  public List<UserDTO> getUsers() {
    return userMapper.mapToUserDtoList(userService.getUsers());
  }

  @GetMapping("/users/{userId}")
  public UserDTO getUser(@PathVariable int userId) {
    return userMapper.mapToUserDto(userService.getUser(userId));
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
    userService.deleteUser(userId);
  }
}
