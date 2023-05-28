package com.medina.learningplatform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medina.learningplatform.dto.APIResponse;
import com.medina.learningplatform.dto.CourseResponseDTO;
import com.medina.learningplatform.dto.EnrollmentRequestDTO;
import com.medina.learningplatform.dto.EnrollmentRequestUpdateDTO;
import com.medina.learningplatform.dto.EnrollmentResponseDTO;
import com.medina.learningplatform.service.EnrollmentService;

@RestController
@RequestMapping("api/enrollment")
public class EnrollmentController {
	
	public static final String SUCCESS = "Success";
	private EnrollmentService enrollmentService;
	
	@Autowired
	public EnrollmentController (EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse> createEnrollment(@RequestBody @Valid EnrollmentRequestDTO enrollmentRequestDTO){		
		EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.createEnrollment(enrollmentRequestDTO);
		APIResponse<EnrollmentResponseDTO> responseDTO = APIResponse
                .<EnrollmentResponseDTO>builder()
                .status(SUCCESS)
                .results(enrollmentResponseDTO)
                .build();
		
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/unsubscribe/{idStudent}/{idCourse}")
	public ResponseEntity<APIResponse> unsubscribeEnrollment(@PathVariable int idStudent,@PathVariable int idCourse,@RequestBody @Valid EnrollmentRequestUpdateDTO enrollmentRequestUpdateDTO){
		EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.unsubscribeEnrollment(idStudent,idCourse,enrollmentRequestUpdateDTO);
		APIResponse<EnrollmentResponseDTO> responseDTO = APIResponse
                .<EnrollmentResponseDTO>builder()
                .status(SUCCESS)
                .results(enrollmentResponseDTO)
                .build();
		
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<APIResponse> getCoursesByIdStudent(@PathVariable int id) {
        List<CourseResponseDTO> courses = enrollmentService.getCourseEnrollmentByIdStudent(id);
        //Builder Design pattern (to avoid complex object creation headache)
        APIResponse<List<CourseResponseDTO>> responseDTO = APIResponse
                .<List<CourseResponseDTO>>builder()
                .status(SUCCESS)
                .results(courses)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    } 

}
