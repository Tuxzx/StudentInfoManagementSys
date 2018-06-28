package com.tuxzx.sci.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        DRIVER = ResourceBundle.getBundle("config_database").getString("driver");
        URL = ResourceBundle.getBundle("config_database").getString("url");
        USERNAME = ResourceBundle.getBundle("config_database").getString("username");
        PASSWORD = ResourceBundle.getBundle("config_database").getString("password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc驱动加载失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象 connection
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * close connection
     * @param connection
     */
    public static void connectionClose (Connection connection) {
        if (connection == null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("connection关闭失败");
                e.printStackTrace();
            }
        }
    }

    /**
     * close statement
     * @param statement
     */
    public static void statementClose (Statement statement) {
        if (statement == null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("statement关闭失败");
                e.printStackTrace();
            }
        }
    }

    /**
     * close resultSet
     * @param resultSet
     */
    public static void resultSetClose (ResultSet resultSet) {
        if (resultSet == null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("resultSet关闭失败");
                e.printStackTrace();
            }
        }
    }

}
