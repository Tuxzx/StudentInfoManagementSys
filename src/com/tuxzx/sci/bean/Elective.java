package com.tuxzx.sci.bean;

import java.util.Date;

public class Elective {
    private String uid;
    private String cid;
    private int result;
    private Date testDate;

    public Elective(String uid, String cid, int result, Date testDate) {
        this.uid = uid;
        this.cid = cid;
        this.result = result;
        this.testDate = testDate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
