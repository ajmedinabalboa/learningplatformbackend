package com.medina.learningplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medina.learningplatform.model.Student;
import com.medina.learningplatform.repository.StudentRepository;
import com.medina.learningplatform.utils.ValueMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository
				.findOneByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username "+username+" doesn't exists"));
		
		if(student != null) {
			student.setLastLogin(ValueMapper.getLocalDateNow());
			studentRepository.save(student);
		}
		
		return new UserDetailsImpl(student);
	}	
}
