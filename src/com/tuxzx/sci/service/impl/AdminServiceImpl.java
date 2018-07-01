package com.tuxzx.sci.service.impl;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.UserDao;
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
                    "</tr>");
        }
        stringBuilder.append("</tbody>");
        return stringBuilder.toString();
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean removeUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean isUserExist(String uid) {
        return false;
    }
}
