package com.tuxzx.sci.bean;

import java.util.Date;

public class Grade {
    private String cid;
    private String cname;
    private int result;
    private Date testDate;

    public Grade() {
    }

    public Grade(String cid, String cname, int result, Date testDate) {
        this.cid = cid;
        this.cname = cname;
        this.result = result;
        this.testDate = testDate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
