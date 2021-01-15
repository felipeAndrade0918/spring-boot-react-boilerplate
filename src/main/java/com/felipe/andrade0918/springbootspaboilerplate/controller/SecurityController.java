package com.felipe.andrade0918.springbootspaboilerplate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.andrade0918.springbootspaboilerplate.model.User;

@RestController
public class SecurityController {

	@GetMapping("/secure/test")
	public String securedEndpoint() {
		return "Safety first!";
	}

    @GetMapping(value="/security/authentication-failure")
    public ResponseEntity<String> authenticationFailure() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    @GetMapping(value="/security/authentication-successful")
    public ResponseEntity<String> authenticationSuccessful() {
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/secure/logged-user")
    public ResponseEntity<User> authenticationSuccessful(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
}
