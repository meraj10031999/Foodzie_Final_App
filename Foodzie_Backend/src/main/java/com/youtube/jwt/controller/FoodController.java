package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.Food;
import com.youtube.jwt.entity.ImageModel;
import com.youtube.jwt.response.MessageResponse;
import com.youtube.jwt.service.FoodService;

@RestController
@CrossOrigin()
public class FoodController {
	
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping(value = {"/addNewFood"} , consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<MessageResponse> addNewFood(@RequestPart("food") Food food , 
			@RequestPart("imageFile") MultipartFile[] file ) {
		
		//return foodService.addNewFood(food);
		try {
			
			Set<ImageModel> images = uploadImage(file);
			food.setImageModel(images);
			return foodService.addNewFood(food);
					
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		
		
		Set<ImageModel> imageModels = new HashSet<>();
		for (MultipartFile file : multipartFiles  ) {
			
			ImageModel imageModel= new ImageModel(
					 file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
			imageModels.add(imageModel);

			
		}
		
				return imageModels;
		
				
				
				
				
				
				
	}
	
	
	@GetMapping({"/getAllFood"})
	public List<Food> getAllFood(){
		System.out.println("Food invoked");
		 return foodService.getallFood();
		 
	}
	
	

}
