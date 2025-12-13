package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedUpdate {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";
		String sql = """
				update product set price = ? where product_id = ?;
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setDouble(1, 6000);
			statement.setDouble(2, 3);
			int updatedCount = statement.executeUpdate();
			System.out.println("Prepared Statement .executeUpdate result - " + updatedCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
