package com.sudosai.springredis.repository;

import com.sudosai.springredis.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
   /* @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
        user.setName("sai");
        user.setEmail("sai@gmail.com");
    }

    @Test
    public void saveUser() {
        User savedUser = userRepository.save(user);
        assertNotNull(user.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    public void saveUserWithoutEmail() {
        user.setEmail(null);
        assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(user));
    }

    @Test
    public void getUserById() {
        User savedUser = userRepository.save(user);
        assertNotNull(user.getId());
        Optional<User> gotUser = userRepository.findById(savedUser.getId());
        assertNotNull(gotUser);
    }

    @Test
    public void deleteUser() {
        Long id = userRepository.save(user).getId();
        userRepository.deleteById(id);
        assertThrows(JpaObjectRetrievalFailureException.class, () -> userRepository.getById(id));
    }*/
}