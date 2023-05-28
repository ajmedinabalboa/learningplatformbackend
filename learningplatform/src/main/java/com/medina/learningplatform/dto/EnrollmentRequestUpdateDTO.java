package com.medina.learningplatform.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnrollmentRequestUpdateDTO {
	
	@NotBlank(message = "isCancelled shouldn't be NULL OR EMPTY")
	private Boolean isCancelled;
	
	@NotBlank(message = "cancellationReason shouldn't be NULL OR EMPTY")
	private String cancellationReason;
}
