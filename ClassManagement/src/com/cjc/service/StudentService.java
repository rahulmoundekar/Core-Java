package com.cjc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Faculty;
import com.cjc.model.Student;

public interface StudentService {
	void addStudent(ArrayList<Student> students);

	HashMap<Integer, Student> displayStudent();

	void deleteStudent(Integer sid);

	HashMap<Integer, Student> searchFacultyIdWise(Integer student_id);
}
