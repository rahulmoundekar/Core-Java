package com.cjc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Student;

public interface StudentDao {
	void insertStudent(ArrayList<Student> students);

	HashMap<Integer, Student> displayStudent();

	void deleteStudent(Integer sid);

	HashMap<Integer, Student> searchFacultyIdWise(Integer student_id);
}
