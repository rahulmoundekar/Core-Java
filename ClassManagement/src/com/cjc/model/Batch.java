package com.cjc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Extremity
 */
public class Batch implements java.io.Serializable {

	private Integer batchId;
	private Faculty faculty;
	private String batchName;
	private Set students = new HashSet(0);

	public Batch() {
	}

	public Batch(Faculty faculty, String batchName) {
		this.faculty = faculty;
		this.batchName = batchName;
	}

	public Batch(Faculty faculty, String batchName, Set students) {
		this.faculty = faculty;
		this.batchName = batchName;
		this.students = students;
	}

	public Integer getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getBatchName() {
		return this.batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}
