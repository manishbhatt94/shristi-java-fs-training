package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";

		String sql = """
				insert into employee(emp_id, emp_name, city)
				values(1, 'Raju', 'Pune');
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {
			int updatedCount = statement.executeUpdate(sql);
			System.out.println("updatedCount - " + updatedCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
