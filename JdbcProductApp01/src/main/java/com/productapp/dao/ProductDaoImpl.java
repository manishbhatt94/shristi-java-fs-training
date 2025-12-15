package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productapp.model.Product;
import com.productapp.util.DBConnection;
import com.productapp.util.Queries;

public class ProductDaoImpl implements IProductDao {

	static {
		try {
			SeedProducts.seed();
		} catch (SQLException e) {
			e.printStackTrace();
			final String errMessage = "Seed Error - Failed to create 'product' table / seed data in it.";
			System.err.println(errMessage);
			// Wrap and rethrow as a RuntimeException (or ExceptionInInitializerError)
			throw new RuntimeException(errMessage, e);
		}
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductById(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductById(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();

		try {
			Connection connection = DBConnection.getConnection();

			try (PreparedStatement statement = connection.prepareStatement(Queries.PRODUCT_SELECT);
					ResultSet rs = statement.executeQuery();) {

				while (rs.next()) {
					// product_id, product_name, brand, category, price
					int productId = rs.getInt("product_id");
					String productName = rs.getString("product_name");
					String brand = rs.getString("brand");
					String category = rs.getString("category");
					double price = rs.getDouble("price");
					products.add(new Product(productId, productName, brand, category, price));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public List<Product> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategoryAndBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategoryAndMaxPrice(String category, double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
