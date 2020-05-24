package com.booklibrary.mapper;

import com.booklibrary.entity.User;
import com.booklibrary.entity.dto.UserDTO;
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
                    user.getId(), user.getUserName(), user.getUserPassword(), user.getUserRole()))
        .collect(Collectors.toList());
  }

  public UserDTO mapToUserDto(User user) {
    return new UserDTO(
        user.getId(), user.getUserName(), user.getUserPassword(), user.getUserRole());
  }

  public User mapToUser(UserDTO userDTO) {
    return new User(
        userDTO.getId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getUserRole());
  }
}
