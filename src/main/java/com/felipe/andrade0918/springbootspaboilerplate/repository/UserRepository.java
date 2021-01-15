package com.felipe.andrade0918.springbootspaboilerplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
}
