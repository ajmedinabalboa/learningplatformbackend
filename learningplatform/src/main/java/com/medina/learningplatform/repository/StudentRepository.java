package com.medina.learningplatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medina.learningplatform.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	Optional<Student> findOneByUserName(String username);
}
