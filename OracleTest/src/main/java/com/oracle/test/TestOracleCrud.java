package com.oracle.test;

import java.sql.*;

/**
 * Created by AdministratorZhang on 2018/4/11.
 */
public class TestOracleCrud {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:test","scott","root");
            pStmt = conn.prepareStatement("SELECT * FROM emp");
            rs = pStmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(pStmt != null){
                try {
                    pStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pStmt = null;
            }
            if(conn == null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }

        }
    }
}
