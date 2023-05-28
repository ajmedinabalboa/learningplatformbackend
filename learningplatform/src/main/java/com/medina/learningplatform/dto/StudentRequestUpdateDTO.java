package com.medina.learningplatform.dto;

import java.util.Date;

import lombok.Data;

@Data
public class StudentRequestUpdateDTO {
	
	private Date birthDate;	
	private String gender;	
	private String phoneNumber;	
	private String address;
	private String language;
	private String educationLevel;
	
}
