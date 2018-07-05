package com.tuxzx.sci.service;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.User;

import java.util.List;

public interface AdminService {
    // 用户信息管理
    String getAllUserInfo();
    // 添加用户
    boolean addUser(User user);
    // 删除用户
    boolean removeUser(String uid);
    // 更新用户信息
    boolean updateUser(User user);
    // 判断用户是否存在
    boolean isUserExist(String uid);
    // 课程信息管理
    // 获取所有课程信息
    String getAllCourseInfo();
    // 更新课程信息
    boolean updateCourse(Course course);
    // 更新选课信息
    boolean updateElective(Elective elective);
    // 获取所有选课信息
    String getAllElective();
    // 增加课程
    boolean addCourse(Course course);
    // 删除课程
    boolean removeCourse(String cid);
}
