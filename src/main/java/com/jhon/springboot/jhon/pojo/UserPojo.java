package com.jhon.springboot.jhon.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding //Permite inyectar como dedependencia, para que se contruya el pojo.
@ConfigurationProperties(prefix="user") //Represent prefix in .properties
public class UserPojo {
    private String email;
    private String password;
    private  Integer age;

    public UserPojo(String email, String password, Integer age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
