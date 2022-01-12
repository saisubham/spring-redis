package com.sudosai.springredis.controller;


import com.sudosai.springredis.entity.User;
import com.sudosai.springredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "users", key = "#id")
    public Optional<User> findUser(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id);
    }
}
