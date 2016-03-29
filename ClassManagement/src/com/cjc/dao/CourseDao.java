package com.cjc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Course;

public interface CourseDao {
	void insertCourse(ArrayList<Course> courses);
	HashMap<Integer, Course> displayCourse();
	void deleteCourse(Integer cid);
	HashMap<Integer, Course> searchCourseIdWise(Integer course_id);
}
