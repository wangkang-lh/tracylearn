package com.ibm.cn.demofeign.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    String name;
    String sex;
    int age;
    String phone;
}
