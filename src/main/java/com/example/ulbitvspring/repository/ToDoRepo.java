package com.example.ulbitvspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ulbitvspring.entity.ToDoEntity;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {

}
