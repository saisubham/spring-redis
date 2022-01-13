package com.sudosai.springredis.controller;


import com.sudosai.springredis.entity.User;
import com.sudosai.springredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findUser(@PathVariable(value = "id") Long id) {
        return userService.findUser(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public Optional<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
    }
}
