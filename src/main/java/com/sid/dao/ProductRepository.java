package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
