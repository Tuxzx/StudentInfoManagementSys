package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;
import com.tuxzx.sci.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MgtRemoveUserServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String uid = req.getParameter("uid");
        AdminService adminService = new AdminServiceImpl();
        System.out.println("ajax后台响应");
        PrintWriter out = resp.getWriter();
        if (adminService.removeUser(uid)) {
            out.write(adminService.getAllUserInfo());
            System.out.println(adminService.getAllUserInfo());
        } else {
            out.write("服务器异常！！！");
        }
    }
}
