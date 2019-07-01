package com.hospital.service.lmp;

import com.hospital.mapper.MedicalRecordPageMapper;
import com.hospital.mapper.MedicalRecordPageTemplateMapper;
import com.hospital.mapper.RegistrationInfoMapper;
import com.hospital.model.od.MedicalRecordPage;
import com.hospital.model.od.MedicalRecordPageExample;
import com.hospital.model.od.MedicalRecordPageTemplate;
import com.hospital.model.od.MedicalRecordPageTemplateExample;
import com.hospital.model.sf.RegistrationInfo;
import com.hospital.model.sf.RegistrationInfoExample;
import com.hospital.service.Od_MedicalRecordServer;
import com.hospital.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName Od_MedicalRecordServerlmp
 * @Description 请输入你的简化描述！
 * @Author 方聪
 * @Date 2019/6/5 18:46
 * @Version 1.0
 **/
@Service
public class Od_MedicalRecordServerLmp implements Od_MedicalRecordServer {

    Logger logger = LoggerFactory.getLogger(Od_MedicalRecordServerLmp.class);

    @Resource
    MedicalRecordPageMapper odMapper;

    @Resource
    MedicalRecordPageTemplateMapper mrpTeplateMapper;
    @Resource
    RegistrationInfoMapper reginstrMapper;


    @Override
    public String test() {
        return null;
    }

    @Override
    public List<RegistrationInfo> getWaitPatient(int od_id, String today) {
        RegistrationInfoExample example = new RegistrationInfoExample();
        RegistrationInfoExample.Criteria c = example.createCriteria();
//        选择条件
        c.andOutpatientDoctorNoEqualTo(od_id);
        c.andCreateTimeBetween(DateUtils.getSqlDate(today+" 00:00:00"),DateUtils.getSqlDate(DateUtils.getDate()));
        c.andStateEqualTo("1");//1 是有效的
        c.andIsSeenDocatorEqualTo("1");

        List<RegistrationInfo> registrationInfos = reginstrMapper.selectByExample(example);

        return registrationInfos;

    }

    @Override
    public List<RegistrationInfo> getSeeEdPatient(int od_id, String today) {

        RegistrationInfoExample example = new RegistrationInfoExample();
        RegistrationInfoExample.Criteria c = example.createCriteria();
//        选择条件
        c.andOutpatientDoctorNoEqualTo(od_id);
        c.andCreateTimeBetween(DateUtils.getSqlDate(today+" 00:00:00"),DateUtils.getSqlDate(DateUtils.getDate()));

        c.andStateEqualTo("1");// 是有效的

        List<String> s = new ArrayList<>();
        s.add("2");
        s.add("3");
        c.andIsSeenDocatorIn(s);

        List<RegistrationInfo> registrationInfos = reginstrMapper.selectByExample(example);

        return registrationInfos;


    }

    @Override
    public MedicalRecordPage getMedicalRecordPageByPatientBLH(String blh) {

        MedicalRecordPageExample ex = new MedicalRecordPageExample();
        MedicalRecordPageExample.Criteria c = ex.createCriteria();

        c.andStateEqualTo("1");
        c.andMedicalRecordEqualTo(blh);
        List<MedicalRecordPage> medicalRecordPages = odMapper.selectByExample(ex);
        if(medicalRecordPages == null)
            return null;
        else {
            return medicalRecordPages.get(0);
        }
    }


    @Override
    public void PutMedicalRecordPage(String blh, MedicalRecordPage mrp) {
        MedicalRecordPageExample ex = new MedicalRecordPageExample();
        MedicalRecordPageExample.Criteria c = ex.createCriteria();
        MedicalRecordPage m = getMedicalRecordPageByPatientBLH(blh);
        if(m == null){
            //为空,新创建
            odMapper.insert(mrp);
        } else {
            //update
            odMapper.updateByPrimaryKey(mrp);
        }

    }

    @Override
    public List<RegistrationInfo> getDePartMentPatient(int dePartMent_id, String today) {
        List<RegistrationInfo> registrationInfo = null;
        try {
            System.out.println(dePartMent_id + today);

            RegistrationInfoExample ex = new RegistrationInfoExample();
            RegistrationInfoExample.Criteria c = ex.createCriteria();
            c.andStateEqualTo("1");
            c.andDepartmentNoEqualTo(dePartMent_id);

            c.andCreateTimeBetween(DateUtils.getSqlDate(today+" 00:00:00"),DateUtils.getSqlDate(DateUtils.getDate()));
            registrationInfo = reginstrMapper.selectByExample(ex);

        }catch(Exception e){

            System.out.println(e.getMessage());
        }
        return registrationInfo;
    }

    /**
     * @Description 上传模板
     * @Date 11:22 2019/6/14
     * @Param [mrpTemplate]
     * @return void
     **/
    @Override
    public void postMRPTemplate(MedicalRecordPageTemplate mrpTemplate) {
        mrpTeplateMapper.insert(mrpTemplate);
    }

    @Override
    public List<MedicalRecordPageTemplate> getMRPDePartMentTmplate(int doctorDePartMentID) {

        MedicalRecordPageTemplateExample ex = new MedicalRecordPageTemplateExample();
        MedicalRecordPageTemplateExample.Criteria c = ex.createCriteria();

        c.andStateEqualTo("1");
        c.andDepartmentNoEqualTo(doctorDePartMentID);
        List<MedicalRecordPageTemplate> medicalRecordPageTemplates = mrpTeplateMapper.selectByExample(ex);

        return medicalRecordPageTemplates;
    }

    @Override
    public List<MedicalRecordPageTemplate> getMRPMyTemplate(int doctorID) {
        //sql
        MedicalRecordPageTemplateExample ex = new MedicalRecordPageTemplateExample();
        MedicalRecordPageTemplateExample.Criteria c = ex.createCriteria();

        c.andStateEqualTo("1");
        c.andOutpatientDoctorNoEqualTo(doctorID);

        List<MedicalRecordPageTemplate> medicalRecordPageTemplates = mrpTeplateMapper.selectByExample(ex);
        return medicalRecordPageTemplates;
    }

    @Override
    public MedicalRecordPageTemplate getMRPTmplateByID(int id) {
        return null;
    }

    @Override
    public List<MedicalRecordPageTemplate> getMRPTmplateByDoctorID(int doctorID) {
        return null;
    }
}
