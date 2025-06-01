package com.example.TenderManagementApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.model.UserModel;
import com.example.TenderManagementApplication.repository.RoleRepository;
import com.example.TenderManagementApplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public UserModel getUserByEmail(String email) {
		
		return userRepository.findByEmail(email)
				             .orElse(null);
		
	}
}
