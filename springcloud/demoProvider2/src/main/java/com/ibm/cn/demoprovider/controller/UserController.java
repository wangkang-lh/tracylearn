package com.ibm.cn.demoprovider.controller;

import com.ibm.cn.demoprovider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private User user;

    @GetMapping(value = "/getUserByName")
    public User getUserByName(@RequestParam(value = "name") String name) {
        int sleepTime = new Random().nextInt(3000);
        try {
            System.out.println("随机时间：" + sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("Tracy".equals(name)) {
            user.setName("Tracy");
            user.setSex("male");
            user.setAge(28);
            user.setPhone("110");
        } else {
            user.setName("LH");
            user.setSex("femal");
            user.setAge(23);
            user.setPhone("156");
        }
        return user;
    }
}
