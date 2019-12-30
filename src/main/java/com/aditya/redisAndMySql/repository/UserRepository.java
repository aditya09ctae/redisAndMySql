package com.aditya.redisAndMySql.repository;

import com.aditya.redisAndMySql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

}
