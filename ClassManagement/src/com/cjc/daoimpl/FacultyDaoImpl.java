package com.cjc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.FacultyDao;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.utility.JdbcUtil;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public void insertFaculty(ArrayList<Faculty> faculties) {
		Integer result = 0;
		try {
			for (Faculty faculty : faculties) {
				result = JdbcUtil.runQuery("insert into faculty values('"
						+ faculty.getFacultyId() + "','"
						+ faculty.getFacultyName() + "','"
						+ faculty.getCourse().getCourseId() + "')");
			}
			if (result > 0)
				System.out.println("Faculty Save Successfully...!!");
			else
				System.out.println("Something wrong Save Faculty");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<Integer, Faculty> displayFaculty() throws SQLException {
		HashMap<Integer, Faculty> faculties = new HashMap<Integer, Faculty>();
		ResultSet rs = JdbcUtil
				.getResultSet("select * from  faculty f, course c where c.course_id=f.course_id");
		while (rs.next()) {
			Faculty faculty = new Faculty();

			faculty.setFacultyId(rs.getInt(1));
			faculty.setFacultyName(rs.getString(2));

			Course course = new Course();
			course.setCourseId(rs.getInt(3));
			course.setCourseName(rs.getString(5));
			faculty.setCourse(course);

			faculties.put(rs.getInt(1), faculty);

		}
		return faculties;
	}

	@Override
	public void deleteFaculty(Integer fid) {
		try {
			Integer result = JdbcUtil
					.runQuery("delete from faculty where faculty_id='" + fid
							+ "'");
			if (result > 0)
				System.out.println("faculty Delete Successfully...!!");
			else
				System.out.println("Something wrong Delete faculty");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public HashMap<Integer, Faculty> searchFacultyIdWise(Integer faculty_id) {
		HashMap<Integer, Faculty> hm = new HashMap<Integer, Faculty>();
		try {
			ResultSet rs = JdbcUtil
					.getResultSet("select faculty_id,faculty_name, course_name from faculty f,course c where f.course_id=c.course_id and faculty_id="
							+ faculty_id + "");
			while (rs.next()) {
				Faculty faculty = new Faculty();
				faculty.setFacultyId(rs.getInt(1));
				faculty.setFacultyName(rs.getString(2));
				Course course=new Course();
				course.setCourseName(rs.getString(3));
				faculty.setCourse(course);
				hm.put(rs.getInt(1), faculty);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
		return hm;
	}

}
