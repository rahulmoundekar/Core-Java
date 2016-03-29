package com.cjc.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.FacultyDao;
import com.cjc.daoimpl.FacultyDaoImpl;
import com.cjc.model.Faculty;
import com.cjc.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

	FacultyDao facultyDao= new FacultyDaoImpl(); 
	
	@Override
	public void addFaculty(ArrayList<Faculty> faculties) {
		facultyDao.insertFaculty(faculties);
	}

	@Override
	public HashMap<Integer, Faculty> displayFaculty() throws SQLException {
		return facultyDao.displayFaculty();
	}

	@Override
	public void deleteFaculty(Integer fid) {
		facultyDao.deleteFaculty(fid);
	}

	@Override
	public HashMap<Integer, Faculty> searchFacultyIdWise(Integer faculty_id) {
		return facultyDao.searchFacultyIdWise(faculty_id);
	}

}
