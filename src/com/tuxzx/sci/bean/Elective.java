package com.tuxzx.sci.bean;

import java.util.Date;

public class Elective {
    private String uid;
    private String cid;
    private int result;

    private String uname;
    private String cname;

    public Elective(){}

    /**
     * 对应数据库中表 elective 的bean
     * @param uid
     * @param cid
     * @param result
     */
    public Elective(String uid, String cid, int result) {
        this.uid = uid;
        this.cid = cid;
        this.result = result;
    }

    /**
     * 面向表单数据的节点bean
     * @param uid
     * @param cid
     * @param result
     * @param uname
     * @param cname
     */
    public Elective(String uid, String cid, int result, String uname, String cname) {
        this.uid = uid;
        this.cid = cid;
        this.result = result;
        this.uname = uname;
        this.cname = cname;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
