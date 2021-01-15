package com.felipe.andrade0918.springbootspaboilerplate.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;
import com.felipe.andrade0918.springbootspaboilerplate.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findOneByEmail(email);
		
		if (user != null) {
			return user;
		}
		
		throw new UsernameNotFoundException(String.format(
				"No user with the email %s has been found", email
				));
	}

}
