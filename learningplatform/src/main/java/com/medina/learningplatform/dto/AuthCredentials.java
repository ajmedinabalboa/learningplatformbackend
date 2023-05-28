package com.medina.learningplatform.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthCredentials {
	private String username;
	private String password;
}
