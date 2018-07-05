package com.tuxzx.sci.service.impl;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.CourseDao;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.CourseDaoImpl;
import com.tuxzx.sci.dal.impl.UserDaoImpl;
import com.tuxzx.sci.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public String getAllUserInfo() {
        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.getAllUser();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>账号</th><th>密码</th><th>用户名</th><th>性别</th><th>年龄</th><th>电话</th><th>权限级别</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<userList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+userList.get(i).getUid()+"</td>" +
                    "<td>"+userList.get(i).getPassword()+"</td>" +
                    "<td>"+userList.get(i).getUsername()+"</td>" +
                    "<td>"+userList.get(i).getGender()+"</td>" +
                    "<td>"+userList.get(i).getAge()+"</td>" +
                    "<td>"+userList.get(i).getTel()+"</td>" +
                    "<td>"+userList.get(i).getRole()+"</td>" +
                    "<td>"+"<input type=\"button\" class=\"btn btn-primary\" onclick=\"updateUserinfo(event)\" value=\"修改\" >"+"</td>"+
                    "<td>"+"<input type=\"button\" class=\"btn btn-danger\" onclick=\"deleteUserAjax(event)\" value=\"删除\" >"+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.addUser(user);
    }

    @Override
    public boolean removeUser(String uid) {
        UserDao userDao = new UserDaoImpl();
        return userDao.removeUser(uid);
    }

    @Override
    public boolean updateUser(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUserinfoSuper(user);
    }

    @Override
    public boolean isUserExist(String uid) {
        UserDao userDao = new UserDaoImpl();
        return userDao.isUserExist(uid);
    }

    @Override
    public String getAllCourseInfo() {
        CourseDao courseDao = new CourseDaoImpl();
        List<Course> courseList = courseDao.getAllCourse();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>课程号</th><th>课程名</th><th>学分</th><th>理论学时</th><th>实践学时</th><th>考核方式</th><th>考核时间</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<courseList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+courseList.get(i).getCid()+"</td>" +
                    "<td>"+courseList.get(i).getName()+"</td>" +
                    "<td>"+courseList.get(i).getScore()+"</td>" +
                    "<td>"+courseList.get(i).getTheoryLesson()+"</td>" +
                    "<td>"+courseList.get(i).getPracticeLesson()+"</td>" +
                    "<td>"+courseList.get(i).getTestMethod()+"</td>" +
                    "<td>"+courseList.get(i).getTestDate()+"</td>" +
                    "<td>"+"<input type=\"button\" class=\"btn btn-primary\" onclick=\"updateCourseinfo(event)\" value=\"修改\" >"+"</td>"+
                    "<td>"+"<input type=\"button\" class=\"btn btn-danger\" onclick=\"deleteCourseAjax(event)\" value=\"删除\" >"+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean updateCourse(Course course) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.updateCourseInfo(course);
    }

    @Override
    public boolean updateElective(Elective elective) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.updateElectiveInfo(elective);
    }

    @Override
    public String getAllElective() {
        CourseDao courseDao = new CourseDaoImpl();
        List<Elective> electiveList = courseDao.getAllElective();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<thead><tr>" +
                "<th>学号</th><th>姓名</th><th>课程号</th><th>课程名</th><th>成绩</th>" +
                "</tr></thead>" +
                "<tbody>");
        for (int i=0; i<electiveList.size(); i++) {
            stringBuilder.append("<tr>" +
                    "<td>"+electiveList.get(i).getUid()+"</td>" +
                    "<td>"+electiveList.get(i).getUname()+"</td>" +
                    "<td>"+electiveList.get(i).getCid()+"</td>" +
                    "<td>"+electiveList.get(i).getCname()+"</td>" +
                    "<td>"+electiveList.get(i).getResult()+"</td>" +
                    "<td>"+"<input type=\"button\" class=\"btn btn-primary\" onclick=\"updateElectiveinfo(event)\" value=\"修改\" >"+"</td>"+
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean addCourse(Course course) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.addCourse(course);
    }

    @Override
    public boolean removeCourse(String cid) {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.removeCourse(cid);
    }
}
