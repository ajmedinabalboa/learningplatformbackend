package com.medina.learningplatform.service;

import java.util.List;

import com.medina.learningplatform.dto.CourseResponseDTO;

public interface CourseService {
	
	public List<CourseResponseDTO> getAvailableCourses();

}
