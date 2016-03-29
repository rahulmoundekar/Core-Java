package jdbcstudent;

import java.util.ArrayList;

public class Allstudent {

	ArrayList al=new ArrayList();
	
	 ArrayList Allstudent()
	{
		
		Student s=new Student();
		s.setRollno(1);
		s.setName("Tanveer");
		s.setAddr("Pune");
		
		Student s1=new Student();
		s1.setRollno(2);
		s1.setName("Aditya");
		s1.setAddr("Vellore");
		
		al.add(s);
		al.add(s1);
		return al;
	}
	
}
