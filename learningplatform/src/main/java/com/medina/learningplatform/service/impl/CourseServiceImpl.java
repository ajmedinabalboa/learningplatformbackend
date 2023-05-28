package com.medina.learningplatform.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.exception.ServiceBusinessException;
import com.medina.learningplatform.model.Course;
import com.medina.learningplatform.repository.CourseRepository;
import com.medina.learningplatform.service.CourseService;
import com.medina.learningplatform.utils.ValueMapper;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<CourseResponseDTO> getAvailableCourses() throws ServiceBusinessException {
		// TODO Auto-generated method stub
		List<CourseResponseDTO> courseResponseDTOS = null;

        try {           
            List<Course> courseList = courseRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(ValueMapper.getLocalDateNow(),ValueMapper.getLocalDateNow());
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
