package com.medina.learningplatform.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnrollmentRequestDTO {

	@NotBlank(message = "idStudent shouldn't be NULL OR EMPTY")
	private Integer idStudent;
	
	@NotBlank(message = "idCourse shouldn't be NULL OR EMPTY")
	private Integer idCourse;
	
	@NotBlank(message = "enrollmentDate shouldn't be NULL OR EMPTY")
	private Date enrollmentDate;
	
	@NotBlank(message = "isCancelled shouldn't be NULL OR EMPTY")
	private Boolean isCancelled;	
	
}
