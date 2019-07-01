package com.hospital.model.sf;

public class RegistrationPay {
    private Integer id;

    private String payName;

    private Integer reimbursementRatio;

    private String blank1;

    private String blank2;

    private String blank3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public Integer getReimbursementRatio() {
        return reimbursementRatio;
    }

    public void setReimbursementRatio(Integer reimbursementRatio) {
        this.reimbursementRatio = reimbursementRatio;
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