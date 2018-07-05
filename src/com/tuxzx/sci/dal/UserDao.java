package com.tuxzx.sci.dal;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;

import java.util.List;

public interface UserDao {
    // 普通用户权限
    User findUser(String uid, String password);
    // 判断用户是否存在
    boolean isUserExist(String uid);
    // 添加用户
    boolean addUser(User user);
    // 更新用户信息
    boolean updateUserinfo(User user);
    // 超级用户权限
    User getUser(String uid);
    // 获取所有用户
    List<User> getAllUser();
    // 更新用户信息（管理员）
    boolean updateUserinfoSuper(User user);
    // 删除用户
    boolean removeUser(String uid);
}
