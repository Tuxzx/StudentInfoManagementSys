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
        String uid = req.getParameter("uid");                       // 获取账户
        String password = req.getParameter("password");             // 获取密码
        LoginService loginService = new LoginServiceImpl();            // 获取Service层实例
        User user = loginService.findUser(uid, password);              // 通过账户密码调用service层对象获取用户对象
        if (user == null) {
            req.setAttribute("error","登陆失败...<br>请检查用户名和密码是否错误");   // request域中存放错误信息
            req.getRequestDispatcher("error.jsp").forward(req,resp);                    // 推送
            resp.sendRedirect("./error.jsp");                                           // 重定向
        }else {
            req.getSession().setAttribute("user", user);            // 把获得的user对象存进Session域中
            if (user.getRole()==0) {                                   // 判断用户权限 确定学生管理员并重定向到不同的页面
                resp.sendRedirect("./studentInfo.jsp");
            } else {
                resp.sendRedirect("./adminMgt.jsp");
            }
        }

    }
}
