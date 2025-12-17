package com.productapp.service;

import java.util.List;

import com.productapp.dao.IProductDao;
import com.productapp.dao.ProductDaoSlimImpl;
import com.productapp.exceptions.NoProductsAvailableException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.exceptions.ProductsNotFoundForCriteriaException;
import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService {

	// private IProductDao productDao = new ProductDaoImpl();
	private IProductDao productDao = new ProductDaoSlimImpl();

	@Override
	public Product addProduct(Product product) {
		return productDao.createProduct(product);
	}

	@Override
	public boolean updateProduct(Product updatedProduct) {
		boolean updated = productDao.updateProductById(updatedProduct);
		if (!updated) {
			throw new ProductNotFoundException("Product with ID " + updatedProduct.getProductId() + " not found");
		}
		return updated;
	}

	@Override
	public boolean deleteProduct(int productId) {
		boolean deleted = productDao.deleteProductById(productId);
		if (!deleted) {
			throw new ProductNotFoundException("Product with ID " + productId + " not found");
		}
		return deleted;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = productDao.findAll();
		if (products.isEmpty()) {
			throw new NoProductsAvailableException("No products available in the catalog");
		}
		return products;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> products = productDao.findByBrand(brand);
		if (products.isEmpty()) {
			throw new ProductsNotFoundForCriteriaException("No products found for brand: " + brand);
		}
		return products;
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products = productDao.findByCategory(category);
		if (products.isEmpty()) {
			throw new ProductsNotFoundForCriteriaException("No products found for category: " + category);
		}
		return products;
	}

	@Override
	public List<Product> getByCategoryAndBrand(String category, String brand) {
		List<Product> products = productDao.findByCategoryAndBrand(category, brand);
		if (products.isEmpty()) {
			String message = "No products found for category: " + category + ", and brand: " + brand;
			throw new ProductsNotFoundForCriteriaException(message);
		}
		return products;
	}

	@Override
	public List<Product> getByCategoryAndMaxPrice(String category, double maxPrice) {
		List<Product> products = productDao.findByCategoryAndMaxPrice(category, maxPrice);
		if (products.isEmpty()) {
			String message = "No products found for category: " + category + ", and maxPrice: " + maxPrice;
			throw new ProductsNotFoundForCriteriaException(message);
		}
		return products;
	}

	@Override
	public Product getById(int productId) {
		Product product = productDao.findById(productId);
		if (product == null) {
			throw new ProductNotFoundException("Product with ID " + productId + " not found");
		}
		return product;
	}

}
