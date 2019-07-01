package com.hospital.controller;

import com.hospital.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName TestController
 * @Description 进行测试开发的
 * @Author 方聪
 * @Date 2019/6/6 10:06
 * @Version 1.0
 **/
@RestController
public class TestController {

    @RequestMapping("/login")
    public Result TestController(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Result r = new Result();
        r.setCode(200);
        r.setData(null);
        try {
            subject.login(token);
            subject.getSession().setAttribute("userName",username);
            r.setMsg("successful");
        }catch (LockedAccountException lae) {
            token.clear();
            r.setCode(-1111);
            r.setMsg("用户已经被锁定不能登录，请与管理员联系！");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            token.clear();
            r.setCode(-1111);
        }
        return r;
    }

    @RequestMapping("/Relogin")
    public String TestController2(){
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        if(authenticated ==true){
            System.out.println("Principal:"+subject.getPrincipal());
            System.out.println(subject.getSession().getAttribute("username"));
            return "已经认证了";

        } else {
            return "无认证";
        }

    }

    @RequestMapping("/unauth")
    public Result unauth(){
        Result r = new Result();
        r.setCode(-1112);
        r.setData(null);
        r.setMsg("你无权限访问该页面！请勿访问，严重者 将被系统记录!!!");
        return r;

    }




}
