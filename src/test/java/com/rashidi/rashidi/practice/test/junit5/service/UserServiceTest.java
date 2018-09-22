package com.rashidi.rashidi.practice.test.junit5.service;

import com.rashidi.rashidi.practice.test.junit5.exception.NotFoundException;
import com.rashidi.rashidi.practice.test.junit5.model.User;
import com.rashidi.rashidi.practice.test.junit5.repository.UserRepository;
import com.rashidi.rashidi.practice.test.junit5.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Tag("user")
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  @DisplayName("Test find all users")
  void testFindAll() {

    List<User> users = Arrays.asList(new User(1, "Mina", 29), new User(2, "Karin", 38));
    when(userRepository.findAll()).thenReturn(users);

    List<User> allUsers = userService.findAll();
    assertEquals(2, allUsers.size());

    assertAll("users",
      () -> assertEquals(allUsers.get(0).getName(), "Mina"),
      () -> assertEquals(allUsers.get(1).getName(), "Karin")
    );
  }

  @Test
  void testFindUser() {

    User user = new User(1, "Mina", 28);
    when(userRepository.findById(1)).thenReturn(Optional.of(user));

    Optional<User> userOptional = userService.findById(1);

    assertTrue(userOptional.isPresent());
    assertEquals("Mina", userOptional.get().getName());
  }

  @Test
  void testFindWhenUserNotFound() {

    when(userRepository.findById(1)).thenReturn(Optional.empty());

    Optional<User> userOptional = userService.findById(1);

    assertFalse(userOptional.isPresent());
  }

  @Test
  void testUpdate() {

    User user = new User(1, "Mina", 28);
    when(userRepository.findById(1)).thenReturn(Optional.of(user));
    ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

    userService.update(user);

    verify(userRepository, times(1)).findById(1);
    verify(userRepository, times(1)).update(captor.capture());

    assertEquals("Mina", captor.getValue().getName());
  }

  @Test
  void testUpdateWhenUserNotFound() {
    User user = new User(1, "Mina", 28);

    when(userRepository.findById(1)).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> userService.update(user));

    verify(userRepository, times(1)).findById(1);
    verify(userRepository, never()).update(user);
  }

  @Test
  void testRemove() {
    User user = new User(1, "Mina", 28);
    when(userRepository.findById(1)).thenReturn(Optional.of(user));
    ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

    userService.remove(user.getId());

    verify(userRepository, times(1)).findById(1);
    verify(userRepository, times(1)).delete(captor.capture());

    assertEquals(1, (long) captor.getValue());
  }

  @Test
  void testRemoveWhenUserNotFound() {

    when(userRepository.findById(1)).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> userService.remove(1));

    verify(userRepository, times(1)).findById(1);
    verify(userRepository, never()).delete(1);
  }

  @Test
  void testAdd() {
    User user = new User(3, "Anna", 25);

    ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

    userService.add(user);
    verify(userRepository, times(1)).add(captor.capture());

    assertEquals(user.getName(), captor.getValue().getName());
  }
}
