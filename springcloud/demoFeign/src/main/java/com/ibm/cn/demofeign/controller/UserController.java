package com.ibm.cn.demofeign.controller;

import com.ibm.cn.demofeign.model.User;
import com.ibm.cn.demofeign.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping(value = "/getUser")
    public User getUser() {
        return userFeignService.getUser();
    }
}
