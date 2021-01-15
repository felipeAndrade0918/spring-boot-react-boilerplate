package com.felipe.andrade0918.springbootspaboilerplate.service;

import java.util.List;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;

public interface UserService {

	User createRandomUser();
	
	List<User> getUsers();
}
