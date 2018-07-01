package com.tuxzx.sci.dal;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    protected Connection connection = null;
    protected PreparedStatement statement = null;
    protected ResultSet resultSet = null;

    protected void debugMethod() {
        if (TableContact.DEBUG){
            System.out.println(statement);
        }
    }

    protected void cusClose() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cusClose executed");
    }

}
