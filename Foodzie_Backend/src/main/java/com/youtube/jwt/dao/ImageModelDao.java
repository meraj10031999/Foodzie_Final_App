package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.ImageModel;
import com.youtube.jwt.entity.Role;

public interface ImageModelDao extends CrudRepository<ImageModel, Long>{

}
