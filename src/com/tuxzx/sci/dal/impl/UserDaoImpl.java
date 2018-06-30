package com.tuxzx.sci.dal.impl;

import com.sun.istack.internal.Nullable;
import com.tuxzx.sci.bean.User;
import com.tuxzx.sci.dal.BaseDao;
import com.tuxzx.sci.dal.TableContact;
import com.tuxzx.sci.dal.UserDao;
import com.tuxzx.sci.util.JDBCUtils;

import javax.persistence.Table;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findUser(String uid, String password) {
        User user = new User();
        String sql = "SELECT * FROM "+TableContact.TABLE_USER+" WHERE "+TableContact.USER_ID+" = ? and "+TableContact.USER_PASSWORD
                +" = ?";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            statement.setString(2, password);
            if (TableContact.DEBUG) {
                System.out.println(statement);
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUid(resultSet.getString(TableContact.USER_ID
                ));
                user.setUsername(resultSet.getString(TableContact.USER_NAME));
                user.setPassword(resultSet.getString(TableContact.USER_PASSWORD));
                user.setGender(resultSet.getString(TableContact.USER_GENDER));
                user.setAge(resultSet.getInt(TableContact.USER_AGE));
                user.setTel(resultSet.getString(TableContact.USER_TEL));
                user.setRole(resultSet.getInt(TableContact.USER_ROLE));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            cusClose();
        }
        return null;
    }

    @Override
    public boolean isUserExist(String uid) {
        String sql = "SELECT * FROM "+TableContact.TABLE_USER+" WHERE "+TableContact.USER_ID+" = ? ";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return false;
    }

    @Override
    public boolean registeredUser(String uid, String username, String password, String gender, int age, @Nullable String tel, int role) {
        if (isUserExist(uid)) {
            return false;
        } else {
            String sql = "INSERT INTO "+TableContact.TABLE_USER +" VALUES ( ?, ?, ?, ?, ?, ?, ? )";
            connection = JDBCUtils.getConnection();
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, uid);
                statement.setString(2, username);
                statement.setString(3, password);
                statement.setString(4, gender);
                statement.setInt(5, age);
                statement.setString(6, tel);
                statement.setInt(7, role);
                int status = statement.executeUpdate();
                if (status>0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                cusClose();
            }
            return false;
        }
    }

    @Override
    public boolean updateUserinfo(User user) {
        String sql = "UPDATE "+TableContact.TABLE_USER+" SET "+TableContact.USER_NAME+" = ? ," +
                TableContact.USER_GENDER+" = ?," +
                TableContact.USER_AGE+" = ? ," +
                TableContact.USER_TEL+" = ? " +
                "WHERE "+TableContact.USER_ID+" = ?";
        connection = JDBCUtils.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getGender());
            statement.setInt(3, user.getAge());
            statement.setString(4,user.getTel());
            statement.setString(5, user.getUid());

            int status = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(status);
            if (status >0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cusClose();
        }
        return false;
    }
}
