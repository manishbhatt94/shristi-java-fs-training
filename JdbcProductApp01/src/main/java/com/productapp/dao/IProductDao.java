package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface IProductDao {

	void createProduct(Product product);

	void updateProductById(int productId);

	void deleteProductById(int productId);

	List<Product> findAll();

	List<Product> findByBrand(String brand);

	List<Product> findByCategory(String category);

	List<Product> findByCategoryAndBrand(String category, String brand);

	List<Product> findByCategoryAndMaxPrice(String category, double maxPrice);

	Product findById(int productId);

}
