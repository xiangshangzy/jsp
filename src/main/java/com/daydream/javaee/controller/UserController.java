package com.daydream.javaee.controller;

import com.daydream.javaee.mapper.UserMapper;
import com.daydream.javaee.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/user")
    public User user()
    {
        return  userMapper.selectByPrimaryKey(1);
    }
}
