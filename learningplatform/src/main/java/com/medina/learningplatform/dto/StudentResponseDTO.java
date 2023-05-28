package com.medina.learningplatform.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDTO {
	
	private Integer id;	
	private String fullName;
	private Date birthDate;
	private String phoneNumber;
	private Date dataCreated;
	private Date lastLogin;
	private String userName;
	private String country;
	private String gender;
	private String address;
	private String language;
	private String educationLevel;	
	
}
