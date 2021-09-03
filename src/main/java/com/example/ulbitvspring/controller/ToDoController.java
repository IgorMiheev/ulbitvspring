package com.example.ulbitvspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ulbitvspring.entity.ToDoEntity;
import com.example.ulbitvspring.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	@Autowired
	private ToDoService todoService;

	@PostMapping
	public ResponseEntity createToDo(@RequestBody ToDoEntity todo, @RequestParam Long userId) {
		try {
			return ResponseEntity.ok(todoService.createTodo(todo, userId));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("Ошибка создания ToDo");
		}
	}

	@PutMapping
	public ResponseEntity completeToDo(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(todoService.completeTodo(id));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("Ошибка изменения статуса ToDo");
		}
	}
}
