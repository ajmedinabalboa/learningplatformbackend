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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Courses",schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCourse")
	private Integer id;
	
	@Column(name="idCategory")
	private Integer idCategory;
	
	@Column(name="courseDescription")
	private String courseDescription;
	
	@Column(name="abstract")
	private String abstractDescription;
	
	@Column(name="author")
	private String author;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="endDate")
	private Date endDate;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="attendance")
	private String attendance;
	
	@Column(name="totalHours")
	private String totalHours;
}
