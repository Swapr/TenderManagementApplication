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
import org.springframework.stereotype.Component;

import com.example.TenderManagementApplication.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
	
	
	private   String secretKey;
	
	private  int tokenValidity;
	
    public JwtUtil(@Value("${jwt.secretKey}") String secretKey,
            @Value("${jwt.token.validity}") int tokenValidity) {
 this.secretKey = secretKey;
 this.tokenValidity = tokenValidity;
}
	
	
	private  SecretKey getKey() {
		
		byte[] keyArray = Decoders.BASE64.decode(secretKey);
		if( keyArray.length < 32 ) {
			throw new IllegalArgumentException("key size must be greator than 32");
		}
		return Keys.hmacShaKeyFor(keyArray);
}
	
	
	
	public  String generateToken(UserModel userModel) {
		
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
	
	
	public  boolean validateToken(String token, UserDetails userDetails) {
		
		if(userDetails != null && !isExpired(token) ) {
			return true;
		}
		return false;
	}
	
	public  String extractUsername(String token) {
		 Claims claims =  extractAllcalims(token);
		 return claims.getSubject();
	}
	
	public  boolean isExpired(String token) {
		Claims claims = extractAllcalims(token);
		return  claims.getExpiration().before(new Date(System.currentTimeMillis()));
	}
	
	public  Claims extractAllcalims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(getKey())
				   .setAllowedClockSkewSeconds(1800)
				   .build()
				   .parseClaimsJws(token)
				   .getBody();
				   
	}
	
	
}
