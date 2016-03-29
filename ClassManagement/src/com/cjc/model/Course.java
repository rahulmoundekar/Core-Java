package com.cjc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Extremity
 */
public class Course implements java.io.Serializable {

	private Integer courseId;
	private String courseName;
	private Set faculties = new HashSet(0);

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName, Set faculties) {
		this.courseName = courseName;
		this.faculties = faculties;
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set getFaculties() {
		return this.faculties;
	}

	public void setFaculties(Set faculties) {
		this.faculties = faculties;
	}

}
