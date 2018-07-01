package com.tuxzx.sci.servlet;

import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;
import com.tuxzx.sci.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MgtGetAllUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        req.setAttribute("alluserinfo",adminService.getAllUserInfo());
        req.getRequestDispatcher("studentMgt.jsp").forward(req,resp);
        resp.sendRedirect("./studentMgt.jsp");
    }
}
