package com.example.TenderManagementApplication.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.TenderManagementApplication.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


public class JwtUtil {
	
	@Value("${jwt.secretKey}")
	private static  String secretKey;
	@Value("$jwt.token.validity}")
	private static int tokenValidity;
	
	
	private static SecretKey getKey() {
		
		byte[] keyArray = Decoders.BASE64.decode(secretKey);
		if( keyArray.length < 32 ) {
			throw new IllegalArgumentException("key size must be greator than 32");
		}
		return Keys.hmacShaKeyFor(keyArray);
}
	
	
	
	public static String generateToken(UserModel userModel) {
		
	     List<String> roles = userModel.getAuthorities().stream()
	    		                                        .map(GrantedAuthority::getAuthority)
	    		                                        .collect(Collectors.toList());
	     Map<String, List<String>> claims = new HashMap<>();
	     claims.put("roles", roles);
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(userModel.getEmail())
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis()+tokenValidity))
				   .signWith(getKey(),SignatureAlgorithm.HS256)
				   .compact();
		
	}
	
	
	public static boolean validateToken(String token, UserDetails userDetails) {
		
		if(userDetails != null && !isExpired(token) ) {
			return true;
		}
		return false;
	}
	
	public static String extractUsername(String token) {
		 Claims claims =  extractAllcalims(token);
		 return claims.getSubject();
	}
	
	public static boolean isExpired(String token) {
		Claims claims = extractAllcalims(token);
		return  claims.getExpiration().before(new Date(System.currentTimeMillis()));
	}
	
	public static Claims extractAllcalims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(getKey())
				   .build()
				   .parseClaimsJws(token)
				   .getBody();
				   
	}
	
	
}
