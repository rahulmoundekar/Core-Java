package com.extrimityindia.app.dao;

import java.util.ArrayList;


//import com.extrimityindia.app.daoimp.student;
import com.extrimityindia.app.model.Batch;
import com.extrimityindia.app.model.Course;
import com.extrimityindia.app.model.Faculty;
import com.extrimityindia.app.model.Student;

public interface StudentDao {
	
	//Course Methods
	
	void insertcoursedata(Course course) ;
	
	void updatecoursedata(Course course_update);
	
	public ArrayList retrievecoursedata();
	void deletecoursedata(int delete);
	
	//void deletecoursedata();
	
	void searchcoursedata(int search);
	
	//void retrievecoursedata();
	
	//faculty methods
	
	void insertfacultydata(Faculty fac_insert);
	
	void updatefacultydata(Faculty fac_update);
	
	void deletefacultydata(int delete);
	
	void searchfacultydata(int search);
	
	ArrayList retrievefacultydata() throws ClassNotFoundException;
	
	
	//batch Methods
	
	void insertbatchdata(Batch bat_insert);
	
	void updatebatchdata(Batch bat_update);
	
	void deletebatchdata(int delete);

	void searchbatchdata(int search);

	ArrayList retrievebatchdata() throws ClassNotFoundException;
	
	
	//Student Methods
	
	void insertstudentdata(Student stud_insert);

	
	void updatestudentdata(Student stud_update);
	
	public void deletestudentdata(int delete);
	//public void serviceinputstudent(Student stud_insert);
	
	ArrayList retrievestudentdata() throws ClassNotFoundException;

	void searchstudentdata(int search);

	
	

	


	

	

	
	

	

	
	 

}
