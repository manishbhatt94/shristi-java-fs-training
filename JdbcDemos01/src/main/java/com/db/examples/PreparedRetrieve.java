package com.db.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedRetrieve {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/jfsseptjava";
		String username = "root";
		String password = "manish";
		String sql = """
				select * from product;
				""";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();) {

			while (rs.next()) {
				String productName = rs.getString("product_name");
				int productId = rs.getInt(2);
				double price = rs.getDouble("price");
				String category = rs.getString("category");
				System.out.println(productName + " " + productId + " " + price + " " + category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
