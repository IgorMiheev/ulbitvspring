package com.example.ulbitvspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exception.UserAlreadyExistException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.model.User;
import com.example.ulbitvspring.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
		if (userRepo.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("Пользователь с таким именем уже существует!");
		}
		return userRepo.save(user);
	}

	public User getOne(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).orElse(null);
		if (user == null) {
			throw new UserNotFoundException("Пользователь с таким id не найден");
		}
		return User.toModel(user);
	}

	public Long delete(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).orElse(null);
		if (user == null) {
			throw new UserNotFoundException("Пользователь с таким id не найден");
		}
		userRepo.deleteById(id);
		return id;
	}
}
