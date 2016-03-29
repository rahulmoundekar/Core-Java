package com.cjc.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.StudentDao;
import com.cjc.daoimpl.StudentDaoImpl;
import com.cjc.model.Student;
import com.cjc.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao studentDao=new StudentDaoImpl(); 
	
	@Override
	public void addStudent(ArrayList<Student> students) {
		studentDao.insertStudent(students);
	}

	@Override
	public HashMap<Integer, Student> displayStudent() {
		return studentDao.displayStudent();
	}

	@Override
	public void deleteStudent(Integer sid) {
		studentDao.deleteStudent(sid);
	}

	@Override
	public HashMap<Integer, Student> searchFacultyIdWise(Integer student_id) {
		return studentDao.searchFacultyIdWise(student_id);
	}

}
