package com.tuxzx.sci.dal;

import com.tuxzx.sci.bean.User;

public interface UserDao {
    User findUser(String uid, String password);

    boolean updateUserinfo(User user);
}
