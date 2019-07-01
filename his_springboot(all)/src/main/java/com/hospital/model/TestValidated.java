package com.hospital.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName TestValidated
 * @Description 测试用的实体类
 * @Author 方聪
 * @Date 2019/6/12 14:23
 * @Version 1.0
 **/

public class TestValidated {
    @NotNull
    @Length(min = 4,message = "不能小于4")
    private String name;
    @Length(min = 3)
    private String pass;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
