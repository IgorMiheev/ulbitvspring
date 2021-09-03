package com.example.ulbitvspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exception.UserAlreadyExistException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<String> registration(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok("Пользователь успешно сохранен");
//			return new ResponseEntity<String>("its work", HttpStatus.OK);
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}

	@GetMapping
	public ResponseEntity getOneUser(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(userService.getOne(id));
//			return new ResponseEntity<String>("its work", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(userService.delete(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}

}
