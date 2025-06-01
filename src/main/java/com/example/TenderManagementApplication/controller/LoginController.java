package com.example.TenderManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TenderManagementApplication.dto.LoginDTO;
import com.example.TenderManagementApplication.dto.LoginResponse;
import com.example.TenderManagementApplication.model.UserModel;
import com.example.TenderManagementApplication.security.JwtUtil;
import com.example.TenderManagementApplication.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("login")
	public LoginResponse authenticateUser (@RequestBody LoginDTO authenticationRequest) throws Exception{
		UserModel userModel = userService.getUserByEmail(authenticationRequest.getEmail());
		LoginResponse loginResponse= new LoginResponse();
		if(userModel == null) {
			loginResponse.setJwt(null);
			loginResponse.setStatus(400);
		}
		else {
			loginResponse.setJwt(jwtUtil.generateToken(userModel));
			loginResponse.setStatus(200);
		}
		return loginResponse;
	}
}
