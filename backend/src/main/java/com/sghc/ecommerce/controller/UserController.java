package com.sghc.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sghc.ecommerce.entity.User;
import com.sghc.ecommerce.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
//	 @PostConstruct
//	    public void initRoleAndUser() {
//	        userService.initRoleAndAdmin();
//	    }
	 
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
}
