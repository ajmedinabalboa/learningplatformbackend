package com.medina.learningplatform.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class StudentRequestDTO {	
	
	@NotBlank(message = "userName shouldn't be NULL OR EMPTY")
	private String userName;
	
	@NotBlank(message = "password shouldn't be NULL OR EMPTY")
	private String password;
	
	@NotBlank(message = "fullName shouldn't be NULL OR EMPTY")
	private String fullName;
	
	@NotBlank(message = "country shouldn't be NULL OR EMPTY")
	private String country;
		
}
