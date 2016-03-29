package com.extrimityindia.app.serviceimpl;
import com.extrimityindia.app.dao.StudentDao;
import com.extrimityindia.app.daoimp.StudentdaoImpl;
import com.extrimityindia.app.model.Batch;
import com.extrimityindia.app.model.Course;
import com.extrimityindia.app.model.Faculty;
import com.extrimityindia.app.model.Student;
import com.extrimityindia.app.service.Studentservice;

public class Studentserviceimpl implements Studentservice {

	
	StudentDao studdao=new StudentdaoImpl();
	@Override
	
	
	//================= Course Service Methods ======================================
	public void servicecourse(Course course) {
		
	studdao.insertcoursedata(course);
		
		
	}
	public void serviceupdatecourse(Course course_update) {
		// TODO Auto-generated method stub
		
		//System.out.println(course.getUpdatecorname());
		studdao.updatecoursedata(course_update);
	}
	
	@Override
	public void servicecoursedelete(int delete) {
		// TODO Auto-generated method stub
		studdao.deletecoursedata(delete);
	}
	
	@Override
	public void servicecoursesearch(int search) {
		// TODO Auto-generated method stub
		studdao.searchcoursedata(search);;
	}
	
	
	
	
	
//=================faculty service===========================	
	@Override
		public void serviceinsertfaculty(Faculty fac_insert) 
	{
		// TODO Auto-generated method stub
		studdao.insertfacultydata(fac_insert);
	}
	
	public void serviceupdatefaculty(Faculty fac_update) {
		// TODO Auto-generated method stub
		studdao.updatefacultydata(fac_update);
	}
	public void servicefacultydelete(int delete) {
		// TODO Auto-generated method stub
		studdao.deletefacultydata(delete);
	}
	@Override
	public void servicefacultysearch(int search) {
		// TODO Auto-generated method stub
		studdao.searchfacultydata(search);
	}
	
	
	//==============Batch service implementation=======================
	
	//}@Override
	public void serviceinputbatch(Batch batch) {
		// TODO Auto-generated method stub
		studdao.insertbatchdata(batch);
	}
	@Override
	public void serviceupdatebatch(Batch bat_update) {
		// TODO Auto-generated method stub
		studdao.updatebatchdata(bat_update);
	}
	@Override
	public void servicedeletebatch(int delete) {
		// TODO Auto-generated method stub
		studdao.deletebatchdata(delete);
	}
	@Override
	public void servicebatchsearch(int search) {
		// TODO Auto-generated method stub
		studdao.searchbatchdata(search);
	}
	
	///=================Student service Implementation==============
	@Override
	public void serviceinputstudent(Student stud_insert) {
		// TODO Auto-generated method stub
		studdao.insertstudentdata(stud_insert);
	}
	public void serviceupdatebatch(Student stud_update) {
		// TODO Auto-generated method stub
		studdao.updatestudentdata(stud_update);
	}
	public void servicedeletestudent(int delete) {
		// TODO Auto-generated method stub
		studdao.deletestudentdata(delete);
	}
	public void servicestudentsearch(int search) {
		// TODO Auto-generated method stub
		studdao.searchstudentdata(search);
	}
	
	
		// TODO Auto-generated method stub
		
	
	
	
	/*@Override
	public void servicebatch(Batch batch) {
		// TODO Auto-generated method stub
		
	}@Override
	public void servicestudent(Student student) {
		// TODO Auto-generated method stub
		studdao.
	}
	
*/
}
