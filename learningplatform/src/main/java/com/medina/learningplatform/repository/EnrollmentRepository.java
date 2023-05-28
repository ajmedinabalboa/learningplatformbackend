package com.medina.learningplatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medina.learningplatform.model.Course;
import com.medina.learningplatform.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
	Optional<Enrollment> findOneByIdStudentAndIdCourse(int idStudent,int idCourse);
	
	@Query(value = "SELECT e.course FROM Enrollment e INNER JOIN e.course WHERE e.isCancelled = false AND e.idStudent = ?1")
	List<Course> findAllCoursesByIdStudent(int id);
}
