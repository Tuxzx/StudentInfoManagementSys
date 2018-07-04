package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.Course;
import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.service.AdminService;
import com.tuxzx.sci.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateElectiveServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        int result = Integer.parseInt(req.getParameter("result"));
        Elective elective = new Elective(uid, cid, result);
        System.out.println(elective);
        AdminService adminService = new AdminServiceImpl();
        System.out.println("start");
        if (adminService.updateElective(elective)) {
            resp.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            System.out.println("update:ture");
            PrintWriter writer = resp.getWriter();
            writer.write(adminService.getAllElective());
            System.out.println(adminService.getAllElective());
        }
    }
}
