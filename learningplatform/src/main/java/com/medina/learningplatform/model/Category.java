package com.medina.learningplatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCategory")
	private Integer id;
	
	@Column(name="categoryDescription")
	private String categoryDescription;
}
