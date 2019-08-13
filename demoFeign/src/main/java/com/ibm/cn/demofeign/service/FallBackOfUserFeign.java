package com.ibm.cn.demofeign.service;

import com.ibm.cn.demofeign.model.User;
import org.springframework.stereotype.Component;

@Component
public class FallBackOfUserFeign implements UserFeignService {
    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setName("fallback");
        user.setAge(Integer.MAX_VALUE);
        user.setPhone("120");
        user.setSex("female");
        return user;
    }
}

