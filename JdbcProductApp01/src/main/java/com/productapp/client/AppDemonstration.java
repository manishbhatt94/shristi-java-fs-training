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

		// =========== ************ =============
		// =========== SEED TEST =============
		testGetAll();

		// =========== ************ =============
		// =========== CREATE TESTS =============

		// test adding new product
		Product newProd1 = testNewProduct1();
		// test adding new product, again
		Product newProd2 = testNewProduct2();

		// =========== ************ =============
		// =========== UPDATE TESTS =============

		// test update on newly added product `newProd2`
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

		// =========== ************ =============
		// =========== DELETE TESTS =============

		// test delete on existing initially seeded product with ID = 17
		testDelete(17);

		// test delete on a newly added product `newProd1`
		testDelete(newProd1.getProductId());

		// test delete on existing initially seeded product with ID = 11
		testDelete(11);

		// test delete on non-existing product
		try {
			testDelete(55);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// test delete on existing initially seeded product with ID = 3
		testDelete(3);

		// =========== ############ =============
		// =========== FILTER TESTS =============
		// =========== ############ =============

		// =========== ************ ======================
		// ====== FILTER BY BRAND TESTS =============

		// test getByBrand for existing brand
		testGetByBrand("Levi's");

		// test getByBrand for non-existent brand
		try {
			testGetByBrand("Beverages");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// =========== ************ ======================
		// ====== FILTER BY CATEGORY TESTS =============

		// test getByCategory for existing category
		testGetByCategory("Home & Kitchen");

		// test getByCategory for non-existent category
		try {
			testGetByCategory("Toys");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// =========== ************ ======================
		// ====== FILTER BY CATEGORY + BRAND TESTS =============

		// test getByCategoryAndBrand for existing category and existing brand
		testGetByCategoryAndBrand("Clothing", "GAP");

		// test getByCategoryAndBrand for non-existent combination
		// i.e. existing category and non-existent brand
		try {
			testGetByCategoryAndBrand("Electronics", "NVIDIA");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// test getByCategoryAndBrand for non-existent combination
		// i.e. non-existent category and existing brand
		try {
			testGetByCategoryAndBrand("Grooming", "Apple");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// =========== ************ ======================
		// ====== FILTER BY CATEGORY + MAXPRICE TESTS ==========

		// test getByCategoryAndMaxPrice for existing category and price
		testGetByCategoryAndMaxPrice("Books", 25.0);

		// test getByCategoryAndMaxPrice for non-existent category or price
		// i.e. existing category, but too low maxPrice
		try {
			testGetByCategoryAndMaxPrice("Clothing", 1.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// test getByCategoryAndMaxPrice for non-existent category or price
		// i.e. non-existent category, but satisfactory maxPrice
		try {
			testGetByCategoryAndMaxPrice("Automotive", 2500.0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		// =========== ############ =============
		// =========== ************ =============
		// =========== CHECK FINAL TABLE STATE ======

		// final getAll test
		testGetAll();

		System.out.println("~=~=~=~=~=~=~=~=~=~= RUN DEMO DONE ~=~=~=~=~=~=~=~=~=~=\n");

	}

	private void testGetAll() {
		System.out.println("Running productService.getAll");
		List<Product> products = productService.getAll();
		System.out.println("Current Products:");
		printProductsList(products);
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

	private void testDelete(int productId) {
		System.out.println("Running productService.deleteProduct for deleting product with ID: " + productId);
		boolean deleted = productService.deleteProduct(productId);
		System.out.println("Deleted: " + deleted);
		System.out.println("========================\n");
	}

	private void testGetByBrand(String brand) {
		System.out.println("Running productService.getByBrand for brand: " + brand);
		List<Product> products = productService.getByBrand(brand);
		System.out.println("Products with brand=" + brand + ":");
		printProductsList(products);
		System.out.println("========================\n");
	}

	private void testGetByCategory(String category) {
		System.out.println("Running productService.getByCategory for category: " + category);
		List<Product> products = productService.getByCategory(category);
		System.out.println("Products with category=" + category + ":");
		printProductsList(products);
		System.out.println("========================\n");
	}

	private void testGetByCategoryAndBrand(String category, String brand) {
		System.out.println(
				"Running productService.getByCategoryAndBrand for category: " + category + ", brand: " + brand);
		List<Product> products = productService.getByCategoryAndBrand(category, brand);
		System.out.println("Products with category=" + category + " and brand=" + brand + ":");
		printProductsList(products);
		System.out.println("========================\n");
	}

	private void testGetByCategoryAndMaxPrice(String category, double maxPrice) {
		System.out.println("Running productService.getByCategoryAndMaxPrice for category: " + category + ", maxPrice: "
				+ maxPrice);
		List<Product> products = productService.getByCategoryAndMaxPrice(category, maxPrice);
		System.out.println("Products with category=" + category + " and price <= " + maxPrice + ":");
		printProductsList(products);
		System.out.println("========================\n");
	}

	private void printProductsList(List<Product> products) {
		products.forEach(System.out::println);
		long count = products.stream().count();
		System.out.println("Products count = " + count);
	}

}
