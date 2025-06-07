package com.example.TenderManagementApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.dto.LoginDTO;
import com.example.TenderManagementApplication.model.RoleModel;
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
	
	public ResponseEntity<UserModel> addNewBidder(LoginDTO loginDTO) {
		UserModel userModel = new UserModel();
		userModel.setRole(new RoleModel(1));
		userModel.setCompanyName("company3");
		userModel.setEmail(loginDTO.getEmail());
		userModel.setPassword(loginDTO.getPassword());
		userModel.setUsername(loginDTO.getEmail());
		UserModel userModel2 = userRepository.save(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel2);
	}
}
