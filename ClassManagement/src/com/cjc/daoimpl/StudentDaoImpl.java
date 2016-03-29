package com.cjc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.StudentDao;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.model.Student;
import com.cjc.utility.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void insertStudent(ArrayList<Student> students) {
		Integer result = 0;
		try {
			for (Student student : students) {
				result = JdbcUtil.runQuery("insert into student values('"
						+ student.getStudentId() + "','"
						+ student.getStudentName() + "','"
						+ student.getBatch().getBatchId() + "')");
			}
			if (result > 0)
				System.out.println("Students Save Successfully...!!");
			else
				System.out.println("Something wrong Save Student");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public HashMap<Integer, Student> displayStudent() {
		HashMap<Integer, Student> batchs = new HashMap<Integer, Student>();
		ResultSet rs = null;
		try {
			rs = JdbcUtil
					.getResultSet(" select student_id,student_name ,batch_name,faculty_name,course_name from student s, batch b,faculty f,course c where s.batch_id=b.batch_id and b.faculty_id=f.faculty_id and c.course_id=f.course_id");

			while (rs.next()) {

				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));

				Batch batch = new Batch();
				batch.setBatchName(rs.getString(3));
				student.setBatch(batch);

				Faculty faculty = new Faculty();
				faculty.setFacultyName(rs.getString(4));
				batch.setFaculty(faculty);

				Course course = new Course();
				course.setCourseName(rs.getString(5));
				faculty.setCourse(course);

				batchs.put(rs.getInt(1), student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}

		return batchs;
	}

	@Override
	public void deleteStudent(Integer sid) {
		try {
			Integer result = JdbcUtil
					.runQuery("delete from student where student_id='" + sid
							+ "'");
			if (result > 0)
				System.out.println("student Delete Successfully...!!");
			else
				System.out.println("Something wrong Delete student");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public HashMap<Integer, Student> searchFacultyIdWise(Integer student_id) {
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
		try {
			ResultSet rs = JdbcUtil
					.getResultSet("select student_id,student_name,batch_name, faculty_name, course_name from student s,batch b, faculty f,course c where s.batch_id=b.batch_id and b.faculty_id=f.faculty_id and f.course_id=c.course_id and student_id="
							+ student_id + "");
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));
				
				Batch batch = new Batch();
				batch.setBatchName(rs.getString(3));
				student.setBatch(batch);
				
				Faculty faculty = new Faculty();
				faculty.setFacultyName(rs.getString(4));
				batch.setFaculty(faculty);
				
				Course course = new Course();
				course.setCourseName(rs.getString(5));
				faculty.setCourse(course);
				
				hm.put(rs.getInt(1), student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
		return hm;
	}

}
//