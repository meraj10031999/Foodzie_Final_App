package com.youtube.jwt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@Column(name="Price")
	private int price;
	
	@Column(name="Quantity")
	private int quantity;
	
	
		
		public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public int getPrice() {
			return price;
		}



		public void setPrice(int price) {
			this.price = price;
		}



		public int getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


	
	
	
}