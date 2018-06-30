package com.tuxzx.sci.dal;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

public interface UserDao {
    User findUser(String uid, String password);

    boolean isUserExist(String uid);

    boolean registeredUser(String uid, String username, String password, String gender, int age, @Nullable String tel, int role);

    boolean updateUserinfo(User user);
}
