package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";
		String sql = """
				create table employee(
					emp_id int primary key,
					emp_name varchar(255),
					city varchar(255)
				);
				""";

		Connection connection = null;
		Statement statement = null;
		try {
			// Get a connection
			connection = DriverManager.getConnection(url, username, password);
			// Get a Statement object
			statement = connection.createStatement();
			// Execute the query
			boolean status = statement.execute(sql);
			System.out.println("statement.execute return - " + status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
