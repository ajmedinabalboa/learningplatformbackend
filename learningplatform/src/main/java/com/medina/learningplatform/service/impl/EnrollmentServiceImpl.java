package com.medina.learningplatform.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.dto.EnrollmentRequestDTO;
import com.medina.learningplatform.dto.EnrollmentRequestUpdateDTO;
import com.medina.learningplatform.dto.EnrollmentResponseDTO;
import com.medina.learningplatform.dto.StudentResponseDTO;
import com.medina.learningplatform.exception.NotFoundException;
import com.medina.learningplatform.exception.ServiceBusinessException;
import com.medina.learningplatform.model.Course;
import com.medina.learningplatform.model.Enrollment;
import com.medina.learningplatform.model.Student;
import com.medina.learningplatform.repository.EnrollmentRepository;
import com.medina.learningplatform.service.EnrollmentService;
import com.medina.learningplatform.utils.ValueMapper;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	@Transactional
	public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) throws ServiceBusinessException {
		// TODO Auto-generated method stub
		EnrollmentResponseDTO enrollmentResponseDTO = null;		    
		Optional<Enrollment> enrollmentPrevious = enrollmentRepository.findOneByIdStudentAndIdCourse(enrollmentRequestDTO.getIdStudent(),enrollmentRequestDTO.getIdCourse());
		if(enrollmentPrevious.isEmpty()) {
			try {
            Enrollment enrollment = ValueMapper.convertToEntity(enrollmentRequestDTO);
            Enrollment enrollmentResults = enrollmentRepository.save(enrollment);
            enrollmentResponseDTO = ValueMapper.convertToDTO(enrollmentResults);
			} catch (Exception ex) {            
	            throw new ServiceBusinessException("Exception occurred while create a new enrollment");
	        } 
		}
		else
			throw new NotFoundException("You already enrolled this course previously");               
        return enrollmentResponseDTO;
	}

	@Override
	@Transactional
	public EnrollmentResponseDTO unsubscribeEnrollment(int idStudent, int idCourse,EnrollmentRequestUpdateDTO enrollmentRequestUpdateDTO) throws ServiceBusinessException {
		// TODO Auto-generated method stub
		EnrollmentResponseDTO enrollmentResponseDTO;
		Enrollment enrollment = enrollmentRepository.findOneByIdStudentAndIdCourse(idStudent,idCourse)
				.orElseThrow(() -> new NotFoundException("enrollment not found with idStudent " + idStudent+" and idCourse "+idCourse));
		try {            
			
			enrollment.setIsCancelled(true);
			enrollment.setCancellationReason(enrollmentRequestUpdateDTO.getCancellationReason());
			Enrollment enrollmentResults = enrollmentRepository.save(enrollment);
            enrollmentResponseDTO = ValueMapper.convertToDTO(enrollmentResults);            

        } catch (Exception ex) {            
            throw new ServiceBusinessException("Exception occurred while unsubscribe process");
        }        
        return enrollmentResponseDTO;
	}

	@Override
	public List<CourseResponseDTO> getCourseEnrollmentByIdStudent(int id) {
		// TODO Auto-generated method stub
		List<CourseResponseDTO> courseResponseDTOS = null;

        try {           
            List<Course> courseList = enrollmentRepository.findAllCoursesByIdStudent(id);
            if (!courseList.isEmpty()) {
            	courseResponseDTOS = courseList.stream()
                        .map(ValueMapper::convertToDTO)
                        .collect(Collectors.toList());
            } else {
            	courseResponseDTOS = Collections.emptyList();
            }
        } catch (Exception ex) {            
            throw new ServiceBusinessException("Exception occurred while fetch all products from Database");
        }        
        return courseResponseDTOS;
	}

}
