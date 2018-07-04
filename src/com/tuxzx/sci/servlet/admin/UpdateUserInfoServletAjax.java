package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 学生管理页面学生信息模态框ajax
 */
public class UpdateUserInfoServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        int age = Integer.parseInt(req.getParameter("age"));
        String tel = req.getParameter("tel");
        int role = Integer.parseInt(req.getParameter("role"));
        User user = new User(uid, username, password, gender, age, tel, role);
        System.out.println(user);
        AdminService adminService = new AdminServiceImpl();
        System.out.println("start");
        if (adminService.updateUser(user)) {
            resp.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            System.out.println("update:ture");
            PrintWriter writer = resp.getWriter();
            writer.write(adminService.getAllUserInfo());
            System.out.println(adminService.getAllUserInfo());
        }
    }
}
