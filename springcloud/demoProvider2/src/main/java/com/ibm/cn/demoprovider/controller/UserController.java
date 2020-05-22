package com.ibm.cn.demoprovider.controller;

import com.ibm.cn.demoprovider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RefreshScope
public class UserController {

    @Autowired
    private User user;

    @Value("${user.name}")
    private String name;

    @GetMapping(value = "/getUser")
    public User getUser() {
        User demo =new User();
        demo.setName(name);
        demo.setAge(user.getAge());
        demo.setPhone(user.getPhone());
        demo.setSex(user.getSex());
        return demo;
    }
}
