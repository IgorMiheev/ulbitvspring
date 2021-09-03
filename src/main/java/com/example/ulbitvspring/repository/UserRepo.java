package com.example.ulbitvspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ulbitvspring.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
