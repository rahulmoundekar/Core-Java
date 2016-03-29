package manytomany;

import java.util.List;


/**
 * @author Extremity
 */
public class Course implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer courseId;
	private String courseName;
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
