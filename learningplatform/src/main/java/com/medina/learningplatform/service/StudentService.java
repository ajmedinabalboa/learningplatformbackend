package com.medina.learningplatform.service;

import com.medina.learningplatform.dto.StudentRequestDTO;
import com.medina.learningplatform.dto.StudentRequestUpdateDTO;
import com.medina.learningplatform.dto.StudentResponseDTO;

public interface StudentService {
	
	public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
	
	public StudentResponseDTO modifyStudent(String username,StudentRequestUpdateDTO studentRequestUpdateDTO);
	
	public StudentResponseDTO getStudentByUserName(String username);
		
}