package com.tuxzx.sci.service;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

public interface LoginService {
    User findUser(String uid, String password);

    boolean registeredUser(String uid, String username, String password, String gender, int age, @Nullable String tel, int role);
}
