package com.sid.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.ProductRepository;
import com.sid.entities.Product;

@RestController
@RequestMapping("/api")
public class PublicController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> listProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/users")
	public List<String> listUsers() {
		List<String> users =new ArrayList<String>();
		users.add("Taoufiq");
		users.add("Mohammed");
		users.add("Othmane");
		return users;
	}

}
