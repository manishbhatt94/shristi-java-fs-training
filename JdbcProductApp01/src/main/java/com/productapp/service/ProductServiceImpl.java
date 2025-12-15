package com.productapp.service;

import java.util.List;

import com.productapp.dao.IProductDao;
import com.productapp.dao.ProductDaoImpl;
import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService {

	private IProductDao productDao = new ProductDaoImpl();

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> getByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategoryAndBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategoryAndMaxPrice(String category, double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
