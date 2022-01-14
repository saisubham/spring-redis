package com.sudosai.springredis.service;

import com.sudosai.springredis.entity.User;
import com.sudosai.springredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public Optional<User> findUser(Long id) {
        System.out.println("Searching in db...");
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    @Modifying
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id).map(target -> {
            target.setId(id);
            if (user.getName() != null) target.setName(user.getName());
            if (user.getEmail() != null) target.setEmail(user.getEmail());
            return target;
        });
    }

    @Override
    @CacheEvict(value = "users")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
