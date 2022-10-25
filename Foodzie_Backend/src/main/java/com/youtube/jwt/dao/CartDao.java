package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.Cart;
import com.youtube.jwt.entity.Role;

public interface CartDao extends CrudRepository<Cart, Integer>{

}
