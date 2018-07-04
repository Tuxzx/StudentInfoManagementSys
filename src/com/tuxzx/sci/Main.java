package com.tuxzx.sci;

import com.tuxzx.sci.bean.Elective;
import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.CourseDao;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.CourseDaoImpl;
import com.tuxzx.sci.dal.impl.UserDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDaoImpl();
        List<Elective> electiveList = courseDao.getAllElective();
        for (int i=0;i<electiveList.size();i++) {
            System.out.println(electiveList.get(i).getResult());
        }
    }


}