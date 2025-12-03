package com.restapiproject.hotelManagement.auth;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	// helper -> create validate and read JWT in app
	
	// create a random secert key - siging JWT tokens using HS256 alogrithm
	
	// same key is used to sign AND verify JWT
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	private final long expiration = 1000*60*60; // 1 Hour

	// Method for generating token 
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(key)
				.compact();
	}
	
	// Method getUserNameFromToken
	public String getUserNameFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build()
				.parseClaimsJws(token).getBody().getSubject();
	}
	
	// validate Token
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build();
			return true;
		}
		catch(JwtException e) {
			return false; 
		}
	}
	
}
