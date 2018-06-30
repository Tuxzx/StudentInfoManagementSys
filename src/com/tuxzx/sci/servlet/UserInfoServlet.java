package com.tuxzx.sci.servlet;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得uid
        User oldUser = (User)req.getSession().getAttribute("user");
        String uid = oldUser.getUid();
        // 从表单中获取可变更信息
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        int age = Integer.parseInt(req.getParameter("age"));
        String tel = req.getParameter("tel");
        User user = new User(uid, username, gender, age, tel, 0);
        //实例化UserService对象
        UserService userService = new UserServiceImpl();
        if (userService.updateStudentInfo(user)) {
            // 更新成功
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("./studentInfo.jsp");
        } else {
            resp.sendRedirect("./error.jsp");
        }

    }
}
