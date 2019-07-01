package com.hospital.model.admin;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName User
 * @Description 请输入你的简化描述！
 * @Author 方聪
 * @Date 2019/6/6 11:01
 * @Version 1.0
 **/

public class User {
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
