package org.Jdbc;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author:WangQian
 * Date: 18-6-24 下午9:19
 */
public class DataDase {
    private Connection conn;
    private String sqlurl = "jdbc:mysql://localhost:3306/manager?useUnicode=true&characterEncoding=utf-8";

    public DataDase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(sqlurl, "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    conn = (Connection) DriverManager.getConnection(sqlurl, "root", "123456");
                } catch (SQLException e) {
                    System.out.println("获取连接失败");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class Not Found");
            }
        }
        return conn;
    }

    public boolean insert(String sql) {
        System.out.println(conn + "===========");
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            int num = pst.executeUpdate();
            if (num != 0) {
                return true;
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public ResultSet select(String selectsql) {
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            pst = (PreparedStatement) conn.prepareStatement(selectsql);
            res = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
