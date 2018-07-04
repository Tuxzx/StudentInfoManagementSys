package com.tuxzx.sci.servlet.user;

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
        User oldUser = (User)req.getSession().getAttribute("user");         // 从Session中获取现有user对象
        String uid = oldUser.getUid();                                         // 获取现有user的uid
        // 从表单中获取可变更信息
        String username = req.getParameter("username");                     // 获取表单中的用户名
        String gender = req.getParameter("gender");                         // 获取表单中的性别
        int age = Integer.parseInt(req.getParameter("age"));                // 获取表单中的年龄
        String tel = req.getParameter("tel");                               // 获取表单中的电话
        User user = new User(uid, username, gender, age, tel, 0);         // 根据获得的新信息实例化新的user对象
        //实例化UserService对象
        UserService userService = new UserServiceImpl();                       // 实例化Service层User实现类
        if (userService.updateStudentInfo(user)) {                             // 传入user根据返回值判断是否更新成功
            // 更新成功
            req.getSession().setAttribute("user", user);                    // 更换Session域中的user对象
            resp.sendRedirect("./studentInfo.jsp");                         // 刷新页面更新信息
        } else {
            // 更新失败
            req.setAttribute("error","更新失败<br>请尝试重新更新您的信息");    // request域中存放错误信息
            req.getRequestDispatcher("error.jsp").forward(req,resp);              // 推送
            resp.sendRedirect("./error.jsp");                                     // 重定向
        }

    }
}
