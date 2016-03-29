package com.cjc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cjc.dao.BatchDao;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.utility.JdbcUtil;

public class BatchDaoImpl implements BatchDao {

	@Override
	public void insertBatch(ArrayList<Batch> batches) throws SQLException {
		Integer result = 0;
		for (Batch batch : batches) {
			result = JdbcUtil.runQuery("insert into batch values('"
					+ batch.getBatchId() + "','" + batch.getBatchName() + "','"
					+ batch.getFaculty().getFacultyId() + "')");
		}
		if (result > 0)
			System.out.println("Batch Save Successfully...!!");
		else
			System.out.println("Something wrong Save Batch");
	}

	@Override
	public HashMap<Integer, Batch> displayBatch() throws SQLException {
		HashMap<Integer, Batch> batchs = new HashMap<Integer, Batch>();

		ResultSet rs = JdbcUtil
				.getResultSet("select batch_id,batch_name,faculty_name,course_name from batch b,faculty f,course c where b.faculty_id=f.faculty_id and c.course_id=f.course_id;");
		while (rs.next()) {
			Batch batch = new Batch();
			batch.setBatchId(rs.getInt(1));
			batch.setBatchName(rs.getString(2));

			Faculty faculty = new Faculty();
			faculty.setFacultyName(rs.getString(3));
			batch.setFaculty(faculty);

			Course course = new Course();
			course.setCourseName(rs.getString(4));
			faculty.setCourse(course);

			batchs.put(rs.getInt(1), batch);
		}
		return batchs;
	}

	@Override
	public void deleteBatch(Integer bid) {
		try {
			Integer result = JdbcUtil
					.runQuery("delete from batch where batch_id='" + bid + "'");
			if (result > 0)
				System.out.println("Batch Delete Successfully...!!");
			else
				System.out.println("Something wrong Delete Batch");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
	}

	@Override
	public HashMap<Integer, Batch> searchFacultyIdWise(Integer batch_id) {
		HashMap<Integer, Batch> hm = new HashMap<Integer, Batch>();
		try {
			ResultSet rs = JdbcUtil
					.getResultSet("select batch_id, batch_name, faculty_name, course_name from batch b,faculty f,course c where b.faculty_id=f.faculty_id and f.course_id=c.course_id and batch_id="
							+ batch_id + "");
			while (rs.next()) {
				Batch batch = new Batch();
				batch.setBatchId(rs.getInt(1));
				batch.setBatchName(rs.getString(2));
				
				Faculty faculty = new Faculty();
				faculty.setFacultyName(rs.getString(3));
				batch.setFaculty(faculty);
				
				Course course=new Course();
				course.setCourseName(rs.getString(4));
				faculty.setCourse(course);
				
				hm.put(rs.getInt(1), batch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}
		return hm;
	}

}
