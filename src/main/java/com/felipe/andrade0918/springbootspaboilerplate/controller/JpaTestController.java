package com.felipe.andrade0918.springbootspaboilerplate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;
import com.felipe.andrade0918.springbootspaboilerplate.service.UserService;

@RestController
@RequestMapping("/jpa-test")
public class JpaTestController {

	private UserService userService;
	
	public JpaTestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public User createUser() {
		return userService.createRandomUser();
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
