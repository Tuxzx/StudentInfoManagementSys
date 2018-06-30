package com.tuxzx.sci.servlet;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getAllSelectedCourseServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        UserService userService = new UserServiceImpl();
        PrintWriter writer = resp.getWriter();
        writer.write(userService.getAllSelectedCourse(user.getUid()));
    }
}
