package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.Catagory;
import com.youtube.jwt.entity.Role;

public interface CatagoryDao extends CrudRepository<Catagory , Integer>{

}
