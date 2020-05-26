package com.booklibrary.backend.mapper;

import com.booklibrary.backend.entity.User;
import com.booklibrary.backend.entity.dto.UserDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public List<UserDTO> mapToUserDtoList(List<User> users) {
    return users.stream()
        .map(
            user ->
                new UserDTO(
                    user.getId(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRole()))
        .collect(Collectors.toList());
  }

  public UserDTO mapToUserDto(User user) {
    return new UserDTO(
        user.getId(),
        user.getUserName(),
        user.getEmail(),
        user.getPassword(),
        user.getRole());
  }

  public User mapToUser(UserDTO userDTO) {
    return new User(
        userDTO.getId(),
        userDTO.getUserName(),
        userDTO.getEmail(),
        userDTO.getPassword(),
        userDTO.getRole());
  }
}
