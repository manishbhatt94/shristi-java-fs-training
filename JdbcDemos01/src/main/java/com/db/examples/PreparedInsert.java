package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedInsert {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";
		String sql = """
				INSERT INTO book(book_id, title, author, price) values (?, ?, ?, ?);
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, 100);
			statement.setString(2, "Java 8 in Action");
			statement.setString(3, "Raoul-Gabriel Urma");
			statement.setDouble(4, 736.0);
			statement.execute();
			System.out.println("Insertion done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
