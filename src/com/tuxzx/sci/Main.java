package com.tuxzx.sci;

import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUserinfo(new User(null,"lily","男",26,"1234567890",0));
    }
}
