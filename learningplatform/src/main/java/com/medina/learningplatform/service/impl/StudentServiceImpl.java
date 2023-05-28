package com.medina.learningplatform.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medina.learningplatform.dto.AuthCredentials;
import com.medina.learningplatform.dto.StudentRequestDTO;
import com.medina.learningplatform.dto.StudentRequestUpdateDTO;
import com.medina.learningplatform.dto.StudentResponseDTO;
import com.medina.learningplatform.exception.NotFoundException;
import com.medina.learningplatform.exception.ServiceBusinessException;
import com.medina.learningplatform.model.Student;
import com.medina.learningplatform.repository.StudentRepository;
import com.medina.learningplatform.service.StudentService;
import com.medina.learningplatform.utils.ValueMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) throws ServiceBusinessException {
		// TODO Auto-generated method stub
		StudentResponseDTO studentResponseDTO;		   
		Optional<Student> studentprevious = studentRepository.findOneByUserName(studentRequestDTO.getUserName());
		if(studentprevious.isEmpty()) {
			try {    
	            Student student = ValueMapper.convertToEntity(studentRequestDTO);
	            Student studentResults = studentRepository.save(student);
	            studentResponseDTO = ValueMapper.convertToDTO(studentResults);  
			} catch (Exception ex) {		            
	            throw new ServiceBusinessException("Exception occurred while create a new student.");
	        }  
		}
		else
			throw new NotFoundException("The username had been registered by another student."); 
        return studentResponseDTO;
	}	

	@Override
	public StudentResponseDTO getStudentByUserName(String username) {
		StudentResponseDTO studentResponseDTO;        
        try {        	
            Student student = studentRepository.findOneByUserName(username)
                    .orElseThrow(() -> new NotFoundException("Student not found with username " + username));
            studentResponseDTO = ValueMapper.convertToDTO(student);           

        } catch (Exception ex) {            
            throw new ServiceBusinessException("Exception occurred while fetch student from Database column username " + username);
        }
        return studentResponseDTO;
	}

	@Override
	@Transactional
	public StudentResponseDTO modifyStudent(String username,StudentRequestUpdateDTO studentRequestUpdateDTO) {
		// TODO Auto-generated method stub
		StudentResponseDTO studentResponseDTO;
		Student student = studentRepository.findOneByUserName(username)
				.orElseThrow(() -> new NotFoundException("Student not found with username " + username));
		try {
			student.setBirthDate(studentRequestUpdateDTO.getBirthDate());
			student.setGender(studentRequestUpdateDTO.getGender());
			student.setAddress(studentRequestUpdateDTO.getAddress());
			student.setPhoneNumber(studentRequestUpdateDTO.getPhoneNumber());
			student.setLanguage(studentRequestUpdateDTO.getLanguage());
			student.setEducationLevel(studentRequestUpdateDTO.getEducationLevel());
            Student studentResults = studentRepository.save(student);
            studentResponseDTO = ValueMapper.convertToDTO(studentResults);            

        } catch (Exception ex) {
            
            throw new ServiceBusinessException("Exception occurred while update a student");
        }        
        return studentResponseDTO;
	}	

}
