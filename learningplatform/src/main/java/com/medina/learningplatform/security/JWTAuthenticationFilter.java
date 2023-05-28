package com.medina.learningplatform.security;

import java.util.Collections;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.medina.learningplatform.dto.AuthCredentials;
import com.medina.learningplatform.model.Student;
import com.medina.learningplatform.repository.StudentRepository;
import com.medina.learningplatform.service.impl.UserDetailsImpl;

import io.swagger.v3.core.util.Json;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
												HttpServletResponse response)
												throws AuthenticationException {
		// TODO Auto-generated method stub
		AuthCredentials authCredentials = new AuthCredentials();		
		
		try {
			//authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
			authCredentials = new Gson().fromJson(request.getReader(), AuthCredentials.class);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(
				authCredentials.getUsername(),
				authCredentials.getPassword(),
				Collections.emptyList()				
		);		
		return getAuthenticationManager().authenticate(usernamePasswordToken);   
      
	}	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws java.io.IOException, ServletException {
		// TODO Auto-generated method stub
		
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetailsImpl.getFullName(),userDetailsImpl.getUsername());
				
		response.addHeader("Authorization", "Bearer "+ token);			
		response.getWriter().flush();
				
		super.successfulAuthentication(request, response, chain, authResult);
	}
}
