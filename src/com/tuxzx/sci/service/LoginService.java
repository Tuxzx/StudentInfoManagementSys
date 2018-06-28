package com.tuxzx.sci.service;

import com.tuxzx.sci.bean.User;

public interface LoginService {
    User findUser(String uid, String password);
}
