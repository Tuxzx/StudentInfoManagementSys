package com.tuxzx.sci.bean;

public class CountInfo {
    private String uid;
    private String name;
    private int countScore;
    private int passLesson;
    private int failedLesson;

    public CountInfo() {
    }

    public CountInfo(String uid, String name, int countScore, int passLesson, int failedLesson) {
        this.uid = uid;
        this.name = name;
        this.countScore = countScore;
        this.passLesson = passLesson;
        this.failedLesson = failedLesson;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountScore() {
        return countScore;
    }

    public void setCountScore(int countScore) {
        this.countScore = countScore;
    }

    public int getPassLesson() {
        return passLesson;
    }

    public void setPassLesson(int passLesson) {
        this.passLesson = passLesson;
    }

    public int getFailedLesson() {
        return failedLesson;
    }

    public void setFailedLesson(int failedLesson) {
        this.failedLesson = failedLesson;
    }
}
