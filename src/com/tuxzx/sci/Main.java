package com.tuxzx.sci;

import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.findUser("2016031701","tom123");
    }
}
