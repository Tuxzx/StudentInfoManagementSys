package com.tuxzx.sci.service.impl;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.dal.impl.UserDaoImpl;
import com.tuxzx.sci.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public User findUser(String uid, String password) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(uid, password);
        return user;
    }

    @Override
    public boolean registeredUser(String uid, String username, String password, String gender, int age, @Nullable String tel, int role) {
        UserDao userDao = new UserDaoImpl();
        boolean status = userDao.registeredUser(uid, username, password, gender, age, tel, role);
        if (status) {
            return true;
        } else {
            return false;
        }
    }
}
