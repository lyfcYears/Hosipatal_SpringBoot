package com.hospital.controller;

import com.hospital.utils.ExceptionAndLogAop;
import com.hospital.utils.Result;
import com.hospital.utils.ResultCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName  该类是进行登陆、退出、以及显示无限访问的操作的一个根控制类
 * @Description 进行测试开发的
 * @Author 方聪
 * @Date 2019/6/6 10:06
 * @Version 1.0
 **/
@RestController
public class ShiroController {
    private Logger logger = LoggerFactory.getLogger(ExceptionAndLogAop.class);

    /**
     * @Description 登陆操作，
     * @Date 11:43 2019/6/12
     * @Param [username, password] 用户名和用户密码
     * @return com.hospital.utils.Result BindingResult result
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result TestController(String username,  String password){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Result r = null;
        try {
            subject.login(token);
            subject.getSession().setAttribute("userName",username);
            r = new Result(ResultCode.SUCCESS);
        }catch (RuntimeException e) {
            token.clear();
            r = new Result(ResultCode.ERROR_URSERlOGIN);
        }
        return r;
    }


    /**
     * @Description  无权限访问会执行这个Controller
     * @Date 11:44 2019/6/12
     * @Param []
     * @return com.hospital.utils.Result
     **/
    @RequestMapping("/unauth")
    public Result unauth(){
        Result r = new Result(ResultCode.FORBID);
        return r;
    }
    /**
     * @Description 用户退出的Controller
     * @Date 11:45 2019/6/12
     * @Param []
     * @return com.hospital.utils.Result
     **/
    @RequestMapping("/logout")
    public Result logout(){
        Result r = new Result(ResultCode.SUCCESS);
        return r;
    }













}
