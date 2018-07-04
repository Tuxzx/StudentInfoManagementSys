package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MgtGetAllCourseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        req.setAttribute("allcourse",adminService.getAllElective());
        req.getRequestDispatcher("courseMgt.jsp").forward(req,resp);
    }
}
