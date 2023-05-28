package com.medina.learningplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Students", schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idStudent")
	private Integer id;
	
	@Column(name="fullName")
	private String fullName;
		
	@Column(name="birthDate")
	private Date birthDate;
		
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="dataCreated")
	private Date dataCreated;
	
	@Column(name="lastLogin")
	private Date lastLogin;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="country")
	private String country;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="language")
	private String language;
	
	@Column(name="educationLevel")
	private String educationLevel;

}
