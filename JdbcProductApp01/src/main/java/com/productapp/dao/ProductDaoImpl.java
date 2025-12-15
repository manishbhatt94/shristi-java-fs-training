package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.productapp.exceptions.DataAccessException;
import com.productapp.model.Product;
import com.productapp.util.DBConnection;
import com.productapp.util.Queries;

public class ProductDaoImpl implements IProductDao {

	static {
		try {
			SeedProducts.seed();
		} catch (SQLException e) {
			e.printStackTrace();
			final String message = "Seed Error - Failed to create 'product' table / Seed data in it.";
			System.err.println(message);
			// Wrap and rethrow as a RuntimeException (or ExceptionInInitializerError)
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public Product createProduct(Product product) {
		int createdProductId = -1;
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_INSERT,
					Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, product.getProductName());
				statement.setString(2, product.getBrand());
				statement.setString(3, product.getCategory());
				statement.setDouble(4, product.getPrice());
				int affectedRows = statement.executeUpdate();
				if (affectedRows == 0) {
					throw new DataAccessException("Creating product failed, no rows affected.");
				}
				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						createdProductId = generatedKeys.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			throw new DataAccessException("Database error while creating product: " + product, e);
		}
		if (createdProductId == -1) {
			throw new DataAccessException("Creating product failed, no ID obtained.");
		}
		return findById(createdProductId);
	}

	@Override
	public boolean updateProductById(Product updatedProduct) {
		int productId = updatedProduct.getProductId();
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_UPDATE_BY_ID)) {
				statement.setString(1, updatedProduct.getProductName());
				statement.setString(2, updatedProduct.getBrand());
				statement.setString(3, updatedProduct.getCategory());
				statement.setDouble(4, updatedProduct.getPrice());
				statement.setInt(5, productId);
				int affectedRows = statement.executeUpdate();
				return affectedRows > 0; // true if updated, false if no match
			}
		} catch (SQLException e) {
			throw new DataAccessException("Database error while updating product with ID: " + productId, e);
		}

	}

	@Override
	public boolean deleteProductById(int productId) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_DELETE_BY_ID)) {
				statement.setInt(1, productId);
				int affectedRows = statement.executeUpdate();
				return affectedRows > 0; // true if deleted, false if no match
			}
		} catch (SQLException e) {
			throw new DataAccessException("Database error while deleting product with ID: " + productId, e);
		}
	}

	@Override
	public List<Product> findAll() {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT);
					ResultSet rs = statement.executeQuery()) {
				return productListFromResultSet(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Database error while fetching all products", e);
		}
	}

	@Override
	public List<Product> findByBrand(String brand) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT_BY_BRAND)) {
				statement.setString(1, brand);
				try (ResultSet rs = statement.executeQuery()) {
					return productListFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			String message = "Database error while finding products by brand: " + brand;
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public List<Product> findByCategory(String category) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT_BY_CATEGORY)) {
				statement.setString(1, category);
				try (ResultSet rs = statement.executeQuery()) {
					return productListFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			String message = "Database error while finding products by category: " + category;
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT_BY_CATEGORY_BRAND)) {
				statement.setString(1, category);
				statement.setString(2, brand);
				try (ResultSet rs = statement.executeQuery()) {
					return productListFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			String message = "Database error while finding products by category: " + category + ", and brand: " + brand;
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public List<Product> findByCategoryAndMaxPrice(String category, double maxPrice) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection
					.prepareStatement(Queries.PRODUCT_SELECT_BY_CATEGORY_MAXPRICE)) {
				statement.setString(1, category);
				statement.setDouble(2, maxPrice);
				try (ResultSet rs = statement.executeQuery()) {
					return productListFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			String message = "Database error while finding products by category: " + category + ", and maxPrice: "
					+ maxPrice;
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public Product findById(int productId) {
		try {
			Connection connection = DBConnection.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT_BY_ID)) {
				statement.setInt(1, productId);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						return productRecordToModel(rs);
					}
					return null; // product not found
				}
			}
		} catch (SQLException e) {
			throw new DataAccessException("Database error while finding product by ID: " + productId, e);
		}
	}

	private List<Product> productListFromResultSet(ResultSet rs) throws SQLException {
		List<Product> products = new ArrayList<>();

		while (rs.next()) {
			Product product = productRecordToModel(rs);
			products.add(product);
		}

		return products;
	}

	private Product productRecordToModel(ResultSet rs) throws SQLException {
		// product_id, product_name, brand, category, price
		int productId = rs.getInt("product_id");
		String productName = rs.getString("product_name");
		String brand = rs.getString("brand");
		String category = rs.getString("category");
		double price = rs.getDouble("price");
		Product product = new Product(productId, productName, brand, category, price);
		return product;
	}

}
