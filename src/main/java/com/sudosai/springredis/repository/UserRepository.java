package com.sudosai.springredis.repository;

import com.sudosai.springredis.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
