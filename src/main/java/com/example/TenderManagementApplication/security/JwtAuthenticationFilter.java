package com.example.TenderManagementApplication.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String header = request.getHeader("Authorization");
		
				
		if(header != null && !header.isBlank() && header.startsWith("Bearer ")) {
			
			String token = header.substring(7);
			String username = JwtUtil.extractUsername(token);
			UserDetails userDetails = null;
			if(username !=null) {
				userDetails = userDetailsService.loadUserByUsername(username);
			} 
			if(JwtUtil.validateToken(token,userDetails)) {
				
				List<GrantedAuthority> authorities = userDetails.getAuthorities()
						                                        .stream()
						                                        .collect(Collectors.toList());
						                       
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
