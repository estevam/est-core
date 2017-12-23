
package com.est.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author estevam
 */
public class MultipleConnections {

    private Connection iConnTEST01 = null;
    private Connection iConnTEST02 = null;
    private Connection iConnTEST03 = null;

    public MultipleConnections() {
    }

    public void loadonnections() {


        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/test1";
            String user = "root";
            String password = "secret";

            iConnTEST01 = DriverManager.getConnection(url1, user, password);
            if (iConnTEST01 != null) {
                System.out.println("Connected to the database test1");
            }

            // connect way #2
            String url2 = "jdbc:mysql://localhost:3306/test2?user=root&password=secret";
            iConnTEST02 = DriverManager.getConnection(url2);
            if (iConnTEST02 != null) {
                System.out.println("Connected to the database test2");
            }

            // connect way #3
            String url3 = "jdbc:mysql://localhost:3306/test3";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "secret");

            iConnTEST03 = DriverManager.getConnection(url3, info);
            if (iConnTEST03 != null) {
                System.out.println("Connected to the database test3");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn, Statement stmt,
            ResultSet rs) throws ConnectionDbException {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws ConnectionDbException {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws ConnectionDbException {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs)
            throws ConnectionDbException {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new ConnectionDbException(e.getMessage());
        }
    }
}
