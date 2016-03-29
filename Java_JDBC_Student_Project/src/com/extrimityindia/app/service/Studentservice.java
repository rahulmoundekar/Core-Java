package com.extrimityindia.app.service;

import com.extrimityindia.app.model.Batch;
import com.extrimityindia.app.model.Course;
import com.extrimityindia.app.model.Faculty;
import com.extrimityindia.app.model.Student;

public interface Studentservice {
	
	void servicecourse(Course course);
	
	void serviceupdatecourse(Course course_update);
	
	void servicecoursedelete(int delete);

	void servicecoursesearch(int search);
	
	
	//==================Faculty service methods================================
	
	void serviceinsertfaculty(Faculty fac_insert);
	
	void serviceupdatefaculty(Faculty fac_update);
	
	public void servicefacultydelete(int delete);
	
	void servicefacultysearch(int search);
	
	
	///================Batch service methdods=============
	void serviceinputbatch(Batch batch);

	void serviceupdatebatch(Batch bat_update);
	
	void servicedeletebatch(int delete);
	
	void servicebatchsearch(int search);
	
	//==================Student service methods===========
//	void servicestudent(Student student);

	void serviceinputstudent(Student stud_insert);

	
	
	//void servicefaculty(Faculty faculty);

	//void servicecourse(int delete);

	
}
