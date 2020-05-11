package cn.ibm.com.tracytwo.commonStarter;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "tracy")
public class ServiceProperties {
    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
