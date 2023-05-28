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
public class CourseResponseDTO {
	
	private Integer id;
	private Integer idCategory;
	private String courseDescription;
	private String abstractDescription;
	private String author;
	private Date startDate;
	private Date endDate;
	private String rate;	
	private String attendance;
	private String totalHours;
}
