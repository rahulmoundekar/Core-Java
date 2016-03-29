package com.cjc.inputserver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.cjc.dao.BatchDao;
import com.cjc.dao.CourseDao;
import com.cjc.dao.FacultyDao;
import com.cjc.dao.StudentDao;
import com.cjc.daoimpl.BatchDaoImpl;
import com.cjc.daoimpl.CourseDaoImpl;
import com.cjc.daoimpl.FacultyDaoImpl;
import com.cjc.daoimpl.StudentDaoImpl;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.model.Student;
import com.cjc.utility.Utility;

public class ConsoleInput {
	ArrayList<Course> alcourse = new ArrayList<Course>();
	ArrayList<Faculty> alfaculty = new ArrayList<Faculty>();
	ArrayList<Batch> alBatch = new ArrayList<Batch>();
	ArrayList<Student> alStudent = new ArrayList<Student>();

	CourseDao courseDao = new CourseDaoImpl();
	FacultyDao facultyDao = new FacultyDaoImpl();
	BatchDao batchDao = new BatchDaoImpl();
	StudentDao studentDao = new StudentDaoImpl();

	public ArrayList<Course> inputCourse() {

		System.out.println("Enter How Many Course do you want to Add : ");
		int noOfCourse = Utility.scanner.nextInt();
		for (int i = 0; i < noOfCourse; i++) {
			Course course = new Course();
			System.out.println("Enter course id ");
			course.setCourseId(Utility.scanner.nextInt());

			System.out.println("Enter Course Name");
			course.setCourseName(Utility.scanner.next());

			alcourse.add(course);

		}
		return alcourse;
	}

	public void displayCourse(HashMap<Integer, Course> hm) {
		System.out.println("|==============================|");
		System.out.println("|Course Information");
		System.out.println("|==============================|");
		System.out.println("|Course Id\t" + "|" + "Course Name|\t");
		System.out.println("|==============================|");
		Set<Integer> s = hm.keySet();

		Iterator<Integer> itr = s.iterator();

		while (itr.hasNext()) {

			int cid = (Integer) itr.next();
			System.out.print("|" + cid + "\t\t");

			Course c = hm.get(cid);
			System.out.println("|" + c.getCourseName() + "\t\t|");
			System.out.println("|==============================|");
		}

	}

	public ArrayList<Faculty> inputFaculty() {
		System.out.println("Enter how many Faculty do you want to Add");
		int noOfFaculty = Utility.scanner.nextInt();
		for (int i = 0; i < noOfFaculty; i++) {
			Faculty faculty = new Faculty();
			System.out.println("Enter Faculty id ");
			faculty.setFacultyId(Utility.scanner.nextInt());

			System.out.println("Enter Faculty Name");
			faculty.setFacultyName(Utility.scanner.next());

			HashMap<Integer, Course> hmCourse = courseDao.displayCourse();
			displayCourse(hmCourse);

			System.out.println("Select Given Course Id ");
			int cid = Utility.scanner.nextInt();

			HashMap<Integer, Course> hm = courseDao.displayCourse();
			Course c = (Course) hm.get(cid);

			faculty.setCourse(c);

			alfaculty.add(faculty);
		}
		return alfaculty;
	}

	public void displayFaculty(HashMap<Integer, Faculty> facultyMap) {
		System.out
				.println("|========================================================|");
		System.out
				.println("|                   Faculty Information                  |");
		System.out
				.println("|========================================================|");
		System.out.println("|faculty Id\t" + "|" + "faculty Name\t\t" + "|"
				+ "Course Name     |");
		System.out
				.println("|========================================================|");

		Set<Integer> s = facultyMap.keySet();
		Iterator<Integer> itr = s.iterator();
		while (itr.hasNext()) {
			int fid = itr.next();
			Faculty faculty = facultyMap.get(fid);
			Course c = faculty.getCourse();
			System.out.println("|" + fid + "\t\t|" + faculty.getFacultyName()
					+ "  \t\t\t|" + c.getCourseName());
		}
		System.out
				.println("|========================================================|");
	}

	public ArrayList<Batch> inputBatch() throws SQLException {

		System.out.println("Enter how many Batch do you want to Add");
		int id = Utility.scanner.nextInt();
		for (int i = 0; i < id; i++) {
			Batch batch = new Batch();
			System.out.println("Enter Batch id ");
			batch.setBatchId(Utility.scanner.nextInt());

			System.out.println("Enter Batch Name");
			batch.setBatchName(Utility.scanner.next());

			HashMap<Integer, Faculty> hmfaculty = facultyDao.displayFaculty();
			displayFaculty(hmfaculty);
			System.out.println("Select Given Faculty Id");
			int fid = Utility.scanner.nextInt();

			HashMap<Integer, Faculty> hm = facultyDao.displayFaculty();
			Faculty f = (Faculty) hm.get(fid);

			batch.setFaculty(f);

			alBatch.add(batch);
		}

		return alBatch;
	}

	public void displayBatch(HashMap<Integer, Batch> batchMap) {
		System.out
				.println("|==========================================================================================================|");
		System.out
				.println("|                                        Batch Information                                                 |");
		System.out
				.println("|==========================================================================================================|");
		System.out.println("|Batch Id\t" + "|" + "Batch Name\t\t" + "|"
				+ "faculty Name\t\t" + "|"
				+ "Course Name                                |");
		System.out
				.println("|==========================================================================================================|");

		Set<Integer> s = batchMap.keySet();
		Iterator<Integer> itr = s.iterator();
		while (itr.hasNext()) {
			int bid = itr.next();
			Batch batch = batchMap.get(bid);

			Faculty faculty = batch.getFaculty();
			Course course = faculty.getCourse();
			System.out.println("|" + bid + "\t\t|" + batch.getBatchName()
					+ "\t\t|" + faculty.getFacultyName() + "\t\t\t\t|"
					+ course.getCourseName() + "\t\t\t\t\t\t\t|");

		}
		System.out
				.println("|==========================================================================================================|");

	}

	public ArrayList<Student> inputStudent() throws SQLException {
		System.out.println("Enter how many Student do you want to Add");
		int id = Utility.scanner.nextInt();
		for (int i = 0; i < id; i++) {
			Student student = new Student();
			System.out.println("Enter Student id ");
			student.setStudentId(Utility.scanner.nextInt());

			System.out.println("Enter Student Name");
			student.setStudentName(Utility.scanner.next());

			HashMap<Integer, Batch> bd = batchDao.displayBatch();
			displayBatch(bd);
			System.out.println("select given Batch Id");
			int bid = Utility.scanner.nextInt();

			HashMap<Integer, Batch> hm = batchDao.displayBatch();
			Batch batch = hm.get(bid);
			student.setBatch(batch);

			alStudent.add(student);
		}
		return alStudent;
	}

	public void displayStudent(HashMap<Integer, Student> StudentMap) {
		System.out
				.println("|=====================================================================================================================================|");
		System.out
				.println("|                                                         Student Information                                                         |");
		System.out
				.println("|=====================================================================================================================================|");
		System.out.println("|Student Id\t\t" + "|" + "Student Name\t\t" + "|"
				+ "Batch Name\t\t" + "|" + "faculty Name\t\t" + "|"
				+ "Course Name  |");
		System.out
				.println("|=====================================================================================================================================|");

		Set<Integer> s = StudentMap.keySet();
		Iterator<Integer> itr = s.iterator();
		while (itr.hasNext()) {
			int sid = itr.next();
			Student student = StudentMap.get(sid);
			Batch batch = student.getBatch();
			Faculty faculty = batch.getFaculty();
			Course course = faculty.getCourse();

			System.out.println("|" + sid + "\t\t\t|" + student.getStudentName()
					+ "\t\t\t|" + batch.getBatchName() + "\t\t|"
					+ faculty.getFacultyName() + "\t\t|"
					+ course.getCourseName() + "\t\t\t\t|");

		}
		System.out
				.println("|=====================================================================================================================================|");
	}

	// Delete Methods following

	public Integer inputDeleteCourse() {
		HashMap<Integer, Course> hmCourse = courseDao.displayCourse();
		displayCourse(hmCourse);

		System.out.println("Enter Which Course You Want Delete : ");
		int inputCourse = Utility.scanner.nextInt();

		System.out.println(inputCourse);
		return inputCourse;
	}

	public Integer inputDeleteFaculty() throws SQLException {
		HashMap<Integer, Faculty> hmfaculty = facultyDao.displayFaculty();
		displayFaculty(hmfaculty);
		System.out.println("Enter Which Faculty You Want Delete : ");
		int inputFaculty = Utility.scanner.nextInt();
		return inputFaculty;
	}

	public Integer inputDeleteBatch() throws SQLException {
		HashMap<Integer, Batch> bd = batchDao.displayBatch();
		displayBatch(bd);
		System.out.println("Enter Which Batch You Want Delete : ");
		int inputBatch = Utility.scanner.nextInt();
		return inputBatch;
	}

	public Integer inputDeleteStudent() {
		HashMap<Integer, Student> studentMap = studentDao.displayStudent();
		displayStudent(studentMap);
		System.out.println("Enter Which Student You Want Delete : ");
		int inputStudent = Utility.scanner.nextInt();
		return inputStudent;
	}

	public Integer searchInputCourse() {
		System.out.println("Enter Which Course You Want Search : ");
		Integer course_id = Utility.scanner.nextInt();
		return course_id;
	}

	public Integer searchInputFaculty() {
		System.out.println("Enter Which Faculty You Want Search : ");
		Integer faculty_id = Utility.scanner.nextInt();
		return faculty_id;
	}

	public Integer searchInputBatch() {
		System.out.println("Enter Which Batch You Want Search : ");
		Integer batch_id = Utility.scanner.nextInt();
		return batch_id;
	}

	public Integer searchInputStudent() {
		System.out.println("Enter Which Student You Want Search : ");
		Integer student_id = Utility.scanner.nextInt();
		return student_id;
	}

}
