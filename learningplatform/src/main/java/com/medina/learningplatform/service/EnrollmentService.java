package com.medina.learningplatform.service;

import java.util.List;

import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.dto.EnrollmentRequestDTO;
import com.medina.learningplatform.dto.EnrollmentRequestUpdateDTO;
import com.medina.learningplatform.dto.EnrollmentResponseDTO;

public interface EnrollmentService {
	
	public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO);
	
	public EnrollmentResponseDTO unsubscribeEnrollment(int idStudent, int idCourse,EnrollmentRequestUpdateDTO enrollmentRequestUpdateDTO);
	
	public List<CourseResponseDTO> getCourseEnrollmentByIdStudent(int id);
}
