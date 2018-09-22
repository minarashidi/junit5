package com.rashidi.rashidi.practice.test.junit5.repository;

import com.rashidi.rashidi.practice.test.junit5.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  List<User> findAll();

  Optional<User> findById(long id);

  void update(User user);

  void delete(long id);

  long add(User user);
}
