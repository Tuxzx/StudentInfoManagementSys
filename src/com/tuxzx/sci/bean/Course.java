package com.tuxzx.sci.bean;


import java.sql.Date;

public class Course {
    private String cid;
    private String name;
    private int score;
    private int theoryLesson;
    private int practiceLesson;
    private String testMethod;
    private Date testDate;

    public Course() {
    }

    public Course(String cid, String name, int score, int theoryLesson, int practiceLesson, String testMethod, Date testDate) {
        this.cid = cid;
        this.name = name;
        this.score = score;
        this.theoryLesson = theoryLesson;
        this.practiceLesson = practiceLesson;
        this.testMethod = testMethod;
        this.testDate = testDate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public int getPracticeLesson() {
        return practiceLesson;
    }

    public void setPracticeLesson(int practiceLesson) {
        this.practiceLesson = practiceLesson;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        String str = "课程号："+cid+
                "\n课程名："+name+
                "\n学分："+score+
                "\n理论学时："+theoryLesson+
                "\n实践学时："+practiceLesson+
                "\n考核方式："+testMethod+
                "\n考核时间："+testDate;
        return str;
    }
}
