package com.hospital.model.admin;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description
 * 对于新增加一条信息，需要添加数据验证的条件
 * @Date 14:17 2019/6/12
 * @Param
 * @return
 **/
public class User implements Serializable {

    private Integer id;
    //进行数据验证
    @NotNull(message = "username不能为空")
    @Length(min = 6,max = 10,message = "username长度为6到10")
    private String username;

    @NotNull(message = "password不能为空")
    private String userpassword;

    @NotNull
    private Integer role;

    private String position;

    private String isSchedul;

    private Integer departmentNo;

    private String departmentName;
    @NotNull
    private String name;
    @NotNull
    private String iphone;
    @NotNull
    private String adderst;

    private String mes;


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
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getIsSchedul() {
        return isSchedul;
    }

    public void setIsSchedul(String isSchedul) {
        this.isSchedul = isSchedul == null ? null : isSchedul.trim();
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(Integer departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone == null ? null : iphone.trim();
    }

    public String getAdderst() {
        return adderst;
    }

    public void setAdderst(String adderst) {
        this.adderst = adderst == null ? null : adderst.trim();
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes == null ? null : mes.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", role=" + role +
                ", position='" + position + '\'' +
                ", isSchedul='" + isSchedul + '\'' +
                ", departmentNo=" + departmentNo +
                ", departmentName='" + departmentName + '\'' +
                ", name='" + name + '\'' +
                ", iphone='" + iphone + '\'' +
                ", adderst='" + adderst + '\'' +
                ", mes='" + mes + '\'' +
                '}';
    }


}