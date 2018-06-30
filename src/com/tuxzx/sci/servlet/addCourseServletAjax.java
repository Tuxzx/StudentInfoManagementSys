package com.tuxzx.sci.servlet;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.service.UserService;
import com.tuxzx.sci.service.impl.UserServiceImpl;
import org.jcp.xml.dsig.internal.dom.DOMXPathFilter2Transform;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class addCourseServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        User user = (User) req.getSession().getAttribute("user");
        String uid = user.getUid();
        String cid = req.getParameter("cid");
        System.out.println("cid:"+cid);
        UserService userService = new UserServiceImpl();
        System.out.println("ajax后台响应");
        PrintWriter out = resp.getWriter();
        if (userService.selectCourse(uid, cid)) {
            out.write(userService.getAllSelectedCourse(uid));
        } else {
            out.write("false");
        }
    }
}
