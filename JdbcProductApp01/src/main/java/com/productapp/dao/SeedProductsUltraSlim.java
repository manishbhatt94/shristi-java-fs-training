package com.productapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productapp.exceptions.DataAccessException;
import com.productapp.model.Product;
import com.productapp.util.DBConnection;
import com.productapp.util.Queries;
import com.productapp.util.TableSeeder;

public class SeedProductsUltraSlim {

	private static final int SEED_DATA_COUNT = 20;

	public static void seed() throws DataAccessException {
		try {
			System.out.println("Seeding 'product' table - Starting");

			Connection connection = DBConnection.getConnection();
			TableSeeder<Product> seeder = new TableSeeder<>(connection);

			List<Product> products = generateProducts();

			seeder.seed(Queries.PRODUCT_CREATE_TABLE, Queries.PRODUCT_TRUNCATE, Queries.PRODUCT_COUNT,
					Queries.PRODUCT_INSERT, SEED_DATA_COUNT, products,
					p -> new Object[] { p.getProductName(), p.getBrand(), p.getCategory(), p.getPrice() });

			System.out.println("Seeding 'product' table - Finished");

		} catch (SQLException e) {
			final String message = "Seed Error - Failed to create 'product' table / Seed data in it.";
			throw new DataAccessException(message, e);
		}
	}

	private static List<Product> generateProducts() {
		List<Product> products = new ArrayList<>();

		// Define common categories for variations
		String[] categories = { "Electronics", "Books", "Home & Kitchen", "Clothing", "Sports" };

		// Brands
		List<List<String>> brands = List.of(List.of("Samsung", "Apple"),
				List.of("Tata Mc-Graw Hill", "Penguin", "Orielly"), List.of("Borosil", "IFB", "Hawkins"),
				List.of("Levi's", "Raymond's"), List.of("Adidas", "Nike"));

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
		products.add(new Product(names[0], brands.get(0).get(0), categories[0], prices[0])); // Laptop
		products.add(new Product(names[5], brands.get(0).get(1), categories[0], prices[5])); // Wireless Mouse
		products.add(new Product(names[10], brands.get(0).get(1), categories[0], prices[10])); // Smart Watch
		products.add(new Product(names[15], brands.get(0).get(0), categories[0], prices[15])); // Gaming Headset

		// 2. Books (Multiple items)
		products.add(new Product(names[1], brands.get(1).get(2), categories[1], prices[1])); // Ebook Reader
		products.add(new Product(names[6], brands.get(1).get(0), categories[1], prices[6])); // Java Book
		products.add(new Product(names[11], brands.get(1).get(1), categories[1], prices[11])); // Fiction Novel
		products.add(new Product(names[16], brands.get(1).get(1), categories[1], prices[16])); // Cookbook

		// 3. Home & Kitchen (Multiple items)
		products.add(new Product(names[2], brands.get(2).get(2), categories[2], prices[2])); // Coffee Maker
		products.add(new Product(names[7], brands.get(2).get(0), categories[2], prices[7])); // Blender
		products.add(new Product(names[12], brands.get(2).get(1), categories[2], prices[12])); // Air Fryer
		products.add(new Product(names[17], brands.get(2).get(2), categories[2], prices[17])); // Vacuum Cleaner

		// 4. Clothing (Multiple items)
		products.add(new Product(names[3], brands.get(3).get(0), categories[3], prices[3])); // T-Shirt
		products.add(new Product(names[8], brands.get(3).get(0), categories[3], prices[8])); // Denim Jeans
		products.add(new Product(names[13], brands.get(3).get(0), categories[3], prices[13])); // Winter Jacket
		products.add(new Product(names[18], brands.get(3).get(1), categories[3], prices[18])); // Formal Shirt

		// 5. Sports (Multiple items)
		products.add(new Product(names[4], brands.get(4).get(0), categories[4], prices[4])); // Running Shoes
		products.add(new Product(names[9], brands.get(4).get(1), categories[4], prices[9])); // Yoga Mat
		products.add(new Product(names[14], brands.get(4).get(0), categories[4], prices[14])); // Dumbbell Set
		products.add(new Product(names[19], brands.get(4).get(1), categories[4], prices[19])); // Bike Helmet

		return products;
	}

}
