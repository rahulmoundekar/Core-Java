package addbatch;

import java.util.ArrayList;

public class Allstudent {

	ArrayList al=new ArrayList();
	
	ArrayList StudentData()
	{
		Student s=new Student();
		
		s.setRollno(10);
		s.setName("Aditya");
		s.setAdr("Pune");
		al.add(s);
		
		return al;
		
	}
}
