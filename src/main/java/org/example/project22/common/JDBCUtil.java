package org.example.project22.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("org.mariadb.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mariadb://walab.handong.edu:3306/W25_22301023", "W25_22301023", "Aetu1h");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

//    public static void main(String[] args) {
//        Connection conn = JDBCUtil.getConnection();
//        if(conn != null) {
//            System.out.println("db연결 성공");
//        } else {
//            System.out.println("연결실패");
//        }
//    }
}
