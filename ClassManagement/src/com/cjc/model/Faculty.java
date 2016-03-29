package com.cjc.model;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Extremity
 */
public class Faculty implements java.io.Serializable {

	private Integer facultyId;
	private Course course;
	private String facultyName;
	private Set batchs = new HashSet(0);

	public Faculty() {
	}

	public Faculty(Course course, String facultyName) {
		this.course = course;
		this.facultyName = facultyName;
	}

	public Faculty(Course course, String facultyName, Set batchs) {
		this.course = course;
		this.facultyName = facultyName;
		this.batchs = batchs;
	}

	public Integer getFacultyId() {
		return this.facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getFacultyName() {
		return this.facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public Set getBatchs() {
		return this.batchs;
	}

	public void setBatchs(Set batchs) {
		this.batchs = batchs;
	}

}
