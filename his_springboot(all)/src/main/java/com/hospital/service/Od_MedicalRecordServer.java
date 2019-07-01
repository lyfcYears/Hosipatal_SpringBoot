package com.hospital.service;

import com.hospital.model.od.Disease;
import com.hospital.model.od.MedicalRecordPage;
import com.hospital.model.od.MedicalRecordPageTemplate;
import com.hospital.model.od.UsedDiagnosi;
import com.hospital.model.sf.RegistrationInfo;

import java.util.List;

public interface Od_MedicalRecordServer {
    String test();

    List<RegistrationInfo> getWaitPatient(int od_id, String today);

    List<RegistrationInfo> getSeeEdPatient(int od_id, String today);

    MedicalRecordPage getMedicalRecordPageByPatientBLH(String blh);

    /**
     * @Description 该方法是暂存病历号,需要更换用户is_see_doctor的状态为2
     * @Date 14:45 2019/6/13
     * @Param [blh]
     * @return void
     **/
    void PutMedicalRecordPage(String blh, MedicalRecordPage mrp);

    List<RegistrationInfo> getDePartMentPatient(int dePartMent_id, String today);

    void postMRPTemplate(MedicalRecordPageTemplate mrpTemplate);

    List<MedicalRecordPageTemplate> getMRPDePartMentTmplate(int doctorDePartMentID);

    List<MedicalRecordPageTemplate> getMRPMyTemplate(int doctorID);

    MedicalRecordPageTemplate getMRPTmplateByID(int id);

    List<MedicalRecordPageTemplate> getMRPTmplateByDoctorID(int doctorID);

    List<Disease> getDisease(String code, String name);

    void postUsedDiagnosi(UsedDiagnosi dia);

    List<UsedDiagnosi> getUsedDiagnosi(int doctorID);


    //需要对于以下的每一个方法名进行注释

}
