package com.hospital.model.sf;

public class RegistrationPayWay {
    private Integer id;

    private Integer registrationNo;

    private String medicalRecord;

    private Integer registrationPayNo;

    private String registrationPayName;

    private String blank1;

    private String blank2;

    private String blank3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(Integer registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public Integer getRegistrationPayNo() {
        return registrationPayNo;
    }

    public void setRegistrationPayNo(Integer registrationPayNo) {
        this.registrationPayNo = registrationPayNo;
    }

    public String getRegistrationPayName() {
        return registrationPayName;
    }

    public void setRegistrationPayName(String registrationPayName) {
        this.registrationPayName = registrationPayName == null ? null : registrationPayName.trim();
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1 == null ? null : blank1.trim();
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2 == null ? null : blank2.trim();
    }

    public String getBlank3() {
        return blank3;
    }

    public void setBlank3(String blank3) {
        this.blank3 = blank3 == null ? null : blank3.trim();
    }
}