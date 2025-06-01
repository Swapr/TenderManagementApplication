package com.example.TenderManagementApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.model.UserModel;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userService.getUserByEmail(username);
	}
	
	
	private UserDetails buildUserForAuthentication(UserModel user, List<GrantedAuthority> authorities) {
		return null;
	}
	
	private List<GrantedAuthority> buildUserAuthority(String userRole){
		return null;
	}

}
