package com.tuxzx.sci.service.impl;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Grade;
import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.CourseDao;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.CourseDaoImpl;
import com.tuxzx.sci.dal.impl.UserDaoImpl;
import com.tuxzx.sci.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean updateStudentInfo(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUserinfo(user);
    }

    @Override
    public String getAllCourse() {
        CourseDao courseDao = new CourseDaoImpl();
        List<Course> courseList = courseDao.getAllCourse();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>课程号</th><th>课程名</th><th>学分</th>" +
                "<th>理论学分</th><th>实践学分</th><th>考核方式</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<courseList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+courseList.get(i).getCid()+"</td>" +
                    "<td>"+courseList.get(i).getName()+"</td>" +
                    "<td>"+courseList.get(i).getScore()+"</td>" +
                    "<td>"+courseList.get(i).getTheoryLesson()+"</td>" +
                    "<td>"+courseList.get(i).getPracticeLesson()+"</td>" +
                    "<td>"+courseList.get(i).getTestMethod()+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public String getAllCourseSelectable() {
        CourseDao courseDao = new CourseDaoImpl();
        List<Course> courseList = courseDao.getAllCourse();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>课程号</th><th>课程名</th><th>学分</th>" +
                "<th>选课</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<courseList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+courseList.get(i).getCid()+"</td>" +
                    "<td>"+courseList.get(i).getName()+"</td>" +
                    "<td>"+courseList.get(i).getScore()+"</td>" +
                    "<td>"+"<input type=\"button\" class=\"btn btn-primary\" onclick=\"addCourse(event)\" value=\"添加\" >"+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean selectCourse(String uid, String cid) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.selectCourse(uid, cid);
    }

    @Override
    public String getAllSelectedCourse(String uid) {
        CourseDao courseDao = new CourseDaoImpl();
        List<Course> courseList = courseDao.getAllSelectedCourse(uid);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>课程号</th><th>课程名</th><th>学分</th>" +
                "<th>选课</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<courseList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+courseList.get(i).getCid()+"</td>" +
                    "<td>"+courseList.get(i).getName()+"</td>" +
                    "<td>"+courseList.get(i).getScore()+"</td>" +
                    "<td>"+"<input type=\"button\" class=\"btn btn-primary\" onclick=\"removeCourse(event)\" value=\"退选\" >"+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean cancelSelectCourse(String uid, String cid) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.cancelSelectCourse(uid, cid);
    }

    @Override
    public String getUserGrade(String uid) {
        CourseDao courseDao = new CourseDaoImpl();
        List<Grade> gradeList = courseDao.getGrade(uid);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>课程号</th><th>课程名</th><th>成绩</th><th>考核日期</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>");
        for (int i=0; i<gradeList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+gradeList.get(i).getCid()+"</td>" +
                    "<td>"+gradeList.get(i).getCname()+"</td>" +
                    "<td>"+gradeList.get(i).getResult()+"</td>" +
                    "<td>"+gradeList.get(i).getTestDate()+"</td>" +
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }
}
