package com.productapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeedProducts {

	private static final String DB_CONNECTION_STR = "jdbc:mysql://localhost:3306/jfsseptjava";
	private static final String DB_USER_NAME = "root";
	private static final String DB_USER_PWD = "manish";

	public static List<Product> generateProducts() {
		List<Product> products = new ArrayList<>();

		// Define common categories for variations
		String[] categories = { "Electronics", "Books", "Home & Kitchen", "Clothing", "Sports" };

		// Product data arrays for variation
		String[] names = { "Laptop Pro X", "Ebook Reader 2", "Coffee Maker 500", "Summer T-Shirt", "Running Shoes V1",
				"Wireless Mouse", "Java Programming Guide", "Blender Elite", "Denim Jeans", "Yoga Mat", "Smart Watch Z",
				"Fiction Novel", "Air Fryer Mini", "Winter Jacket", "Dumbbell Set", "Gaming Headset",
				"Cookbook: Italian", "Vacuum Cleaner", "Formal Shirt", "Bike Helmet" };

		// Prices with variations
		double[] prices = { 1200.50, 99.99, 55.00, 25.99, 85.50, 15.00, 45.75, 120.00, 65.00, 30.00, 250.00, 15.50,
				75.00, 150.00, 40.00, 95.00, 22.00, 180.00, 35.00, 49.99 };

		// --- Creating the 20 Products with varying categories and prices ---

		// 1. Electronics (Multiple items)
		products.add(new Product(names[0], categories[0], prices[0])); // Laptop
		products.add(new Product(names[5], categories[0], prices[5])); // Wireless Mouse
		products.add(new Product(names[10], categories[0], prices[10])); // Smart Watch
		products.add(new Product(names[15], categories[0], prices[15])); // Gaming Headset

		// 2. Books (Multiple items)
		products.add(new Product(names[1], categories[1], prices[1])); // Ebook Reader
		products.add(new Product(names[6], categories[1], prices[6])); // Java Book
		products.add(new Product(names[11], categories[1], prices[11])); // Fiction Novel
		products.add(new Product(names[16], categories[1], prices[16])); // Cookbook

		// 3. Home & Kitchen (Multiple items)
		products.add(new Product(names[2], categories[2], prices[2])); // Coffee Maker
		products.add(new Product(names[7], categories[2], prices[7])); // Blender
		products.add(new Product(names[12], categories[2], prices[12])); // Air Fryer
		products.add(new Product(names[17], categories[2], prices[17])); // Vacuum Cleaner

		// 4. Clothing (Multiple items)
		products.add(new Product(names[3], categories[3], prices[3])); // T-Shirt
		products.add(new Product(names[8], categories[3], prices[8])); // Denim Jeans
		products.add(new Product(names[13], categories[3], prices[13])); // Winter Jacket
		products.add(new Product(names[18], categories[3], prices[18])); // Formal Shirt

		// 5. Sports (Multiple items)
		products.add(new Product(names[4], categories[4], prices[4])); // Running Shoes
		products.add(new Product(names[9], categories[4], prices[9])); // Yoga Mat
		products.add(new Product(names[14], categories[4], prices[14])); // Dumbbell Set
		products.add(new Product(names[19], categories[4], prices[19])); // Bike Helmet

		return products;
	}

	public static void createProductTable() throws SQLException {
		final String CREATE_TABLE_SQL = """
				CREATE TABLE IF NOT EXISTS product (
				    product_id INT PRIMARY KEY AUTO_INCREMENT,
				    product_name VARCHAR(100) NOT NULL,
				    category VARCHAR(50) NOT NULL,
				    price DECIMAL(10, 2) NOT NULL
				);
				""";

		try (Connection connection = DriverManager.getConnection(DB_CONNECTION_STR, DB_USER_NAME, DB_USER_PWD);
				PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_SQL);) {

			boolean status = statement.execute(CREATE_TABLE_SQL);
			System.out.println("statement.execute return - " + status);
		}
	}

	public static void insertSeedProducts() throws SQLException {
		List<Product> products = generateProducts();

		final String INSERT_SQL = "INSERT INTO product (product_name, category, price) VALUES (?, ?, ?)";

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_CONNECTION_STR, DB_USER_NAME, DB_USER_PWD);
			connection.setAutoCommit(false);

			try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
				int count = 0;

				System.out.println("Starting batch insertion of " + products.size() + " products...");

				for (Product product : products) {
					ps.setString(1, product.getProductName());
					ps.setString(2, product.getCategory());
					ps.setDouble(3, product.getPrice());
					ps.addBatch();

					count++;
					if (count % 50 == 0) {
						ps.executeBatch();
						System.out.println("Executed intermediate batch of 50 records.");
					}
				}

				int[] results = ps.executeBatch();
				connection.commit();

				System.out.println("\nBatch insertion successful!");
				System.out.println("Total rows inserted: " + results.length);
			}
		} catch (SQLException e) {
			if (connection != null) {
				connection.rollback();
			}
			throw e;
		}
	}
}
