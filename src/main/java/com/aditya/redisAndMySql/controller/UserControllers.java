package com.aditya.redisAndMySql.controller;

import com.aditya.redisAndMySql.entity.User;
import com.aditya.redisAndMySql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {

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
}
