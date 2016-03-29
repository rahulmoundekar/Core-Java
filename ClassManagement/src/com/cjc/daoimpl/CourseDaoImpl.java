package com.cjc.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.CourseDao;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.utility.JdbcUtil;

public class CourseDaoImpl implements CourseDao {

	PreparedStatement ps = null;

	@Override
	public void insertCourse(ArrayList<Course> courses) {
		Integer result = 0;
		try {
			for (Course course : courses) {
				result = JdbcUtil.runQuery("insert into course values('"
						+ course.getCourseId() + "','" + course.getCourseName()
						+ "')");
			}
			if (result > 0)
				System.out.println("Courses Save Successfully...!!");
			else
				System.out.println("Something wrong Save Courses");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public HashMap<Integer,Course> displayCourse() {
		HashMap<Integer, Course> hm = new HashMap<Integer, Course>();
		try {
			ResultSet rs = JdbcUtil.getResultSet("select * from course");
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				hm.put(rs.getInt(1), course);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
		return hm;
	}

	@Override
	public void deleteCourse(Integer cid) {
			try {
				Integer result=JdbcUtil.runQuery("delete from course where course_id="+cid+"");
				if (result > 0)
					System.out.println("Course Delete Successfully...!!");
				else
					System.out.println("Something wrong Delete Course");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close();
			}
	}

	@Override
	public HashMap<Integer, Course> searchCourseIdWise(Integer course_id) {
		HashMap<Integer, Course> hm = new HashMap<Integer, Course>();
		try {
			ResultSet rs=JdbcUtil.getResultSet("select * from course where course_id="+course_id+"");
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				hm.put(rs.getInt(1), course);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
		
		return hm;
		
	}
}
