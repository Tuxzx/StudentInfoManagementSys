package com.tuxzx.sci.dal;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

import java.util.List;

public interface UserDao {
    // 普通用户权限
    User findUser(String uid, String password);

    boolean isUserExist(String uid);

    boolean addUser(User user);

    boolean updateUserinfo(User user);

    // 超级用户权限
    User getUser(String uid);

    List<User> getAllUser();

    boolean removeUser(String uid);

}
