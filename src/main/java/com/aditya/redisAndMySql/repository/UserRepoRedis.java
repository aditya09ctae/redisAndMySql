package com.aditya.redisAndMySql.repository;

import com.aditya.redisAndMySql.entity.User;

import java.util.List;
import java.util.Map;

public interface UserRepoRedis {

    User save(User user);
    Map<Integer, User> findAll();
    User findById(Integer id);
    User update(User user);
    void delete(Integer id);

}
