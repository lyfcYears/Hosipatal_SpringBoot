package com.hospital.model.od;

import java.util.Date;

public class MedicalRecordPageTemplate {
    private Integer id;

    private String templateName;

    private Integer departmentNo;

    private Integer outpatientDoctorNo;

    private String chiefComplaint;

    private String historyPresentIllness;

    private String historyPresentIllnessSituation;

    private String historyIllness;

    private String historyAllergy;

    private String healthExamine;

    private String tentativeDiagnosis;

    private Date createTime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(Integer departmentNo) {
        this.departmentNo = departmentNo;
    }

    public Integer getOutpatientDoctorNo() {
        return outpatientDoctorNo;
    }

    public void setOutpatientDoctorNo(Integer outpatientDoctorNo) {
        this.outpatientDoctorNo = outpatientDoctorNo;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint == null ? null : chiefComplaint.trim();
    }

    public String getHistoryPresentIllness() {
        return historyPresentIllness;
    }

    public void setHistoryPresentIllness(String historyPresentIllness) {
        this.historyPresentIllness = historyPresentIllness == null ? null : historyPresentIllness.trim();
    }

    public String getHistoryPresentIllnessSituation() {
        return historyPresentIllnessSituation;
    }

    public void setHistoryPresentIllnessSituation(String historyPresentIllnessSituation) {
        this.historyPresentIllnessSituation = historyPresentIllnessSituation == null ? null : historyPresentIllnessSituation.trim();
    }

    public String getHistoryIllness() {
        return historyIllness;
    }

    public void setHistoryIllness(String historyIllness) {
        this.historyIllness = historyIllness == null ? null : historyIllness.trim();
    }

    public String getHistoryAllergy() {
        return historyAllergy;
    }

    public void setHistoryAllergy(String historyAllergy) {
        this.historyAllergy = historyAllergy == null ? null : historyAllergy.trim();
    }

    public String getHealthExamine() {
        return healthExamine;
    }

    public void setHealthExamine(String healthExamine) {
        this.healthExamine = healthExamine == null ? null : healthExamine.trim();
    }

    public String getTentativeDiagnosis() {
        return tentativeDiagnosis;
    }

    public void setTentativeDiagnosis(String tentativeDiagnosis) {
        this.tentativeDiagnosis = tentativeDiagnosis == null ? null : tentativeDiagnosis.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}