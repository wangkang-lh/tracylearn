package com.ibm.cn.demozuul.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;

@Component
@ConfigurationProperties("token.jwt")
@Data
public class JwtConfiguration {
    private String key;
    private String iss;
    private int expm;

    public SecretKeySpec getSecretKeySpec() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.getKey()
                .getBytes(), SignatureAlgorithm.HS512.getJcaName());
        return secretKeySpec;
    }
}
