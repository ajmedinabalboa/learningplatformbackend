package com.medina.learningplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "Enrollments", schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEnrollment")
	private Integer id;
	
	@Column(name="idStudent")
	private Integer idStudent;
	
	@Column(nullable=false)
	private Integer idCourse;
	
	@OneToOne(optional=false)
    @JoinColumn(name="idCourse",referencedColumnName="idCourse", insertable=false, updatable=false)
	private Course course;
	
	@Column(name="enrollmentDate")
	private Date enrollmentDate;
	
	@Column(name="isCancelled")
	private Boolean isCancelled;
	
	@Column(name="cancellationReason")
	private String cancellationReason;

}
