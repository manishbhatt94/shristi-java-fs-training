package com.productapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_CONNECTION_STR = "jdbc:mysql://localhost:3306/jfsseptjava";
	private static final String DB_USER_NAME = "root";
	private static final String DB_USER_PWD = "manish";

	private static Connection connection = null;

	static {
		try {
			connection = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Fatal Error: DB Connection could not be established.");
			// Wrap and rethrow as a RuntimeException (or ExceptionInInitializerError)
			throw new RuntimeException("DB Connection could not be established", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			System.out.println("Attempting to open DB connection.");
			connection = DriverManager.getConnection(DB_CONNECTION_STR, DB_USER_NAME, DB_USER_PWD);
			System.out.println("Opened DB connection.");
		}
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			System.out.println("Attempting to close DB connection.");
			connection.close();
			System.out.println("Closed DB connection.");
		}
	}

}
