package com.medina.learningplatform.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medina.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {
	List<Course> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date nowdatestart,Date nowdateend);
	
	
}
