package com.productapp.client;

import java.sql.SQLException;
import java.util.List;

import com.productapp.model.Product;
import com.productapp.service.IProductService;
import com.productapp.service.ProductServiceImpl;
import com.productapp.util.DBConnection;

public class ProductApp {

	public static void main(String[] args) {

		ProductApp app = new ProductApp();

		app.runApp();
		app.shutdownApp();

	}

	public void runApp() {
		IProductService productService = new ProductServiceImpl();

		List<Product> products = productService.getAll();
		System.out.println("Initial Products:");
		products.forEach(System.out::println);
	}

	public void shutdownApp() {
		System.out.println("App flow finished.");
		try {
			DBConnection.closeConnection();
		} catch (SQLException e) {
			System.err.println("Error during app shutdown. " + e.getMessage());
			e.printStackTrace();
		}
	}

}
