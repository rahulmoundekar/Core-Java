package com.extrimityindia.app.model;

public class Faculty {
private int fid;
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public Course getCors() {
	return cors;
}
public void setCors(Course cors) {
	this.cors = cors;
}
private String fname;
private Course cors;
}
