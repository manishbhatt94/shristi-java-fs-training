package com.productapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.productapp.exceptions.DataAccessException;
import com.productapp.model.Product;
import com.productapp.util.DBConnection;
import com.productapp.util.JdbcExecutor;
import com.productapp.util.Queries;

public class ProductDaoSlimImpl implements IProductDao {

	// Common mapper for Product
	private final JdbcExecutor.ResultSetMapper<Product> productMapper = rs -> {
		return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getString("brand"),
				rs.getString("category"), rs.getDouble("price"));
	};

	@Override
	public Product createProduct(Product product) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);

			int createdProductId = executor.updateAndReturnKey(Queries.PRODUCT_INSERT, product.getProductName(),
					product.getBrand(), product.getCategory(), product.getPrice());

			return findById(createdProductId);
		} catch (SQLException e) {
			throw new DataAccessException("Database error while creating product: " + product, e);
		}
	}

	@Override
	public boolean updateProductById(Product updatedProduct) {
		int productId = updatedProduct.getProductId();
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);

			int affectedRows = executor.update(Queries.PRODUCT_UPDATE_BY_ID, updatedProduct.getProductName(),
					updatedProduct.getBrand(), updatedProduct.getCategory(), updatedProduct.getPrice(), productId);
			return affectedRows > 0;
		} catch (SQLException e) {
			throw new DataAccessException("Database error while updating product with ID: " + productId, e);
		}
	}

	@Override
	public boolean deleteProductById(int productId) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);

			int affectedRows = executor.update(Queries.PRODUCT_DELETE_BY_ID, productId);
			return affectedRows > 0;
		} catch (SQLException e) {
			throw new DataAccessException("Database error while deleting product with ID: " + productId, e);
		}
	}

	@Override
	public List<Product> findAll() {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);
			return executor.queryAll(Queries.PRODUCT_SELECT, productMapper);
		} catch (SQLException e) {
			throw new DataAccessException("Database error while fetching all products", e);
		}
	}

	@Override
	public List<Product> findByBrand(String brand) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);
			return executor.queryAll(Queries.PRODUCT_SELECT_BY_BRAND, productMapper, brand);
		} catch (SQLException e) {
			throw new DataAccessException("Database error while finding products by brand: " + brand, e);
		}
	}

	@Override
	public List<Product> findByCategory(String category) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);
			return executor.queryAll(Queries.PRODUCT_SELECT_BY_CATEGORY, productMapper, category);
		} catch (SQLException e) {
			throw new DataAccessException("Database error while finding products by category: " + category, e);
		}
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);
			return executor.queryAll(Queries.PRODUCT_SELECT_BY_CATEGORY_BRAND, productMapper, category, brand);
		} catch (SQLException e) {
			String message = "Database error while finding products by category: " + category + ", and brand: " + brand;
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public List<Product> findByCategoryAndMaxPrice(String category, double maxPrice) {
		try {
			Connection connection = DBConnection.getConnection();
			JdbcExecutor executor = new JdbcExecutor(connection);
			return executor.queryAll(Queries.PRODUCT_SELECT_BY_CATEGORY_MAXPRICE, productMapper, category, maxPrice);
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
			JdbcExecutor executor = new JdbcExecutor(connection);

			Optional<Product> productOpt = executor.queryOne(Queries.PRODUCT_SELECT_BY_ID, productMapper, productId);
			return productOpt.orElse(null); // preserve original behavior
		} catch (SQLException e) {
			throw new DataAccessException("Database error while finding product by ID: " + productId, e);
		}
	}
}
