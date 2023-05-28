package com.medina.learningplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medina.learningplatform.dto.APIResponse;
import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.service.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {

	public static final String SUCCESS = "Success";
	private CourseService sourseService;
	
	@Autowired
	public CourseController(CourseService sourseService) {
		this.sourseService = sourseService;
	}
	
	@GetMapping("/available")
	public ResponseEntity<APIResponse> getAvailableCourses() {
        List<CourseResponseDTO> courses = sourseService.getAvailableCourses();
        //Builder Design pattern (to avoid complex object creation headache)
        APIResponse<List<CourseResponseDTO>> responseDTO = APIResponse
                .<List<CourseResponseDTO>>builder()
                .status(SUCCESS)
                .results(courses)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
}
