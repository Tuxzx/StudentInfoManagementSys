package com.tuxzx.sci.bean;

import java.util.Date;

public class Course {
    private String cid;
    private String name;
    private int score;
    private int theoryLesson;
    private int practiceLesson;
    private String testMethod;
    private Date testDate;

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
}
