package com.extrimityindia.app.client;
import com.extrimityindia.app.*;

import com.extrimityindia.app.daoimp.StudentdaoImpl;
import com.extrimityindia.app.model.Batch;
import com.extrimityindia.app.model.Course;
import com.extrimityindia.app.model.Faculty;
import com.extrimityindia.app.model.Student;

import com.extrimityindia.app.server.Inputdata;
import com.extrimityindia.app.serviceimpl.Studentserviceimpl;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) throws ClassNotFoundException 
	{
		Inputdata input=new Inputdata();
		StudentdaoImpl studaoimp=new StudentdaoImpl();
		Studentserviceimpl studentservice=new Studentserviceimpl();
Scanner sc=new Scanner(System.in);
		
	while(true)
	{
		System.out.println("===========MAIN-MENU===========");
		System.out.println("1:Course Information\n\n"+"2:Faculty Information\n\n"+"3:Batch Information\n\n"+"4:Student Information\n\n"+"5:Exit Main Menu\n\n");
		int a=sc.nextInt();
		switch(a)
		{	
	
			
		case 1:while(true){System.out.println("=============COURSE-MENU=============");
			
		System.out.println("1:Insert Course Data\n\n"+"2:Update Course Data\n\n"+"3:Retrive Course Data\n\n"
						+"4:Delete Course Data\n\n"+"5:Search Course Data\n\n"+"6:Exit Course Menu\n");

			int b=sc.nextInt();
		
			switch(b)
				{
				case 1:
				//Inserting values in course
					
				Course cos=input.addcourse();
				
				//Returning cos data in studentservice
			
				studentservice.servicecourse(cos);
					break;
		
				case 2:
				//update data 
				
				
				studaoimp.retrievecoursedata();
					
				//Make update 
				Course cos1=input.updatecourse();
				
				//Studentserviceimpl studentservice1=new Studentserviceimpl();
					
				studentservice.serviceupdatecourse(cos1);
			
					break;
				
				case 3:
					Inputdata courseget=new Inputdata();
				try {
					courseget.displaycourse();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
					break;
			
				case 4:
					System.out.println("Perform delete operation using Course DataTable\n\n");
					
					StudentdaoImpl studaoimp2=new StudentdaoImpl();
					studaoimp2.retrievecoursedata();
					
					int delete=input.deletecourse();
					System.out.println(delete);
					Studentserviceimpl studentservice2=new Studentserviceimpl();
					
					studentservice2.servicecoursedelete(delete);//(delete);
					
					
					break;
					
				case 5:
					System.out.println("Perform Search Operation using Course DataTable\n\n");
					
					StudentdaoImpl studaoimp3=new StudentdaoImpl();
					studaoimp3.retrievecoursedata();
					
					int search=input.searchcourse();
					System.out.println(search);
					Studentserviceimpl studentservice3=new Studentserviceimpl();
					
					studentservice3.servicecoursesearch(search);
					
					
					break;
					
				case 6:
					System.out.println("You are out of Course Menu ");
					System.exit(6);
				
				
				break;
				}
}

//////////Faculty data adding
//==========================================Faculty add 
		case 2:
			while(true)
			{
System.out.println("=============FACULTY-MENU=============");
		
		System.out.println("1:Insert Faculty Data\n\n"+"2:Update Faculty Data\n\n"+"3:Retrive Faculty Data\n\n"+"4:Delete Faculty Data\n\n"+"5:Search Faculty Data\n\n"+"6:Exit Faculty Menu\n");
		
		int c=sc.nextInt();
		
			switch(c)
			{
				case 1:Faculty fac_insert=input.addfaculty();
						studentservice.serviceinsertfaculty(fac_insert);
					
				
		
					break;
				case 2:Faculty fac_update=input.updatefaculty();
						studentservice.serviceupdatefaculty(fac_update);
				
					
					break;
					
				case 3:Inputdata getfaculty= new Inputdata();
						getfaculty.displayfaculty();
					break;
			
				case 4:System.out.println("Perform delete operation using Faculty DataTable\n\n");
				
				//StudentdaoImpl studaoimp=new StudentdaoImpl();
				studaoimp.retrievefacultydata();
				
				int delete=input.deletefaculty();
				System.out.println(delete);
				Studentserviceimpl studentservice2=new Studentserviceimpl();
				
				studentservice2.servicefacultydelete(delete);
					
					break;
					
				case 5:
					System.out.println("Perform Search Operation using Faculty DataTable\n\n");
					
				
					studaoimp.retrievefacultydata();
					
					int search=input.searchfaculty();
							
					System.out.println(search);
					
					studentservice.servicefacultysearch(search);
					break;
				
			case 6:System.out.println("You are out of faculty menu ");
}}
//======================================Batch Data Controlllerrrr=================================
case 3:
	while(true)
	{System.out.println("=============BATCH-MENU=============");

System.out.println("1:Insert Batch Data\n\n"+"2:Update Batch Data\n\n"+"3:Retrive Batch Data\n\n"+"4:Delete Batch Data\n\n"+"5:Search Batch Data\n\n"+"6:Exit Batch Menu\n");

		
		int d=sc.nextInt();
		
			switch(d)
			{///////////===========insert batch controller++++++++++++++++++++++++++++++
				case 1:Batch bat_insert=input.inputbatch();
				studentservice.serviceinputbatch(bat_insert);
				
		
					break;
			///=============================update batch controller======================
				case 2:Batch bat_update=input.updatebatch();
				studentservice.serviceupdatebatch(bat_update);
					
					break;
	//=====================================Retrieve batch controller===================================
					
				case 3:	Inputdata getbatch= new Inputdata();
						getbatch.displaybatch();
					
					break;
		//=========	=======================Delete batch controller===================================
				case 4:
					System.out.println("Perform delete operation using Batch DataTable\n\n");
					
					//StudentdaoImpl studaoimp=new StudentdaoImpl();
					studaoimp.retrievebatchdata();
					
					int delete=input.deletebatch();
					
				//	System.out.println(delete);
					
					//Studentserviceimpl studentservice=new Studentserviceimpl();
					
					studentservice.servicedeletebatch(delete);
					break;
		//===============================Search batch controller===================================		
				case 5:System.out.println("Perform Search Operation using Batch DataTable\n\n");
				
						studaoimp.retrievebatchdata();
				
						int search=input.searchbatch();
						
						System.out.println(search);
				
						studentservice.servicebatchsearch(search);
					break;
					//==============================Exit batch controller===================================	
				case 6:System.out.println("You are out of batch menu system");
					System.exit(6);
				
				break;
			}
	}		
case 4:
	while(true)
	{
		System.out.println("=============STUDENT-MENU=============");
	

System.out.println("1:Insert Student Data\n\n"+"2:Update Student Data\n\n"+"3:Retrive Student Data\n\n"+"4:Delete Student Data\n\n"+"5:Search Student Data\n\n"+"6:Exit Student Menu\n");

int e=sc.nextInt();

switch(e)
	{///////////===========insert Student controller======================================
			case 1:Student stud_insert=input.inputstudent();
				studentservice.serviceinputstudent(stud_insert);
	

		break;
///=============================update Student controller=====================================
			case 2:Student stud_update=input.updatestudent();
				studentservice.serviceupdatebatch(stud_update);
		
		break;
//=====================================Retrieve student controller===================================
		
	case 3:	Inputdata getstudent= new Inputdata();
			getstudent.displaystudent();
		
		break;
//=========	=======================Delete batch controller===================================
	case 4:
		System.out.println("Perform delete operation using Batch DataTable\n\n");
		
		
		studaoimp.retrievestudentdata();
		
		int delete=input.deletestudent();
		
		studentservice.servicedeletestudent(delete);
		break;
//===============================Search batch controller===================================		
	case 5:System.out.println("Perform Search Operation using Student DataTable\n\n");
	
			studaoimp.retrievestudentdata();
	
			int search=input.searchstudent();
			
			System.out.println(search);
	
			studentservice.servicestudentsearch(search);
		break;
		//==============================Exit batch controller===================================	
	case 6:System.out.println("You are out of Student menu system");
		System.exit(6);
	
	break;
}
	}
	}
		}
	}
	}
