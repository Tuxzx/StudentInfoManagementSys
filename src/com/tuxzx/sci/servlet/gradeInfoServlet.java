package com.tuxzx.sci.servlet;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class gradeInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询学生成绩
        User user = (User) req.getSession().getAttribute("user");
        UserService userService = new UserServiceImpl();
        req.setAttribute("gradeInfo",userService.getUserGrade(user.getUid()));
        req.getRequestDispatcher("gradeInfo.jsp").forward(req,resp);
        resp.sendRedirect("/gradeInfo.jsp");
    }
}
