package com.cjc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Faculty;

public interface FacultyDao {
	void insertFaculty(ArrayList<Faculty> faculties);

	HashMap<Integer, Faculty> displayFaculty() throws SQLException;

	void deleteFaculty(Integer fid);

	HashMap<Integer, Faculty> searchFacultyIdWise(Integer faculty_id);
}
