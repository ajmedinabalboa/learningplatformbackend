package com.medina.learningplatform.utils;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.dto.EnrollmentRequestDTO;
import com.medina.learningplatform.dto.EnrollmentResponseDTO;
import com.medina.learningplatform.dto.StudentRequestDTO;
import com.medina.learningplatform.dto.StudentResponseDTO;
import com.medina.learningplatform.model.Course;
import com.medina.learningplatform.model.Enrollment;
import com.medina.learningplatform.model.Student;

public class ValueMapper {
	
	public static Student convertToEntity(StudentRequestDTO studentDto) {
		Student student = new Student();
		student.setUserName(studentDto.getUserName());
		student.setPassword(passwordEncoder().encode(studentDto.getPassword()));
		student.setFullName(studentDto.getFullName());	
		student.setCountry(studentDto.getCountry());
		student.setDataCreated(getLocalDateNow());
		return student;
    }	

    public static StudentResponseDTO convertToDTO(Student student){
    	StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
    	studentResponseDTO.setFullName(student.getFullName());;
    	studentResponseDTO.setId(student.getId());    	
    	studentResponseDTO.setDataCreated(student.getDataCreated());    	   	
    	studentResponseDTO.setBirthDate(student.getBirthDate());
    	studentResponseDTO.setPhoneNumber(student.getPhoneNumber());
    	studentResponseDTO.setCountry(student.getCountry());
    	studentResponseDTO.setDataCreated(student.getDataCreated());
    	studentResponseDTO.setLastLogin(student.getLastLogin());
    	studentResponseDTO.setUserName(student.getUserName());  
    	studentResponseDTO.setGender(student.getGender()); 
    	studentResponseDTO.setAddress(student.getAddress()); 
    	studentResponseDTO.setLanguage(student.getLanguage()); 
    	studentResponseDTO.setEducationLevel(student.getEducationLevel()); 
    	return studentResponseDTO;
    }

    public static Enrollment convertToEntity(EnrollmentRequestDTO enrollmentRequestDTO) {
    	Enrollment enrollment = new Enrollment();
    	enrollment.setIdStudent(enrollmentRequestDTO.getIdStudent());
    	enrollment.setIdCourse(enrollmentRequestDTO.getIdCourse());
    	enrollment.setEnrollmentDate(enrollmentRequestDTO.getEnrollmentDate());
    	enrollment.setIsCancelled(enrollmentRequestDTO.getIsCancelled());
    	return enrollment;
    }
    
    public static EnrollmentResponseDTO convertToDTO(Enrollment enrollment) {
    	EnrollmentResponseDTO enrollmentResponseDTO = new EnrollmentResponseDTO();
    	enrollmentResponseDTO.setId(enrollment.getId());
    	enrollmentResponseDTO.setCancellationReason(enrollment.getCancellationReason());
    	enrollmentResponseDTO.setEnrollmentDate(enrollment.getEnrollmentDate());
    	enrollmentResponseDTO.setIdCourse(enrollment.getIdCourse());   
    	enrollmentResponseDTO.setIdStudent(enrollment.getIdStudent());
    	enrollmentResponseDTO.setIsCancelled(enrollment.getIsCancelled());
    	return enrollmentResponseDTO;
    }
    
    public static CourseResponseDTO convertToDTO(Course course) {
    	CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
    	courseResponseDTO.setId(course.getId());
    	courseResponseDTO.setAbstractDescription(course.getAbstractDescription());
    	courseResponseDTO.setAuthor(course.getAuthor());
    	courseResponseDTO.setCourseDescription(course.getCourseDescription());
    	courseResponseDTO.setIdCategory(course.getIdCategory());
    	courseResponseDTO.setStartDate(course.getStartDate());
    	courseResponseDTO.setEndDate(course.getEndDate());
    	courseResponseDTO.setRate(course.getRate());
    	courseResponseDTO.setAttendance(course.getAttendance());
    	courseResponseDTO.setTotalHours(course.getTotalHours());
    	return courseResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    public static Date getLocalDateNow(){
		return new Date();
	}
}
