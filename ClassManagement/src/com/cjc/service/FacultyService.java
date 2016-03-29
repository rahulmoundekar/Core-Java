package com.cjc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Course;
import com.cjc.model.Faculty;

public interface FacultyService {
	void addFaculty(ArrayList<Faculty> faculties);

	HashMap<Integer, Faculty> displayFaculty() throws SQLException;

	void deleteFaculty(Integer fid);

	HashMap<Integer, Faculty> searchFacultyIdWise(Integer faculty_id);
}
