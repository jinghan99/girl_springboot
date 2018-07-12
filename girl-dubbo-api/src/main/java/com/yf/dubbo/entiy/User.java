package com.yf.dubbo.entiy;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Date 2018/7/12 15:55
 * @Author jinghan
 * @Version 1.0
 */
public class User  implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
