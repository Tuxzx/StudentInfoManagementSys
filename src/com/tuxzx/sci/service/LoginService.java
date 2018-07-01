package com.tuxzx.sci.service;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

public interface LoginService {
    User findUser(String uid, String password);

    boolean registeredUser(User user);
}
