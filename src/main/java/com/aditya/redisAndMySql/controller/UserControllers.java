package com.aditya.redisAndMySql.controller;

import com.aditya.redisAndMySql.entity.User;
import com.aditya.redisAndMySql.repository.UserRepoRedis;
import com.aditya.redisAndMySql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserRepoRedis userRepoRedis;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/add/mysql", method = RequestMethod.POST)
    public User addUserToMysql(@RequestBody User user){
        userRepository.save(user);
        return userRepository.findByName(user.getName());
    }

    @RequestMapping(value = "/show/mysql/all")
    public List<User> showMySqlAllUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/show/mysql/{name}")
    public User showUserByNameMysql(@PathVariable final String name){
        return userRepository.findByName(name);
    }


    @PostMapping(value = "/add/redis")
    public User addUserToRedis(@RequestBody User user){
        userRepoRedis.save(user);
        return userRepoRedis.findById(user.getId());
    }

    @RequestMapping(value = "/show/redis/all")
    public List<User> showRedisAllUser(){
        return userRepoRedis.findAll();
    }

    @RequestMapping(value = "/show/redis/{id}")
    public User showUserByNameMysql(@PathVariable final Integer id){
        return userRepoRedis.findById(id);
    }

}
