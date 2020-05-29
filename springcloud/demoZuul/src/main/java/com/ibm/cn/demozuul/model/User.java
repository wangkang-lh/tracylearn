package com.ibm.cn.demozuul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long accountId;
    private String phone;
    private String userName;
    private String password;
    private String email;
}
