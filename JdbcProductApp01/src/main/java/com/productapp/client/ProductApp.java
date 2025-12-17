package com.productapp.client;

import java.sql.SQLException;

import com.productapp.dao.SeedProductsUltraSlim;
import com.productapp.service.IProductService;
import com.productapp.service.ProductServiceImpl;
import com.productapp.util.DBConnection;

public class ProductApp {

	public static void main(String[] args) {

		ProductApp app = new ProductApp();
		try {
			app.initializeAppData();
			app.runApp();
		} catch (Exception e) {
			System.err.println("App initialization failed: " + e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			app.shutdownApp();
		}

	}

	private void initializeAppData() throws SQLException {
		SeedProductsUltraSlim.seed();
	}

	private void runApp() {
		IProductService productService = new ProductServiceImpl();

		AppDemonstration appDemo = new AppDemonstration(productService);
		appDemo.runDemo();
	}

	private void shutdownApp() {
		System.out.println("App flow finished.");
		try {
			DBConnection.closeConnection();
		} catch (SQLException e) {
			System.err.println("Error during app shutdown. " + e.getMessage());
			e.printStackTrace();
		}
	}

}
