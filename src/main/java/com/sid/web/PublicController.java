package com.sid.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.ProductRepository;
import com.sid.dao.UserRepository;
import com.sid.entities.Product;
import com.sid.entities.User;

@RestController
@RequestMapping("/api")
public class PublicController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/products")
	public List<Product> listProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/users")
	public List<User> listUsers() {
		return userRepository.findAll();
	}

}
