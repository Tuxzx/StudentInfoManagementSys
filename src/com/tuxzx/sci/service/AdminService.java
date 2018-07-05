package com.tuxzx.sci.service;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.User;

import java.util.List;

public interface AdminService {
    // 用户信息管理
    String getAllUserInfo();

    boolean addUser(User user);

    boolean removeUser(String uid);

    boolean updateUser(User user);

    boolean isUserExist(String uid);

    // 课程信息管理
    String getAllCourseInfo();

    boolean updateCourse(Course course);

    boolean updateElective(Elective elective);

    String getAllElective();

    boolean addCourse(Course course);

    boolean removeCourse(String cid);

}
