package com.wxxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil {

    static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

    static {
        String driver = bundle.getString("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取链接
    public static Connection getConn(){
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    //关闭连接
    public static void closeConn(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
