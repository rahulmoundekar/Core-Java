package com.extrimityindia.app.model;

public class Student {

	private int rollno;
	private String sname;
	private String scity;
	private Batch bat;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public Batch getBat() {
		return bat;
	}
	public void setBat(Batch bat) {
		this.bat = bat;
	}

}
