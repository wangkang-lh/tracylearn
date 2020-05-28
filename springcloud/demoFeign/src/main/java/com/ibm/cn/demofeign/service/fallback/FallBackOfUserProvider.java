package com.ibm.cn.demofeign.service.fallback;

import com.ibm.cn.demofeign.model.User;
import com.ibm.cn.demofeign.service.UserFeignService;
import org.springframework.stereotype.Service;

@Service
public class FallBackOfUserProvider implements UserFeignService {
    @Override
    public User getUser() {
        User user = new User();
        user.setName("fallback");
        user.setAge(-1);
        user.setPhone("110");
        user.setSex("old man");
        return user;
    }
}

