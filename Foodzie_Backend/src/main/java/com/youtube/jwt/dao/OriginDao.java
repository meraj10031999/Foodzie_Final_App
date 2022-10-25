package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.Origin;
import com.youtube.jwt.entity.Role;

public interface OriginDao extends CrudRepository<Origin, Integer> {

}
