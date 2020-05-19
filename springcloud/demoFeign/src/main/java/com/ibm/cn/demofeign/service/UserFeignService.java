package com.ibm.cn.demofeign.service;


import com.ibm.cn.demofeign.model.User;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "USERPROVIDER", fallback = FallBackOfUserFeign.class)
public interface UserFeignService {

    @GetMapping(value = "/user/getUserByName")
    User getUserByName(@RequestParam(value = "name") String name);
}
