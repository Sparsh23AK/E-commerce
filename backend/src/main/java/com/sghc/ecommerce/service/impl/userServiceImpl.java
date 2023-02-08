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
	
	public void initRoleAndAdmin() {
		Role role = new Role();
		role.setRoleName("Admin");
		role.setDescription("Admin role");
		roleRepository.save(role);
		
		Role role2 = new Role();
		role.setRoleName("User");
		role.setDescription("user role");
		roleRepository.save(role2);
		
		    User adminUser = new User();
	        adminUser.setUserName("sparsh23AK");
	        adminUser.setUserPassword(getEncodedPassword("Undertake@101"));
	        adminUser.setFirstName("Sparsh");
	        adminUser.setLastName("Giri");
	        Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(role);
	        adminUser.setRole(adminRoles);
	        userRepository.save(adminUser);
	        
	        User adminUser2 = new User();
	        adminUser.setUserName("himanshuRyzen");
	        adminUser.setUserPassword(getEncodedPassword("Ryzen@101"));
	        adminUser.setFirstName("Himanshu");
	        adminUser.setLastName("Chaurasia");
	        Set<Role> adminRoles2 = new HashSet<>();
	        adminRoles2.add(role);
	        adminUser.setRole(adminRoles2);
	        userRepository.save(adminUser2);

	}
	
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
