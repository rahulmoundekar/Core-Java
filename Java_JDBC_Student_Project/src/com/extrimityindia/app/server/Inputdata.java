package com.extrimityindia.app.server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.extrimityindia.app.dao.StudentDao;
import com.extrimityindia.app.daoimp.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.extrimityindia.app.model.*;
import com.extrimityindia.app.util.Conprovider;
public class Inputdata {
	
	ResultSet rs;
	PreparedStatement ps=null;
	Connection con=null;
	ArrayList stud=new ArrayList();
	ArrayList bat=new ArrayList();
	ArrayList corslist=new ArrayList();
	ArrayList fac=new ArrayList();
	StudentdaoImpl studndao=new StudentdaoImpl();
	
	Scanner sc=new Scanner(System.in);
	
	//================================Course data input===================================
	
	//.....................................Input Course data................................
	public Course addcourse()
	{	
		Course c=new Course();
	
		System.out.println("Enter the Course Name ");
		c.setCor(sc.next());
	
		
		System.out.println("Enter the course Id");
		c.setCorId(sc.nextInt());

		//cors.add(c);
		return c ;
	}
	
	
	//...............................display course data...............................................
	
	public void displaycourse() throws ClassNotFoundException
	{
		System.out.println("=========================");
		
		System.out.println("   COURSE_ID\tCOURSE NAME");
		
		System.out.println("=========================");
		
		ArrayList corsList=studndao.retrievecoursedata();
		Iterator itrcorList=corsList.iterator();
	
		while(itrcorList.hasNext())
		{
			Course cosdata=(Course)itrcorList.next();
			//System.out.println(cosdata);
			System.out.println("\t"+cosdata.getCorId()+"\t"+cosdata.getCor());
			System.out.println("--------------------------");
		}
		
		
	
		System.out.println("Data Displayed successffully");
		
	}
	
	//..............................update course data................................
	
	
	public Course updatecourse()
	{
		Course upd=new Course();
		try {
			displaycourse();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter the Course number you want to edit ");
		upd.setUpdatecorid(sc.nextInt());
		
		
		System.out.println("Enter the Course Name to update ");
		upd.setUpdatecorname(sc.next());
		
	
		return upd; 
	}
	
	
	//................................delete course data................................
	
	
	public int deletecourse() throws ClassNotFoundException
	{
		
		displaycourse();
		System.out.println("Enter Course Id to delete");
		
		int cosdel=sc.nextInt();
		
		return cosdel;
	}
	
	
	//.................................search course data...................................
	
	public int searchcourse() throws ClassNotFoundException
	{
		displaycourse();
		System.out.println("Enter Course Id to Search");
		
		int search=sc.nextInt();
	
		
		return search;
	}
	
	
	//................................input faculty data.....................................
	
	
	public Faculty addfaculty() throws ClassNotFoundException
	
	{	Conprovider.getConnection();
		
			
			ArrayList corslistcheck=studndao.retrievecoursedata();
			Faculty f=new Faculty();
			if(!corslistcheck.isEmpty())
			{				

				
				
				System.out.println("Enter the Faculty ID");
			 
				f.setFid(sc.nextInt());
			
				System.out.println("Enter the faculty name");
			
				f.setFname(sc.next());
	
				displaycourse();
				/////Course diplayeeddddddddddd
				
				Course cor=new Course();
				
			//	f.setCors(cor);
				
				System.out.println("Select the course ID to assign faculty");
				
				int course_id=sc.nextInt();
				
				//ArrayList corsList=studndao.retrievecoursedata();
				
				
				
				Iterator it=corslistcheck.iterator();
				
				while(it.hasNext())
				{ 
					Course id=(Course)it.next();
					if(course_id==id.getCorId())
					{
						f.setCors(id);
						
					}
			
				//	f.add(f);
				}
						System.out.println("Faculty added Succesfully"+"\n");
				
			
			
			}
			else if(corslistcheck.isEmpty()){
			System.out.println("Please add Course Information then add Faculty Information");
			//return null;
			}
			
			return f;	
			
	}		
		
			
	
	//.........................................display faculty..........................
	
	
	public void displayfaculty() throws ClassNotFoundException

	{
	
	
		System.out.println("===============================================================");
		//con = Conprovider.getConnection();
	System.out.println("   FACULTY_ID\tFACULTY NAME\tCOURSE ID\tCOURSE NAME");
	
	System.out.println("===============================================================");
	
	ArrayList faclist=studndao.retrievefacultydata();
	Iterator itrfaclist=faclist.iterator();

	while(itrfaclist.hasNext())
	{
		Faculty facdata=(Faculty)itrfaclist.next();
		//System.out.println(cosdata);
		System.out.println("\t"+facdata.getFid()+"\t"+facdata.getFname()+"\t\t"+facdata.getCors().getCorId()+"\t\t"+facdata.getCors().getCor());
		
		System.out.println("---------------------------------------------------------------");
	}
	
	

	System.out.println("Data Displayed successffully");
	
}
	//...............................Faculty update ...............................
	
	
	public Faculty updatefaculty()
	{
		Faculty fac_up=new Faculty();
		
		System.out.println("Enter the Faculty ID number you want to edit ");
		
		fac_up.setFid(sc.nextInt());
		
		System.out.println("Enter the Course Name to update ");
		
		fac_up.setFname(sc.next());
		
	
		return fac_up; 
	}
	
	
	public int deletefaculty() throws ClassNotFoundException
	{
		System.out.println("Delete the faculty from datatable");
		displayfaculty();
		
		Faculty fac_delete=new Faculty();
		
		System.out.println("Enter Faculty Id to delete");
		
		int facdel=sc.nextInt();
		
		return facdel;
	}
	
	public int searchfaculty() throws ClassNotFoundException
	{
	//	Faculty fac_search=new Faculty();
		
		displayfaculty();
		System.out.println("Enter Faculty Id to Search");
		
		int facsearch=sc.nextInt();
	
		
		return facsearch;
	}
	
//===============================================Batch Input Data=================================================
	
	//.....................................input batch data.....................................................
	 public Batch inputbatch() throws ClassNotFoundException
	
	 {
		 Conprovider.getConnection();
		
		
		ArrayList faclistcheck=studndao.retrievefacultydata();
		Batch bat=new Batch();
		if(!faclistcheck.isEmpty())
		{				
				
				System.out.println("Enter the Batch ID");
				bat.setBid(sc.nextInt());
				
				System.out.println("Enter the Batch Name ");
				bat.setBname(sc.next());
				
				System.out.println();
				// return bat;
			
			
				 displayfaculty();
			
				 Faculty fac=new Faculty();
			
	
				 System.out.println("Select the Batch ID to assign faculty");
			
				 int faculty_id=sc.nextInt();
			
				 Iterator it=faclistcheck.iterator();
			
				 while(it.hasNext())
				 { 
				Faculty id=(Faculty)it.next();
				if(faculty_id==id.getFid())
				{
					bat.setFac(id);
					
				}
		
			//	f.add(f);
			}
					System.out.println("Batch added Succesfully"+"\n");
			
		
		
		}
		else if(faclistcheck.isEmpty()){
		System.out.println("Please add Faculty Information then add Faculty Information");
		//return null;
		}
		
		return bat;	
	
		
	}
	 public void displaybatch() throws ClassNotFoundException

		{
		
		
			System.out.println("================================================================================================");
			//con = Conprovider.getConnection();
		System.out.println("   BATCH_ID\tBATCH NAME\tFACULTY ID\tFACULTY NAME\tCOURSE ID\tCOURSE NAME");
		
		System.out.println("====================================================================================================");
		
		ArrayList batlist=studndao.retrievebatchdata();
		Iterator itrbatlist=batlist.iterator();

		while(itrbatlist.hasNext())
		{
			Batch batdata=(Batch)itrbatlist.next();
			
			System.out.println
			("\t"+batdata.getBid()+"\t"+batdata.getBname()+"\t\t"+batdata.getFac().getFid()+
			"\t\t"+batdata.getFac().getFname()+"\t\t"+batdata.getFac().getCors().getCorId()+"\t\t"+batdata.getFac().getCors().getCor());
			
			System.out.println("----------------------------------------------------------------------------------------");
		}
		
		

		System.out.println("Batch Data Displayed successffully");
		
	}
	 

		public Batch updatebatch()
		{
			System.out.println("Update the Batch from datatable");
			
			try {
				displaybatch();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Batch bat_up=new Batch();
			
			System.out.println("Enter the Batch ID number you want to edit ");
			
			bat_up.setBid(sc.nextInt());
			
			System.out.println("Enter the Course Name to update ");
			
			bat_up.setBname(sc.next());
			
		
			return bat_up; 
		}
		
		
		public int deletebatch() throws ClassNotFoundException
		{
			System.out.println("Delete the Batch from datatable");
			
			displaybatch();
			
			Batch  bat_delete=new Batch();
			
			System.out.println("Enter Batch Id to delete");
			
			int batdel=sc.nextInt();
			
			return batdel;
		}
		
		public int searchbatch()
		{
			System.out.println("Search the Batch from datatable");
			
			try {
				displaybatch();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Batch bat_search=new Batch();
			
			System.out.println("Enter Faculty Id to Search");
			
			int batsearch=sc.nextInt();
		
			
			return batsearch;
		}
	 //==================================Input data student======================================
	public Student inputstudent() throws ClassNotFoundException
		{
		
			Conprovider.getConnection();
			
			Student stu=new Student();
		
			ArrayList batlistcheck=studndao.retrievebatchdata();
		
			if(!batlistcheck.isEmpty())
			{			
			System.out.println("Enter the Student Roll no");
			stu.setRollno(sc.nextInt());
			
			System.out.println("Enter the Student Name");
			stu.setSname(sc.next());
			
			System.out.println("Enter the Student City");
			stu.setScity(sc.next());
			
			displaybatch();
		System.out.println("Enter the Batch you have selected");
		
			int batch_id=sc.nextInt();
		
			Iterator it=batlistcheck.iterator();
		
			while(it.hasNext())
			 { 
			Batch id=(Batch)it.next();
				if(batch_id==id.getBid())
				{
				stu.setBat(id);
				System.out.println("Batch added Succesfully"+"\n");
				}
	
			
			 
			 }
		}
			
	else if(batlistcheck.isEmpty())
		 {
			System.out.println("Please add Batch Information then add Student Information");
					//return null;
			}
		
			return stu;
		}	 
	
		

			

public void displaystudent() throws ClassNotFoundException

{


	System.out.println("=========================================================================================================================================");
	//con = Conprovider.getConnection();
System.out.println("ROLLNO\tSTUDENT NAME\tSTUDENT ADDRESS\t  BATCH_ID\tBATCH NAME\tFACULTY ID\tFACULTY NAME\tCOURSE ID\tCOURSE NAME");

System.out.println("=========================================================================================================================================");

ArrayList studlist=studndao.retrievestudentdata();
Iterator itrstudlist=studlist.iterator();

while(itrstudlist.hasNext())
{
	Student studentdata=(Student)itrstudlist.next();
	
	System.out.println
	(studentdata.getRollno()+"\t"+studentdata.getSname()+"\t\t"+studentdata.getScity()+
	"\t\t"+studentdata.getBat().getBid()+"\t"+studentdata.getBat().getBname()+" \t"+studentdata.getBat().getFac().getFid()+"\t\t"
	+studentdata.getBat().getFac().getFname()+"\t\t"+studentdata.getBat().getFac().getCors().getCorId()+"\t\t"
	+studentdata.getBat().getFac().getCors().getCor());
	
	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
}



System.out.println("Student Data Displayed successffully");

}


public Student updatestudent()
{
	System.out.println("Update the Student from datatable");
	
	try {
		displaystudent();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Student stud_up=new Student();
	
	System.out.println("Enter the Batch Rollno number you want to edit ");
	
	stud_up.setRollno(sc.nextInt());
	
	System.out.println("Enter the Student Name to update ");
	
	stud_up.setSname(sc.next());
	

	return stud_up; 
}


public int deletestudent() throws ClassNotFoundException
{
	System.out.println("Delete the Student from datatable");
	
	displaystudent();
	
	Student  stud_delete=new Student();
	
	System.out.println("Enter Student Id to delete");
	
	int studel=sc.nextInt();
	
	return studel;
}

public int searchstudent()
{
	System.out.println("Search the Student from datatable");
	
	try {
		displaystudent();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Student stud_search=new Student();
	
	System.out.println("Enter Student Id to Search");
	
	int studsearch=sc.nextInt();

	
	return studsearch;
}
	
	

}