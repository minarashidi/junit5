package com.rashidi.rashidi.practice.test.junit5.service.impl;

import com.rashidi.rashidi.practice.test.junit5.exception.NotFoundException;
import com.rashidi.rashidi.practice.test.junit5.model.User;
import com.rashidi.rashidi.practice.test.junit5.repository.UserRepository;
import com.rashidi.rashidi.practice.test.junit5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public void update(User user) {
    Optional<User> userOptional = userRepository.findById(user.getId());
    userOptional.orElseThrow(() -> new NotFoundException("User with id " + user.getId() + " not found"));
    userRepository.update(user);
  }

  @Override
  public void remove(long id) {
    Optional<User> userOptional = userRepository.findById(id);
    userOptional.orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
    userRepository.delete(id);
  }

  @Override
  public long add(User user) {
    return userRepository.add(user);
  }

}
