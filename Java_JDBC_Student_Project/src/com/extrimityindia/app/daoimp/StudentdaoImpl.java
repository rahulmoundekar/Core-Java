package com.extrimityindia.app.daoimp;

import com.extrimityindia.app.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.extrimityindia.app.dao.StudentDao;
import com.extrimityindia.app.model.Batch;
import com.extrimityindia.app.model.Course;
import com.extrimityindia.app.model.Faculty;
import com.extrimityindia.app.model.Student;
import com.extrimityindia.app.server.Inputdata;
import com.extrimityindia.app.util.*;

public class StudentdaoImpl implements StudentDao {
	Connection con;

	PreparedStatement ps = null;

	ResultSet rs;
	ArrayList corslist = new ArrayList();
	ArrayList faclist = new ArrayList();
	ArrayList batlist = new ArrayList();
	ArrayList studlist = new ArrayList();

	// Inputdata i=new Inputdata();

	// ===================================Course Dao
	// Methods=============================
	@Override
	public void insertcoursedata(Course course) {
		// TODO Auto-generated method stub

		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Insert into course values(?,?)");

			ps.setInt(1, course.getCorId());

			ps.setString(2, course.getCor());

			ps.execute();

			System.out.println("Course Data copied successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList retrievecoursedata() {
		// TODO Auto-generated method stub

		try {

			con = Conprovider.getConnection();

			ps = con.prepareStatement("Select * from course");
			rs = ps.executeQuery();

			while (rs.next()) {
				Course coss = new Course();

				coss.setCorId(rs.getInt(1));

				coss.setCor(rs.getString(2));
				corslist.add(coss);
				// System.out.println("retrive coss data"+coss);

			}
			// corslist.add(coss);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return corslist;
	}

	// ................................update dao
	// implementatopn.................................
	@Override
	public void updatecoursedata(Course course_update) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("UPDATE course  SET coursename =? WHERE courseid=?");

			ps.setInt(2, course_update.getUpdatecorid());
			// System.out.println();

			ps.setString(1, course_update.getUpdatecorname());
			// ps.execute();
			int i = ps.executeUpdate();

			System.out.println(i + " Data updated successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletecoursedata(int delete) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Delete from course where courseid=?");

			ps.setInt(1, delete);
			// ps.execute();
			int i = ps.executeUpdate();

			System.out.println(i + " Data Deleted successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void searchcoursedata(int search) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Select* from course where courseid=?");
			ps.setInt(1, search);
			// ps.execute();

			rs = ps.executeQuery();
			System.out.println("=========================");

			System.out.println("   COURSE_ID\tCOURSE NAME");

			System.out.println("=========================");
			while (rs.next()) {
				System.out
						.println("\t" + rs.getInt(1) + "\t" + rs.getString(2));
				System.out.println("-------------------------");
			}

			System.out.println(" Data Searched successfully\n\n");

			// System.out.println(rs.);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ===========================Faculty dao
	// Methods====================================

	@Override
	public void insertfacultydata(Faculty fac_insert) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Insert into facultyinfo values(?,?,?)");

			ps.setInt(1, fac_insert.getFid());

			ps.setString(2, fac_insert.getFname());

			ps.setLong(3, fac_insert.getCors().getCorId());

			// ps.setString(4, fac_insert.getCors().getCor());
			ps.execute();

			System.out.println("Faculty Data copied successffully\n\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// .................................Retreive faculty
	// data..........................

	public ArrayList retrievefacultydata() throws ClassNotFoundException {
		// TODO Auto-generated method stub

		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("select * from facultyinfo f,course c where c.courseid=f.courseid");

			rs = ps.executeQuery();

			while (rs.next()) {
				Faculty fac = new Faculty();

				fac.setFid(rs.getInt(1));

				fac.setFname(rs.getString(2));

				Course cos = new Course();

				cos.setCorId(rs.getInt(3));

				cos.setCor(rs.getString(5));

				fac.setCors(cos);

				faclist.add(fac);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return faclist;
	}

	@Override
	public void updatefacultydata(Faculty fac_update) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("UPDATE facultyinfo SET facultyname =? WHERE facultyid=?");

			ps.setInt(2, fac_update.getFid());

			ps.setString(1, fac_update.getFname());
			ps.execute();
			int i = ps.executeUpdate();

			System.out.println(i + " Data updated successffully\n\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletefacultydata(int delete) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Delete from facultyinfo where facultyid=?");

			ps.setInt(1, delete);

			int i = ps.executeUpdate();

			System.out.println(i + "Faculty Data Deleted successffully\n\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void searchfacultydata(int search) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Select* from facultyinfo where facultyid=?");
			ps.setInt(1, search);
			// ps.execute();

			rs = ps.executeQuery();
			System.out.println("Faculty ID\t" + "Faculty Name");
			while (rs.next()) {
				System.out
						.println("\t" + rs.getInt(1) + "\t" + rs.getString(2));
			}

			System.out.println("Faculty Data Searched successfully\n\n");

			// System.out.println(rs.);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertbatchdata(Batch bat_insert) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Insert into batchinfo values(?,?,?)");

			ps.setInt(1, bat_insert.getBid());

			ps.setString(2, bat_insert.getBname());

			ps.setLong(3, bat_insert.getFac().getFid());

			// ps.setString(4, fac_insert.getCors().getCor());
			ps.execute();

			System.out.println("Batch Data copied successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList retrievebatchdata() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("select * from batchinfo b,facultyinfo f,course c where b.facultyid=f.facultyid and f.courseid=c.courseid");

			rs = ps.executeQuery();

			while (rs.next()) {
				Batch bat = new Batch();

				bat.setBid(rs.getInt(1));

				bat.setBname(rs.getString(2));

				Faculty fac = new Faculty();

				fac.setFid(rs.getInt(4));

				fac.setFname(rs.getString(5));

				bat.setFac(fac);

				Course cos = new Course();

				cos.setCorId(rs.getInt(7));

				cos.setCor(rs.getString(8));

				fac.setCors(cos);

				batlist.add(bat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return batlist;
	}

	@Override
	public void updatebatchdata(Batch bat_update) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("UPDATE batchinfo SET batchname =? WHERE batchid=?");

			ps.setInt(2, bat_update.getBid());

			ps.setString(1, bat_update.getBname());
			ps.execute();
			int i = ps.executeUpdate();

			System.out.println(i + " Batch Data updated successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletebatchdata(int delete) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Delete from batchinfo where batchid=?");

			ps.setInt(1, delete);

			int i = ps.executeUpdate();

			System.out.println(i + "Batch Data Deleted successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void searchbatchdata(int search) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Select * from batchinfo where batchid=?");
			ps.setInt(1, search);
			// ps.execute();

			rs = ps.executeQuery();
			System.out
					.println("===================================================");
			System.out.println("Batch ID\t" + "Batch Name");
			System.out
					.println("===================================================");
			while (rs.next()) {
				System.out
						.println("\t" + rs.getInt(1) + "\t" + rs.getString(2));
				System.out
						.println("-----------------------------------------------");
			}

			System.out.println("Faculty Data Searched successfully");

			// System.out.println(rs.);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// //===============================Student dao
	// Implemetation=============================

	public void insertstudentdata(Student stud_insert) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Insert into studentinfo values(?,?,?,?)");

			ps.setInt(1, stud_insert.getRollno());

			ps.setString(2, stud_insert.getSname());

			ps.setString(3, stud_insert.getScity());

			ps.setLong(4, stud_insert.getBat().getBid());

			// ps.setString(4, fac_insert.getCors().getCor());
			ps.execute();

			System.out.println("Student  Data copied successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updatestudentdata(Student stud_update) {

		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("UPDATE studentinfo SET studentname =? WHERE studentid=?");

			ps.setInt(2, stud_update.getRollno());

			ps.setString(1, stud_update.getSname());
			ps.execute();

			int i = ps.executeUpdate();

			System.out.println(i + " Student Data updated successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletestudentdata(int delete) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Delete from studentinfo where rollno=?");

			ps.setInt(1, delete);

			int i = ps.executeUpdate();

			System.out.println(i + "Student Data Deleted successffully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Override
	public void searchstudentdata(int search) {
		// TODO Auto-generated method stub
		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("Select* from studentinfo where rollno=?");
			ps.setInt(1, search);
			// ps.execute();

			rs = ps.executeQuery();
			System.out
					.println("Roll No\t" + "Student Name" + "Student Address");
			while (rs.next()) {
				System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3));
			}

			System.out.println("Student Data Searched successfully");

			// System.out.println(rs.);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList retrievestudentdata() throws ClassNotFoundException {

		try {
			con = Conprovider.getConnection();

			ps = con.prepareStatement("select * from studentinfo s, batchinfo b,facultyinfo f,course c where s.batchid=b.batchid and b.facultyid=f.facultyid and c.courseid=f.courseid   ");

			rs = ps.executeQuery();

			while (rs.next()) {
				Student studentobj = new Student();

				studentobj.setRollno(rs.getInt(1));

				studentobj.setSname(rs.getString(2));

				studentobj.setScity(rs.getString(3));

				Batch bat = new Batch();

				bat.setBid(rs.getInt(5));

				bat.setBname(rs.getString(6));

				studentobj.setBat(bat);

				Faculty fac = new Faculty();

				fac.setFid(rs.getInt(8));

				fac.setFname(rs.getString(9));

				bat.setFac(fac);

				Course cos = new Course();

				cos.setCorId(rs.getInt(11));

				cos.setCor(rs.getString(12));

				fac.setCors(cos);

				studlist.add(studentobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return batlist;
		return studlist;
		// TODO Auto-generated method stub

	}

}
