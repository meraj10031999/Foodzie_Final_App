package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.FoodDao;
import com.youtube.jwt.entity.Food;
import com.youtube.jwt.response.MessageResponse;


@Service
public class FoodService {
	
	//List<Food> a= new List();
	
	
	@Autowired
	private FoodDao foodDao;
	
	public ResponseEntity<MessageResponse> addNewFood(Food food) {
		
		 foodDao.save(food);
		return ResponseEntity.ok(new MessageResponse("Food Added successfully!"));

		
	}
	
	public List<Food> getallFood(){
		System.out.println("Food Service invoked");
		List<Food> food=(List<Food>) foodDao.findAll();
		System.out.println(food);
		return (List<Food>) foodDao.findAll();
	}
		
	}