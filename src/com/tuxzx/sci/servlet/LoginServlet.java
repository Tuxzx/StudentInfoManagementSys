package com.tuxzx.sci.servlet;


import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.LoginService;
import com.tuxzx.sci.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单输入框中的账户和密码
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        LoginService loginService = new LoginServiceImpl();
        User user = loginService.findUser(uid, password);
        if (user == null) {
            req.setAttribute("error","登陆失败...<br>请检查用户名和密码是否错误");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            resp.sendRedirect("./error.jsp");
        }else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("./studentInfo.jsp");
        }

    }
}
