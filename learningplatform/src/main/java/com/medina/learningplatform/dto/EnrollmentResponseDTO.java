package com.medina.learningplatform.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentResponseDTO {
	
	private Integer id;
	private Integer idStudent;
	private Integer idCourse;
	private Date enrollmentDate;
	private Boolean isCancelled;
	private String cancellationReason;
}
