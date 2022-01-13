package com.sudosai.springredis.repository;

import com.sudosai.springredis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
