package com.productapp.client;

import java.sql.SQLException;

import com.productapp.model.SeedProducts;

public class ProductApp {

	public static void main(String[] args) {

		try {
			SeedProducts.createProductTable();
			SeedProducts.insertSeedProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
