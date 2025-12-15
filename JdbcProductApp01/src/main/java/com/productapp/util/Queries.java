package com.productapp.util;

public class Queries {

	public static final String PRODUCT_CREATE_TABLE = """
				CREATE TABLE IF NOT EXISTS product (
			    product_id INT PRIMARY KEY AUTO_INCREMENT,
			    product_name VARCHAR(100) NOT NULL,
			    brand VARCHAR(50) NOT NULL,
			    category VARCHAR(50) NOT NULL,
			    price DECIMAL(10, 2) NOT NULL
			);
			""";
	public static final String PRODUCT_COUNT = "SELECT COUNT(*) FROM product;";
	public static final String PRODUCT_INSERT = "INSERT INTO product (product_name, brand, category, price) VALUES (?, ?, ?, ?);";
	public static final String PRODUCT_SELECT = "SELECT product_id, product_name, brand, category, price FROM product;";

}
