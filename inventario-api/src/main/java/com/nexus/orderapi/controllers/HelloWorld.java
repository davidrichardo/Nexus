package com.nexus.orderapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorld {
	
	@GetMapping(value="hello")
	public String hello() {
		return "Hello David";
	}
	
//	@GetMapping(value = "product")
//	public Mercancia findProduct() {
//		/*
//		Product product = new Product();
//		product.setId(1L);
//		product.setName("product");
//		product.setPrice("100");
//		return product;*/
//		
//		Mercancia product = Mercancia.builder()
//				.id(1L)
//				.name("Product 1")
//				.price("100")
//				.build();
//		return product;
//	}

}
