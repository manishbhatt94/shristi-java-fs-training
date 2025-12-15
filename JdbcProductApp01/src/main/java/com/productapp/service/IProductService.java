package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	void addProduct(Product product);

	void updateProduct(int productId);

	void deleteProduct(int productId);

	List<Product> getAll();

	List<Product> getByBrand(String brand);

	List<Product> getByCategory(String category);

	List<Product> getByCategoryAndBrand(String category, String brand);

	List<Product> getByCategoryAndMaxPrice(String category, double maxPrice);

	Product getById(int productId);

}
