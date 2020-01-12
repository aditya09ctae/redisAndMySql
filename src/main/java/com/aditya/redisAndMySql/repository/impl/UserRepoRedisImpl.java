package com.aditya.redisAndMySql.repository.impl;

import com.aditya.redisAndMySql.entity.User;
import com.aditya.redisAndMySql.repository.UserRepoRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
@Repository
@Slf4j
public class UserRepoRedisImpl implements UserRepoRedis {

    RedisTemplate<String,User> redisTemplate;

    private HashOperations hashOperations;

    UserRepoRedisImpl(RedisTemplate<String,User> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User save(User user) {
        hashOperations.put("USER2",user.getId(),user);
        return (User)hashOperations.get("USER2",user.getId());
    }

    @Override
    public Map<Integer,User> findAll() {
        return hashOperations.entries("USER2");
    }

    @Override
    public User findById(Integer id) {
        return (User)hashOperations.get("USER2",id);
    }

    @Override
    public User update(User user) {
        return save(user);
    }

    @Override
    public void delete(Integer id) {
        hashOperations.delete("USER2",id);
    }
}
