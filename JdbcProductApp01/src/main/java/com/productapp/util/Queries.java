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
	public static final String PRODUCT_INSERT = """
			INSERT INTO product (product_name, brand, category, price)
			VALUES (?, ?, ?, ?);
			""";
	public static final String PRODUCT_SELECT = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			ORDER BY product_name ASC;"
			""";
	public static final String PRODUCT_SELECT_BY_BRAND = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			WHERE brand = ?
			ORDER BY product_name ASC;"
			""";
	public static final String PRODUCT_SELECT_BY_CATEGORY = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			WHERE category = ?
			ORDER BY product_name ASC;"
			""";
	public static final String PRODUCT_SELECT_BY_CATEGORY_BRAND = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			WHERE category = ? AND brand = ?
			ORDER BY product_name ASC;"
			""";
	public static final String PRODUCT_SELECT_BY_CATEGORY_MAXPRICE = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			WHERE category = ? AND price <= ?
			ORDER BY product_name ASC;"
			""";
	public static final String PRODUCT_SELECT_BY_ID = """
			SELECT
			product_id, product_name, brand, category, price
			FROM product
			WHERE product_id = ?;"
			""";
	public static final String PRODUCT_UPDATE_BY_ID = """
			UPDATE product SET
			product_name = ?,
			brand = ?,
			category = ?,
			price = ?
			WHERE product_id = ?;
			""";
	public static final String PRODUCT_DELETE_BY_ID = """
			DELETE FROM product
			WHERE product_id = ?;
			""";
	public static final String PRODUCT_TRUNCATE = """
			TRUNCATE TABLE product;
			""";

}
