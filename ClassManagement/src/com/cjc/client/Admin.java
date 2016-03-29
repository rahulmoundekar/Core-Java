package com.cjc.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.cjc.inputserver.ConsoleInput;
import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.model.Student;
import com.cjc.service.BatchService;
import com.cjc.service.CourseService;
import com.cjc.service.FacultyService;
import com.cjc.service.StudentService;
import com.cjc.serviceimpl.BatchServiceImpl;
import com.cjc.serviceimpl.CourseServiceImpl;
import com.cjc.serviceimpl.FacultyServiceImpl;
import com.cjc.serviceimpl.StudentServiceImpl;
import com.cjc.utility.Utility;

public class Admin {

	Scanner sc = Utility.scanner;

	CourseService courseImpl = new CourseServiceImpl();
	FacultyService facultyImpl = new FacultyServiceImpl();
	BatchService batchImpl = new BatchServiceImpl();
	StudentService studentImpl = new StudentServiceImpl();

	ConsoleInput consoleInput = new ConsoleInput();

	void showMenu() throws SQLException {
		while (true) {
			System.out.println("\t---MENU--");
			System.out.println("\t1 Add Course");
			System.out.println("\t2 Add Faculty");
			System.out.println("\t3 Add Batch");
			System.out.println("\t4 Add Student");

			System.out.println("\t5 Display Course");
			System.out.println("\t6 Display Faculty");
			System.out.println("\t7 Display Batch");
			System.out.println("\t8 Display Student");

			System.out.println("\t9  Delete Course");
			System.out.println("\t10 Delete Faculty");
			System.out.println("\t11 Delete Batch");
			System.out.println("\t12 Delete Student");

			System.out.println("\t13 Search Course");
			System.out.println("\t14 Search Faculty");
			System.out.println("\t15 Search Batch");
			System.out.println("\t16 Search Student");

			System.out.println("\t24 Exit");
			System.out.println("Enter your choice::");
			int ch = 0;
			try {
				ch = sc.nextInt();
			} catch (Exception e) {
				ch = sc.nextInt();

			}
			switch (ch) {
			case 1:
				ArrayList<Course> courses = consoleInput.inputCourse();
				courseImpl.addCourse(courses);
				break;

			case 2:
				HashMap<Integer, Course> courseMap1 = courseImpl
						.displayCourse();
				if (!courseMap1.isEmpty()) {
					ArrayList<Faculty> faculties = consoleInput.inputFaculty();
					facultyImpl.addFaculty(faculties);
				} else
					System.out
							.println("First Insert Course to Assign Faculty... ");
				break;

			case 3:
				HashMap<Integer, Faculty> facultyMap1 = facultyImpl
						.displayFaculty();
				if (!facultyMap1.isEmpty()) {
					ArrayList<Batch> batchs = consoleInput.inputBatch();
					batchImpl.addBatch(batchs);
				} else
					System.out.println("First Insert Faculty to Assign Batch");
				break;

			case 4:
				HashMap<Integer, Batch> batchMap = batchImpl.displayBatch();
				if (!batchMap.isEmpty()) {
					ArrayList<Student> students = consoleInput.inputStudent();
					studentImpl.addStudent(students);
				} else
					System.out.println("First Insert Batch to Assign Student");
				break;
			// display here
			case 5:
				HashMap<Integer, Course> courseMap = courseImpl.displayCourse();
				consoleInput.displayCourse(courseMap);
				break;

			case 6:
				HashMap<Integer, Faculty> facultyMap = facultyImpl
						.displayFaculty();
				consoleInput.displayFaculty(facultyMap);
				break;

			case 7:
				HashMap<Integer, Batch> batchMap1 = batchImpl.displayBatch();
				consoleInput.displayBatch(batchMap1);
				break;

			case 8:
				HashMap<Integer, Student> studentMap = studentImpl
						.displayStudent();
				consoleInput.displayStudent(studentMap);
				break;

			case 9:
				Integer cid = consoleInput.inputDeleteCourse();
				courseImpl.deleteCourse(cid);
				break;

			case 10:
				Integer fid = consoleInput.inputDeleteFaculty();
				facultyImpl.deleteFaculty(fid);
				break;

			case 11:
				Integer bid = consoleInput.inputDeleteBatch();
				batchImpl.deleteBatch(bid);
				break;

			case 12:
				Integer sid = consoleInput.inputDeleteStudent();
				studentImpl.deleteStudent(sid);
				break;

			case 13:
				Integer course_id = consoleInput.searchInputCourse();
				HashMap<Integer, Course> searchCourseMap = courseImpl
						.searchCourseIdWise(course_id);
				if (!searchCourseMap.isEmpty())
					consoleInput.displayCourse(searchCourseMap);
				else
					System.err
							.println("You Enter Course Does not Found Try Again...!!! ");
				break;
			case 14:
				Integer faculty_id = consoleInput.searchInputFaculty();
				HashMap<Integer, Faculty> searchfacultyMap = facultyImpl
						.searchFacultyIdWise(faculty_id);
				if (!searchfacultyMap.isEmpty())
					consoleInput.displayFaculty(searchfacultyMap);
				else
					System.err
							.println("You Enter Faculty Does not Found Try Again...!!! ");
				break;
			case 15:
				Integer batch_id = consoleInput.searchInputBatch();
				HashMap<Integer, Batch> searchBatchMap = batchImpl
						.searchFacultyIdWise(batch_id);
				System.out.println(searchBatchMap);
				if (!searchBatchMap.isEmpty())
					consoleInput.displayBatch(searchBatchMap);
				else
					System.err
							.println("You Enter Batch Does not Found Try Again...!!! ");
				break;
			case 16:
				Integer student_id = consoleInput.searchInputStudent();
				HashMap<Integer, Student> searchStudentMap = studentImpl
						.searchFacultyIdWise(student_id);
				if (!searchStudentMap.isEmpty())
					consoleInput.displayStudent(searchStudentMap);
				else
					System.err
							.println("You Enter Student Does not Found Try Again...!!! ");
				break;
			case 24:
				System.exit(0);
			}
			if (ch == 24)
				break;

		}

	}

	public static void main(String[] args) {
		Admin admin = new Admin();
		try {
			admin.showMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
