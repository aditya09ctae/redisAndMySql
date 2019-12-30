package com.aditya.redisAndMySql.repository.impl;

import com.aditya.redisAndMySql.entity.User;
import com.aditya.redisAndMySql.repository.UserRepoRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        hashOperations.put("USER",user.getId(),user);
        return (User)hashOperations.get("USER",user.getId());
    }

    @Override
    public List<User> findAll() {
        log.info("Data is :");
        log.info(hashOperations.entries("USER").toString());
        Map<Integer, User> userMap = hashOperations.entries("USER");
        List<User> response = new ArrayList<>();
        for(User userTemp : userMap.values()){
            response.add(userTemp);
        }
        return response;
    }

    @Override
    public User findById(Integer id) {
        return (User)hashOperations.get("USER",id);
    }

    @Override
    public User update(User user) {
        return save(user);
    }

    @Override
    public void delete(Integer id) {
        hashOperations.delete("USER",id);
    }
}
