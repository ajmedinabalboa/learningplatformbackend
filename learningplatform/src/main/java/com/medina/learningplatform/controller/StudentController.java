package com.medina.learningplatform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medina.learningplatform.dto.APIResponse;
import com.medina.learningplatform.dto.AuthCredentials;
import com.medina.learningplatform.dto.StudentRequestDTO;
import com.medina.learningplatform.dto.StudentRequestUpdateDTO;
import com.medina.learningplatform.dto.StudentResponseDTO;
import com.medina.learningplatform.model.Student;
import com.medina.learningplatform.service.StudentService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/student")
public class StudentController {	
	
	public static final String SUCCESS = "Success";
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/{username}")
    public ResponseEntity<?> getStudent(@PathVariable String username) {

		StudentResponseDTO studentResponseDTO = studentService.getStudentByUserName(username);
        APIResponse<StudentResponseDTO> responseDTO = APIResponse
                .<StudentResponseDTO>builder()
                .status(SUCCESS)
                .results(studentResponseDTO)
                .build();        

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse> createStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO){
		StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequestDTO);
		APIResponse<StudentResponseDTO> responseDTO = APIResponse
                .<StudentResponseDTO>builder()
                .status(SUCCESS)
                .results(studentResponseDTO)
                .build();
		
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{username}")
	public ResponseEntity<APIResponse> updateProfileStudent(@PathVariable String username,@RequestBody @Valid StudentRequestUpdateDTO studentRequestUpdateDTO){
		StudentResponseDTO studentResponseDTO = studentService.modifyStudent(username,studentRequestUpdateDTO);
		APIResponse<StudentResponseDTO> responseDTO = APIResponse
                .<StudentResponseDTO>builder()
                .status(SUCCESS)
                .results(studentResponseDTO)
                .build();
		
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
}
