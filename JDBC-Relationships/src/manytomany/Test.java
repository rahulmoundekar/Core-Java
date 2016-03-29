package manytomany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setStudentId(101);
		student1.setStudentName("Rahul");

		Student student2 = new Student();
		student2.setStudentId(102);
		student2.setStudentName("Mahesh");

		List<Student> students1=new ArrayList<Student>();
			students1.add(student1);
			
		List<Student> students = new ArrayList<Student>();
			students.add(student2);
			students.add(student1);
			
		/*
		 * ======================================================================
		 * ===========
		 */
		Course course1 = new Course();
		course1.setCourseId(1);
		course1.setCourseName("Java");

		Course course2 = new Course();
		course2.setCourseId(2);
		course2.setCourseName("cpp");

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		List<Course> coursess = new ArrayList<Course>();
		coursess.add(course2);

		student1.setCourses(courses);
		course1.setStudents(students1);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databaserelationships",
					"root", "root");

			Statement statement = connection.createStatement();
			/*
			 * ==================================Save Student and
			 * Course===========================================================
			 */
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) {
				Student student = (Student) iterator.next();
				String studentsql = "insert into student values("
						+ student.getStudentId() + ",'"
						+ student.getStudentName() + "')";
				statement.execute(studentsql);
			}

			Iterator<Course> it = courses.iterator();
			while (it.hasNext()) {
				Course course = (Course) it.next();
				String coursesql = "insert into course values("
						+ course.getCourseId() + ",'" + course.getCourseName()
						+ "')";
				statement.execute(coursesql);
			}

			/*
			 * =========================================End======================
			 * ===================================================
			 */
			int i = 0;
			List<Course> list = student1.getCourses();
			Iterator<Course> itr = list.iterator();
			while (itr.hasNext()) {
				Course course = (Course) itr.next();
				List<Student> list1 = course.getStudents();
				Iterator<Student> itr1 = list1.iterator();
				while (itr1.hasNext()) {
					Student student = (Student) itr1.next();
					String cou_stud = "insert into course_student values("
							+ i++ + ",'" + student.getStudentId() + "','"
							+ course.getCourseId() + "')";
					statement.execute(cou_stud);
				}

			}

			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

	}

}
