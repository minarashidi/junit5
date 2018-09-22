package com.rashidi.rashidi.practice.test.junit5.repository.impl;

import com.rashidi.rashidi.practice.test.junit5.model.User;
import com.rashidi.rashidi.practice.test.junit5.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public Optional<User> findById(long id) {
    return Optional.empty();
  }

  @Override
  public void update(User user) {
  }

  @Override
  public void delete(long id) {

  }

  @Override
  public long add(User user) {
    return 0;
  }

}
