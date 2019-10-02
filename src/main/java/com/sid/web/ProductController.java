package com.sid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sid.dao.ProductRepository;
import com.sid.entities.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productController;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String index() {
		return "redirect:index";
	}
	@GetMapping("/index")
	public String home(Model model) {
		List<Product> products = productController.findAll();
		model.addAttribute("products", products);
		return "index";
	}
	@GetMapping("/products")
	public String products() {
		return "products";
	}
	

}
