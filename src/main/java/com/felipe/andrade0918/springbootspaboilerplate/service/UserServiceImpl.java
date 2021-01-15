package com.felipe.andrade0918.springbootspaboilerplate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;
import com.felipe.andrade0918.springbootspaboilerplate.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String[] RANDOM_NAMES = { 
			"Cabo Rubens", "Sargento Palhares", "Soldado Nivaldo",
			"Soldado Santos", "Soldado Robson", "Major Maciel" 
	};
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	@Override
	public User createRandomUser() {
		User user = new User();
		
		int randomNameIndex = (int) (Math.random() * RANDOM_NAMES.length);
		String randomName = RANDOM_NAMES[randomNameIndex];
		
		user.setName(randomName);
		user.setEmail(String.format(
				"%s_%s@gmail.com", randomName.toLowerCase()
				.replace(" ", ""), UUID.randomUUID().toString().split("-")[0])
				);
		user.setPassword(passwordEncoder.encode("1"));
		
		return userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
