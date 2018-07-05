package com.tuxzx.sci.service;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

public interface LoginService {
    // 登陆 查找用户
    User findUser(String uid, String password);
    // 注册用户
    boolean registeredUser(User user);
}
