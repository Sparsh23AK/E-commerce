package com.sghc.ecommerce.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.Role;
import com.sghc.ecommerce.entity.User;
import com.sghc.ecommerce.repository.RoleRepository;
import com.sghc.ecommerce.repository.UserRepository;
import com.sghc.ecommerce.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class userServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(User user) {
		Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepository.save(user);
	}
	
	 public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }

}
