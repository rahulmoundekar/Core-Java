package com.cjc.model;


/**
 * @author Extremity
 */
public class Student implements java.io.Serializable {

	private Integer studentId;
	private Batch batch;
	private String studentName;

	public Student() {
	}

	public Student(Batch batch, String studentName) {
		this.batch = batch;
		this.studentName = studentName;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
