package com.hospital.model.sf;

import java.math.BigDecimal;

public class RegistrationFee {
    private Integer id;

    private Integer registrationInfoNo;

    private String medicalRecord;

    private String patientName;

    private Integer registrationPayNo;

    private Integer registrarNo;

    private String registrarName;

    private BigDecimal price;

    private Integer createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistrationInfoNo() {
        return registrationInfoNo;
    }

    public void setRegistrationInfoNo(Integer registrationInfoNo) {
        this.registrationInfoNo = registrationInfoNo;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getRegistrationPayNo() {
        return registrationPayNo;
    }

    public void setRegistrationPayNo(Integer registrationPayNo) {
        this.registrationPayNo = registrationPayNo;
    }

    public Integer getRegistrarNo() {
        return registrarNo;
    }

    public void setRegistrarNo(Integer registrarNo) {
        this.registrarNo = registrarNo;
    }

    public String getRegistrarName() {
        return registrarName;
    }

    public void setRegistrarName(String registrarName) {
        this.registrarName = registrarName == null ? null : registrarName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}