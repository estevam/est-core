package com.est.db.store_procedure;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class ConnectionDB {

    private static String iDriver = "org.gjt.mm.mysql.Driver";
    private static String iUrl = "jdbc:mysql://localhost/test";
    private static String iUsername = "root";
    private static String iPassword = "root";
    private Connection iConnection = null;

    public Connection getMySqlConnection() {

        try {
            Class.forName(iDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, ex.toString());
        }
        if (iConnection == null) {
            try {
                iConnection = (Connection) DriverManager.getConnection(iUrl, iUsername, iPassword);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, ex.toString());
            }
        }
        return iConnection;
    }

    public static void closeConnection(java.sql.Connection conn, Statement stmt, ResultSet rs)
            throws com.est.db.store_procedure.ConnectionDbException {
        close(conn, stmt, rs);
    }

    public static void closeConnection(java.sql.Connection conn, Statement stmt)
            throws com.est.db.store_procedure.ConnectionDbException {
        close(conn, stmt, null);
    }

    public static void closeConnection(java.sql.Connection conn)
            throws com.est.db.store_procedure.ConnectionDbException {
        close(conn, null, null);
    }

    private static void close(java.sql.Connection conn, Statement stmt, ResultSet rs)
            throws com.est.db.store_procedure.ConnectionDbException {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            throw new com.est.db.store_procedure.ConnectionDbException(e.getMessage());
        }
    }
}
