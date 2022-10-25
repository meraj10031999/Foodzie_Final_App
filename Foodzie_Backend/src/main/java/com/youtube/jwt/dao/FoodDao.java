package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.Food;
import com.youtube.jwt.entity.Role;

public interface FoodDao extends CrudRepository<Food, Integer> {

}
