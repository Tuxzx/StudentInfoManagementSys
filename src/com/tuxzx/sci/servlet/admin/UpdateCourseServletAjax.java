package com.tuxzx.sci.servlet.admin;

import com.tuxzx.sci.bean.Course;
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

public class UpdateCourseServletAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        int cscore = Integer.parseInt(req.getParameter("cscore"));
        int theorylesson = Integer.parseInt(req.getParameter("theorylesson"));
        int practicelesson = Integer.parseInt(req.getParameter("practicelesson"));
        String testmethod = req.getParameter("testmethod");
        String testdate = req.getParameter("testdate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(testdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Course course = new Course(cid, cname, cscore, theorylesson, practicelesson, testmethod, new java.sql.Date(date.getTime()));
        System.out.println(course);
        AdminService adminService = new AdminServiceImpl();
        System.out.println("start");
        if (adminService.updateCourse(course)) {
            resp.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            System.out.println("update:ture");
            PrintWriter writer = resp.getWriter();
            writer.write(adminService.getAllCourseInfo());
            System.out.println(adminService.getAllCourseInfo());
        }
    }
}
