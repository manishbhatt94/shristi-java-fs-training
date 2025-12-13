package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableProduct {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		final String username = "root";
		final String password = "manish";
		final String sql = """
				CREATE TABLE IF NOT EXISTS product (
				    product_id INT PRIMARY KEY AUTO_INCREMENT,
				    product_name VARCHAR(100) NOT NULL,
				    category VARCHAR(50) NOT NULL,
				    price DECIMAL(10, 2) NOT NULL
				);
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {

			boolean status = statement.execute(sql);
			System.out.println("statement.execute return - " + status);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
