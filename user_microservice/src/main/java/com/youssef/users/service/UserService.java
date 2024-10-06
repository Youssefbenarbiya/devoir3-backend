package com.youssef.users.service;

import java.util.List;

import com.youssef.users.entities.Role;
import com.youssef.users.entities.User;
import com.youssef.users.service.register.RegistrationRequest;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	User registerUser(RegistrationRequest request);
	
	public void sendEmailUser(User u, String code);
	public User validateToken(String code);	
	
}