package com.medina.learningplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/**")
				.allowedHeaders("Access-Control-Allow-Origin",
			            "*",
			            "Access-Control-Allow-Methods",
			            "POST, GET, OPTIONS, PUT, DELETE",
			            "Access-Control-Allow-Headers",			            
			            "Origin, X-Requested-With, Content-Type, Accept, Authorization")				
				.allowedOrigins("http://localhost:4000")
				.allowedMethods("*");
			}
		};
	}
}
