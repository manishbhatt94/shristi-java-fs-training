package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	Product addProduct(Product product);

	boolean updateProduct(Product updatedProduct);

	boolean deleteProduct(int productId);

	List<Product> getAll();

	List<Product> getByBrand(String brand);

	List<Product> getByCategory(String category);

	List<Product> getByCategoryAndBrand(String category, String brand);

	List<Product> getByCategoryAndMaxPrice(String category, double maxPrice);

	Product getById(int productId);

}
