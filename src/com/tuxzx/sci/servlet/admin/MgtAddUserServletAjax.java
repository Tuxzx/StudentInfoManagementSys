package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.LoginService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;
import com.tuxzx.sci.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MgtAddUserServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.valueOf(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String tel = req.getParameter("tel");
        AdminService adminService = new AdminServiceImpl();
        boolean registerStatus = adminService.addUser(new User(uid, username, password, gender, age, tel, 0));
        if (registerStatus) {
            resp.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            System.out.println("update:ture");
            PrintWriter writer = resp.getWriter();
            writer.write(adminService.getAllUserInfo());
            System.out.println(adminService.getAllUserInfo());
        } else {
            req.setAttribute("error","注册失败<br>您注册的账号："+uid+"已存在！<br>请更换后重新注册");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            resp.sendRedirect("/error.jsp");
        }
    }
}
