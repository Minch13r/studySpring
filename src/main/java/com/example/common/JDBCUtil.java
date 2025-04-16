package com.example.common;

import java.sql.*;

public class JDBCUtil {
    static final String driverName = "oracle.jdbc.driver.OracleDriver";
    static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String userName = "MIN";
    static final String password = "12345678";

    public static Connection connect(){
        Connection conn = null;
        try {
            // 1. 드라이버 연결(메모리에 데이터 적재)
            Class.forName(driverName);
            // 2. conn 연결
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void disconnect(Connection conn, PreparedStatement pstmt){
        // 4. DB 연결 해제
        try {
            // null 체크 추가
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ResultSet까지 함께 닫는 메소드 추가
    public static void disconnect(Connection conn, PreparedStatement pstmt, ResultSet rs){
        // 4. DB 연결 해제
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
