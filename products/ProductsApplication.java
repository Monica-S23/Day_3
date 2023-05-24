package com.telusko.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ProductsApplication.class, args);
		ProductService service= context.getBean(ProductService.class) ;


		// Retrieving products depends on the name of the products
		List<Product> product1 = service.getProductByName("BlackBeast");
		System.out.println("Fetching products based on the name of the products");
		for(Product product : product1){
			System.out.println(product);
		}
		System.out.println("************************************");


		// Retrieving products depends on the type of the products
		System.out.println("Fetching products based on the type of the products");
		List<Product> product2 = service.getProductByType("mouse");
		for(Product product : product2){
			System.out.println(product);
		}
		System.out.println("************************************");

		// Retrieving products depends on the place
		System.out.println("Fetching products based on the place of the products");
		List<Product> product3 = service.getProductWithPlace("White table");
		for(Product product : product3){
			System.out.println(product);
		}
		System.out.println("************************************");

		// Retrieving products which are currently out of Warranty
		System.out.println("Fetching products based on the currently out of warranty");
		List<Product> product4 = service.getProductOutOfWarrenty(2023);
		for(Product product : product4){
			System.out.println(product);
		}
		System.out.println("************************************");

		// Retrieving product based on the text
		System.out.println("Fetching products based on the given text");
		List<Product> product5 = service.getProductWithText("black");
		for(Product product : product5){
			System.out.println(product);
		}
		System.out.println("************************************");

		// Retrieving all products
		System.out.println("Fetching all products");
		List<Product> product6 = service.getAllProducts();
		for(Product p : product6){
			System.out.println(p);
		}
		System.out.println("************************************");
	}

}
