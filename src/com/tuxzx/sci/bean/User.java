package com.tuxzx.sci.bean;

public class User {
    private String uid;
    private String username;
    private String password;
    private String gender;
    private int age;
    private String tel;
    private int role;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        String str = "学号："+uid+"\n用户名："+username+"\n密码："+
                password+"\n性别："+gender+"\n年龄："+tel+"\n电话："+
                tel+"\n权限："+role;
        return str;
    }
}
