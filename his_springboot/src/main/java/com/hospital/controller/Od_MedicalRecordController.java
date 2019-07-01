package com.hospital.controller;

import com.hospital.model.od.UserAOP;
import com.hospital.service.od.Od_MedicalRecordServer;
import com.hospital.utils.Result;
import com.hospital.utils.ResultCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName Od_MedicalRecordController
 * @Description 这个是用来管理门诊医生的Controller的类,主要的功能具有
 *  <P>
 *      <li>门诊首页功能</li>
 *      <li>门诊病历（以身份证号码/名字查询以往的病历首页）</li>
 *      <li>成药草药处方（申请处方）</li>
 *      <li>西药处方（申请处方）</li>
 *      <Li>检查申请</Li>
 *      <Li>检验申请</Li>
 *      <li>处置申请</li>
 *      <Li>患者账单</Li>
 *  </P>
 *  所有的申请都可以进行查询结果
 *
 * @Author 方聪
 * @Date 2019/6/5 18:18
 * @Version 1.0
 **/
@RestController //全部以JSON数据格式进行回复
@RequestMapping("/od")
@CrossOrigin
public class Od_MedicalRecordController {

    @RequestMapping("/hi")
    public String sayHello(){
        return "hello od";
    }

    @RequestMapping(value = "/findUserByName/{name}",method = RequestMethod.GET)
    public Result findUserByName(@PathVariable String name){
       // 查询数据库是否具有该数据
        List<UserAOP> ua = new ArrayList<>();
        ua.add(new UserAOP("张三",new Date(),"上海南阳"));
        ua.add(new UserAOP("李四",new Date(),"大连重庆"));
        ua.add(new UserAOP("徐三历",new Date(),"重庆南昌"));
        List<UserAOP> f = new ArrayList<>();
        for(UserAOP u :ua){
            if(u.getName().contains(name)){
                f.add(u);
            }
        }
        return new Result(ResultCode.SUCCESS,f);
    }


    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public Result listUser(){
        // 查询数据库是否具有该数据
        List<UserAOP> ua = new ArrayList<>();
        ua.add(new UserAOP("张三",new Date(),"上海南阳"));
        ua.add(new UserAOP("李四",new Date(),"大连重庆"));
        ua.add(new UserAOP("徐三历",new Date(),"重庆南昌"));
        return new Result(ResultCode.SUCCESS,ua);
    }

//    @Autowired
//    Od_MedicalRecordServer od_server;
    /**
     * @Description 当天的申请对应的医生id的挂号病人，但是未进行看诊的病人，也就是在等待的病人。
     * @Date 18:39 2019/6/5
     * @Author 方聪
     * @Para mn5498*·m id : 这个是转入的医生的ID,用来指定是获得那个医生
     * @return 返回的是正在等待就诊的病人
     **/
    @RequestMapping(value = "/getWaitPatient/{od_id}",method = RequestMethod.GET)
    public Result getWaitPatient(@PathVariable int od_id){
        //1.首先检查od_id是否已经登陆到系统中
        //2.其次再查询今天等待的病人 系统会有一个定时任务的（就是会把当天为进行看诊的病人的状态给改为失效）
        //3.返回结果
        return null;
    }

    /**
     * @Description 当天的申请对应的医生id的挂号病人，得到正在看诊中的病人，也就是包括那些去检查的病人。
     * @Date 18:39 2019/6/5
     * @Author 方聪
     * @Para od_id: 这个是转入的医生的ID,用来指定是获得那个医生
     * @return 返回的是正在看诊中的病人
     **/
    @RequestMapping(value = "/getPatient/{od_id}",method = RequestMethod.GET)
    public Result getPatient(@PathVariable int od_id){
        //1.首先检查od_id是否已经登陆到系统中
        //2.其次再查询今天等待的病人 系统会有一个定时任务的（就是会把当天为进行看诊的病人的状态给改为失效）
        //3.返回结果
        return null;
    }




}
