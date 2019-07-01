package com.hospital.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.hospital.model.od.*;
import com.hospital.model.sf.RegistrationInfo;
import com.hospital.service.Od_MedicalRecordServer;
import com.hospital.utils.Result;
import com.hospital.utils.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

@Api(value = "用户的接口",tags={"方聪负责的门诊医生所需的api文档"})
@RestController //全部以JSON数据格式进行回复
@RequestMapping("/od")
@CrossOrigin
public class Od_MedicalRecordController {
    private Logger logger = LoggerFactory.getLogger(Od_MedicalRecordController.class);

    @Autowired
    Od_MedicalRecordServer od_medicalRecordServer;

    /**
     * @Description  得到当天登陆用户医生的id
     * @Date 14:25 2019/6/13
     * @Param []
     * @return int
     **/
    public int getDoctorID(){
        //通过shiro进行配置
        return 1;
    }
    /**
     * @Description  得到当天登陆用户医生所在的部门的id
     * @Date 14:25 2019/6/13
     * @Param []
     * @return int
     **/
    private int getDoctorDePartMentID() {
        return 1;
    }

    @ApiOperation(value = "getWaitPatient",notes = "得到当天本门诊医生已经挂号，但是未看诊的病人，is_seen_docator == 1")
    @GetMapping(value = "/getWaitPatient")
    public Result getWaitPatient(){
        //1.首先检查od_id是否已经登陆到系统中
        int od_id =  getDoctorID();//用户的id,我们这先模拟下
        //2.其次再查询今天等待的病人 系统会有一个定时任务的（就是会把当天为进行看诊的病人的状态给改为失效）
        String today= DateUtil.today();
        List<RegistrationInfo> list = od_medicalRecordServer.getWaitPatient(od_id,today);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }


    @ApiOperation(value = "getSeeEdPatient",notes = "得到当天本门诊医生已经挂号，但是看诊中和看诊完的病人，is_seen_docator == 2 | 3")
    @GetMapping(value = "/getSeeEdPatient")
    public Result getSeeEdPatient(){
        //1.首先检查od_id是否已经登陆到系统中
        int od_id =  getDoctorID();//用户的id,我们这先模拟下
        //2.其次再查询今天等待的病人 系统会有一个定时任务的（就是会把当天为进行看诊的病人的状态给改为失效）
        String today= DateUtil.today();
        List<RegistrationInfo> list = od_medicalRecordServer.getSeeEdPatient(od_id,today);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }


    @ApiOperation(value = "getDePartMentPatient",notes = "得到所有该医生所属的科院当天看诊的病人，is_seen_docator == 1 | 2 | 3")
    @GetMapping(value = "/getDePartMentPatient")
    public Result getDePartMentPatient(){
        //1.首先检查od_id是否已经登陆到系统中
        int dePartMent_id =  getDoctorDePartMentID();//用户的id,我们这先模拟下
        //2.其次再查询今天等待的病人 系统会有一个定时任务的（就是会把当天为进行看诊的病人的状态给改为失效）
        String today= DateUtil.today();
        System.out.println("查询："+dePartMent_id+"部门，日期为："+today);
        List<RegistrationInfo> list = od_medicalRecordServer.getDePartMentPatient(dePartMent_id, today);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }


    @ApiOperation(value = "getMedicalRecordPageByPatientBLH",notes = "得到{is_seen_docator ==  2 | 3}传入的病人的病历号获得该病人的病历首页<br>因为未看诊的病人是没用病历首页的，在门诊病历首页表进行查询")
    @GetMapping(value = "/getMedicalRecordPageByPatientBLH/{blh}")
    public Result getMedicalRecordPageByPatientBLH(@PathVariable String blh){
        MedicalRecordPage od = od_medicalRecordServer.getMedicalRecordPageByPatientBLH(blh);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,od);
    }

    @ApiOperation(value = "",notes = "得到{is_seen_docator ==  2 | 3}传入的病人的病历号和mrp数据对象 暂存|和保存都执行这个方法,该病人的病历首页" +
            "<br>如果该病人无病历首页,也就是刚刚进行看诊的病人,那么insert插入一条,如果有就update更新," +
            "同时病人的is_seen_docator要从1改变为2")
    @PutMapping(value = "/PutMedicalRecordPage/{blh}/{mrp}")
    public Result PutMedicalRecordPage(@PathVariable String blh,@PathVariable MedicalRecordPage mrp){

        od_medicalRecordServer.PutMedicalRecordPage(blh,mrp);
        //3.返回结果
        return new Result(ResultCode.SUCCESS);
    }


    @ApiOperation(value = "",notes = "获得dica_name 或者dica_code进行查询数据，并且显示在列表中")
    @GetMapping(value = "/getMRPMyTemplate/{code}/{name}")
    public Result getDisease(@PathVariable String code,@PathVariable String name){
        List<Disease> list = od_medicalRecordServer.getDisease(code,name);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }

    @ApiOperation(value = "",notes = "医生添加到自己的诊断到常用代码")
    @PostMapping(value = "/postUsedDiagnosi")
    public Result postUsedDiagnosi(@RequestBody UsedDiagnosi dia){
        dia.setDoctorNo(getDoctorID());
        od_medicalRecordServer.postUsedDiagnosi(dia);
        //3.返回结果
        return new Result(ResultCode.SUCCESS);
    }


    @ApiOperation(value = "",notes = "获得医生常用代码")
    @GetMapping(value = "/getUsedDiagnosi")
    public Result getUsedDiagnosi(){

        List<UsedDiagnosi> list = od_medicalRecordServer.getUsedDiagnosi(getDoctorID());
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }
































//    模板

    @ApiOperation(value = "",notes = "传入模板对象，模板对象可以没创建时间，可不传入部门id,医生id,需要在创建模板的时候填写模板的名称")
    @PostMapping(value = "/postMRPTemplate")
    public Result postMRPTemplate(@RequestBody MedicalRecordPageTemplate mrpTemplate){

        mrpTemplate.setDepartmentNo(getDoctorDePartMentID());
        mrpTemplate.setOutpatientDoctorNo(getDoctorID());
        mrpTemplate.setCreateTime(new DateTime());

        od_medicalRecordServer.postMRPTemplate(mrpTemplate);
        //3.返回结果
        return new Result(ResultCode.SUCCESS);
    }


    @ApiOperation(value = "",notes = "获得个人的门诊首页病历个人创建的模板list数据")
    @GetMapping(value = "/getMRPMyTemplate")
    public Result getMRPMyTemplate(){


        List<MedicalRecordPageTemplate> list = od_medicalRecordServer.getMRPMyTemplate(getDoctorID());
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }


    @ApiOperation(value = "",notes = "获得科院的门诊首页病历创建全部模板list数据")
    @GetMapping(value = "/getMRPDePartMentTmplate")
    public Result getMRPDePartMentTmplate(){

        List<MedicalRecordPageTemplate> list = od_medicalRecordServer.getMRPDePartMentTmplate(getDoctorDePartMentID());
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }

    @ApiOperation(value = "",notes = "通过一个模板id获得模板的对象")
    @GetMapping(value = "/getMRPTmplateByID/{id}")
    public Result getMRPTmplateByID(@PathVariable int id){

        MedicalRecordPageTemplate list = od_medicalRecordServer.getMRPTmplateByID(id);
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }

    @ApiOperation(value = "",notes = "获得医生创建的所有的门诊首页的模板")
    @GetMapping(value = "/getMRPTmplateByDoctorID")
    public Result getMRPTmplateByDoctorID(){

        List<MedicalRecordPageTemplate>  list = od_medicalRecordServer.getMRPTmplateByDoctorID(getDoctorID());
        //3.返回结果
        return new Result(ResultCode.SUCCESS,list);
    }













}
