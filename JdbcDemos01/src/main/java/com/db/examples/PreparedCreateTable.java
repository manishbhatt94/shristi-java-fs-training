package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedCreateTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";
		String sql = """
				create table book(
					book_id int primary key,
					title varchar(255),
					author varchar(255),
					price float
				);
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql)) {
			boolean status = statement.execute();
			System.out.println("Prepared Statement .execute result - " + status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
