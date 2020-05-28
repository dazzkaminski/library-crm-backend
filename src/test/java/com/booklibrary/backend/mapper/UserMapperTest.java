package com.booklibrary.backend.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.booklibrary.backend.entity.User;
import com.booklibrary.backend.entity.User;
import com.booklibrary.backend.entity.dto.UserDTO;
import com.booklibrary.backend.entity.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

  @Autowired private UserMapper userMapper;

  @Test
  public void mapToUserDtoList() {
    // Given
    User user = new User(1, "UserName", "Email", "Password", "Role");
    List<User> users = new ArrayList<>();
    users.add(user);

    // When
    List<UserDTO> userDTOs = userMapper.mapToUserDtoList(users);

    // Then
    assertEquals(1, userDTOs.size());
  }

  @Test
  public void mapToUserDto() {
    // Given
    User user = new User(1, "UserName", "Email", "Password", "Role");

    // When
    UserDTO userDTO = userMapper.mapToUserDto(user);

    //Then
    assertNotNull(userDTO);
    assertEquals(Integer.valueOf(1), userDTO.getId());
    assertEquals("UserName", userDTO.getUserName());
    assertEquals("Email", userDTO.getEmail());
    assertEquals("Password", userDTO.getPassword());
    assertEquals("Role", userDTO.getRole());
  }

  @Test
  public void mapToUser() {
    // Given
    UserDTO userDTO = new UserDTO(1, "UserName", "Email", "Password", "Role");

    // When
    User user = userMapper.mapToUser(userDTO);

    //Then
    assertNotNull(user);
    assertEquals(Integer.valueOf(1), user.getId());
    assertEquals("UserName", user.getUserName());
    assertEquals("Email", user.getEmail());
    assertEquals("Password", user.getPassword());
    assertEquals("Role", user.getRole());
  }
}
