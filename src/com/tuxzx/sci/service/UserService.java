package com.tuxzx.sci.service;

import com.tuxzx.sci.bean.User;

public interface UserService {
    // 学生信息更新
    boolean updateStudentInfo(User user);
    // 获取所有课程信息
    String getAllCourse();
    // 获取所有可选课程信息
    String getAllCourseSelectable();
    // 选课
    boolean selectCourse(String uid, String cid);
    // 获取所有已选课程信息
    String getAllSelectedCourse(String uid);
    // 退课
    boolean cancelSelectCourse(String uid, String cid);
    // 获取用户成绩
    String getUserGrade(String uid);
}
