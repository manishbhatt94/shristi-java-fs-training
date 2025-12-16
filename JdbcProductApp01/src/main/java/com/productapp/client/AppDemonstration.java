package com.productapp.client;

import java.util.List;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

public class AppDemonstration {

	private IProductService productService;

	public AppDemonstration(IProductService productService) {
		super();
		this.productService = productService;
	}

	public void runDemo() {
		System.out.println("\n~=~=~=~=~=~=~=~=~=~= RUN DEMO START ~=~=~=~=~=~=~=~=~=~=\n");

		testGetAll();

		Product newProd1 = testNewProduct1();
		Product newProd2 = testNewProduct2();

		newProd2.setProductName("Updtd - " + newProd2.getProductName());
		testUpdate(newProd2);

		// find existing initially seeded product with ID = 5
		Product prodId5 = testFindById(5);

		// test update on existing initially seeded product
		prodId5.setBrand("NewTestBrand~$");
		testUpdate(prodId5);

		// test update on non-existing product
		try {
			testUpdate(new Product("Digital Multimeter", "Bosch", "Electrical", 5.75));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		testGetAll();

		System.out.println("~=~=~=~=~=~=~=~=~=~= RUN DEMO DONE ~=~=~=~=~=~=~=~=~=~=\n");

	}

	private void testGetAll() {
		System.out.println("Running productService.getAll");
		List<Product> products = productService.getAll();
		System.out.println("Current Products:");
		products.forEach(System.out::println);
		System.out.println("========================\n");
	}

	private Product testNewProduct1() {
		Product toAddProduct1 = new Product("Premium Filter Coffee Powder - 100gm", "Cothas", "Beverages", 12.25);
		System.out.println("Running productService.addProduct to add: " + toAddProduct1);
		Product addedProduct1 = productService.addProduct(toAddProduct1);
		System.out.println("Added: " + addedProduct1);
		System.out.println("========================\n");
		return addedProduct1;
	}

	private Product testNewProduct2() {
		Product toAddProduct2 = new Product("Mens Winter Beanie - Set of 3", "GAP", "Clothing", 19.99);
		System.out.println("Running productService.addProduct to add: " + toAddProduct2);
		Product addedProduct2 = productService.addProduct(toAddProduct2);
		System.out.println("Added: " + addedProduct2);
		System.out.println("========================\n");
		return addedProduct2;
	}

	private void testUpdate(Product updatedProduct) {
		System.out.println("Running productService.updateProduct for updating product to: " + updatedProduct);
		boolean updated = productService.updateProduct(updatedProduct);
		System.out.println("Updated: " + updated);
		System.out.println("========================\n");
	}

	private Product testFindById(int productId) {
		System.out.println("Running productService.getById to find product with ID: " + productId);
		Product matchedProduct = productService.getById(productId);
		System.out.println("Found: " + matchedProduct);
		System.out.println("========================\n");
		return matchedProduct;
	}

}
