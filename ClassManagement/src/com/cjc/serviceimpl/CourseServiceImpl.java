package com.cjc.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.CourseDao;
import com.cjc.daoimpl.CourseDaoImpl;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.service.CourseService;

public class CourseServiceImpl implements CourseService {

	CourseDao courseDao = new CourseDaoImpl();

	@Override
	public void addCourse(ArrayList<Course> courses) {
		courseDao.insertCourse(courses);
	}

	@Override
	public HashMap<Integer, Course> displayCourse() {
		return	courseDao.displayCourse();
	}

	@Override
	public void deleteCourse(Integer cid) {
		courseDao.deleteCourse(cid);
	}

	@Override
	public HashMap<Integer, Course> searchCourseIdWise(Integer course_id) {
		return courseDao.searchCourseIdWise(course_id);
	}

}
