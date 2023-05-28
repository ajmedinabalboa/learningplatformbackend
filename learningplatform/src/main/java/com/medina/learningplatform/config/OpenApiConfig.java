package com.medina.learningplatform.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Alvaro Medina",
						email = "alvaro.medina.developer@gmail.com"
				),
				description = "OpenApi documentacion for Learning Platform",
				title = "OpenApi Specification - Learning Platform",
				version = "1.0",
				license = @License(
						name = "License by Alvaro Medina - 2023",
						url = "http://alvaro.medina.developer.com"
				),
				termsOfService = "Terms of Service"
		),
		servers = {
				@Server(
						description = "Local Env",
						url = "http://localhost:8080"
				)
		}
)

public class OpenApiConfig {

}
