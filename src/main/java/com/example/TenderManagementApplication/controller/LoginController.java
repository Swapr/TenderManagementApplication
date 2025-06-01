package com.example.TenderManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
	private JwtUtil jwtUtil;
	
	@Autowired
	private  UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser (@RequestBody LoginDTO authenticationRequest) throws Exception{
		
		try {
			Authentication authentication =  authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getEmail(),
							authenticationRequest.getPassword()));
			
			UserModel userModel = (UserModel) authentication.getPrincipal();
			String jwtToken = jwtUtil.generateToken(userModel);
			return ResponseEntity.ok(new LoginResponse(jwtToken,200));
			
			
		} catch (Exception e) {
			System.out.println("exception occured while authenticating");
			LoginResponse loginResponse = new LoginResponse(null, 400); 
			return ResponseEntity.badRequest().body(loginResponse);
			
		}
		
	}
}
