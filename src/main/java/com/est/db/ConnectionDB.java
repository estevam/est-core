package com.est.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	public static Connection getConnection() throws ConnectionDbException {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(
					"jdbc:sqlite:/Users/estevam/NetBeansProjects/est-framework/src/java/com/est/db/user_mhgbox.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws ConnectionDbException {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws ConnectionDbException {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws ConnectionDbException {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) throws ConnectionDbException {
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