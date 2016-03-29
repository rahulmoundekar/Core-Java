package com.cjc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.model.Batch;
import com.cjc.model.Course;

public interface CourseService {
	void addCourse(ArrayList<Course> courses);
	HashMap<Integer, Course> displayCourse();
	void deleteCourse(Integer cid);
	HashMap<Integer, Course> searchCourseIdWise(Integer course_id);
	
}
