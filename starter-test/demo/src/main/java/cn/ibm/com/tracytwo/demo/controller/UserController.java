package cn.ibm.com.tracyone.demo.controller;

import cn.ibm.com.tracyone.commonstarter.Commonservice;
import cn.ibm.com.tracyone.demo.model.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Commonservice commonservice;

    /**
     * json
     */
    @PostMapping("/register")
    public String register(@RequestBody String jsonStr) {
        User user = JSON.parseObject(jsonStr, User.class);
        user.setVersion(UUID.randomUUID().toString());
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        return JSON.toJSONString(list);
    }

    /**
     * form
     */
    @PostMapping("/register1")
    public String registerForm(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setVersion(UUID.randomUUID().toString());
        list.add(user);
        return JSON.toJSONString(list);
    }

    @GetMapping("/getUser")
    public User getUser(String name) {
        User user = new User();
        user.setName(name);
        user.setSex("男");
        user.setVersion(UUID.randomUUID().toString());
        return user;
    }

}
