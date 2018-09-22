package com.rashidi.rashidi.practice.test.junit5.service;

import com.rashidi.rashidi.practice.test.junit5.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  List<User> findAll();

  Optional<User> findById(long id);

  void update(User user);

  void remove(long id);

  long add(User user);

}
