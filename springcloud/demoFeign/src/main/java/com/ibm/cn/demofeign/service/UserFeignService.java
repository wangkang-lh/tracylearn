package com.ibm.cn.demofeign.service;


import com.ibm.cn.demofeign.model.User;
import com.ibm.cn.demofeign.service.fallback.FallBackOfUserProvider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "USERPROVIDE1", fallback = FallBackOfUserProvider.class)
public interface UserFeignService {

    @GetMapping(value = "/user/getUser")
    User getUser();
}
