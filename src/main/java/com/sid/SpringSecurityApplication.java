package com.sid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sid.dao.ProductRepository;
import com.sid.dao.UserRepository;
import com.sid.entities.Product;
import com.sid.entities.User;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository, UserRepository userRepository,
			BCryptPasswordEncoder encoder) {
		return args -> {
			productRepository.deleteAll();
			productRepository.save(new Product("XPS 2018", 20000, 10));
			productRepository.save(new Product("MAC Pro 2019", 30000,50));
			productRepository.save(new Product("Lenovo 2018", 20000, 19));
			
			userRepository.deleteAll();
			userRepository.save(new User("user",encoder.encode("user"),"USER",""));
			userRepository.save(new User("admin",encoder.encode("admin"),"ADMIN,USER","ACCESS_PRODUCTS,ACCESS_USERS"));
			userRepository.save(new User("manager", encoder.encode("manager"),"MANAGER,USER","ACCESS_PRODUCTS"));
		};
	}

}
