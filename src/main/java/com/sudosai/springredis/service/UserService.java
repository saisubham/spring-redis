package com.sudosai.springredis.service;

import com.sudosai.springredis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);

    public Optional<User> findUser(Long id);

    public List<User> findAllUsers();

    public Optional<User> updateUser(Long id, User user);

    public void deleteUser(Long id);
}
