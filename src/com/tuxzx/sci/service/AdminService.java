package com.tuxzx.sci.service;

import com.tuxzx.sci.bean.User;

import java.util.List;

public interface AdminService {
    String getAllUserInfo();

    boolean addUser(User user);

    boolean removeUser(User user);

    boolean updateUser(User user);

    boolean isUserExist(String uid);
}
