package com.medina.learningplatform.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "34753778214125442A472D4B6150645367566B58703273357638792F423F4528";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	public static String createToken(String fullName, String username) {
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000L;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String,Object> claims = new HashMap<>();
		claims.put("fullName", fullName);
		
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(expirationDate)
				.addClaims(claims)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String username = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(username, null,Collections.emptyList());
		} catch (JwtException e) {
			// No UsernamePasswordAuthenticationToken has provided in correct format
			return null;
		}
	}

}
