package com.sid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sid.dao.ProductRepository;
import com.sid.entities.Product;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("XPS 2018", 20000, 10));
			productRepository.save(new Product("MAC Pro 2019", 30000,50));
			productRepository.save(new Product("Lenovo 2018", 20000, 19));
			
		};
	}

}
