package com.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double price;
	private int quantite;
	
	
	public Product(String description, double price, int quantite) {
		super();
		this.description = description;
		this.price = price;
		this.quantite = quantite;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", quantite=" + quantite
				+ "]";
	}
	
	

}
