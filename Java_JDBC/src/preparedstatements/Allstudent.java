package preparedstatements;
import java.util.*;
public class Allstudent {
	
ArrayList al=new ArrayList();

ArrayList Allstudent()
{
	StudentData st=new StudentData();
	st.setRollno(3);
	st.setName("Tanveer");
	st.setAddr("Amravati");
	StudentData st1= new StudentData();
	st1.setRollno(3);
	st1.setName("Sonali");
	st1.setAddr("Amravati");
	al.add(st);
	al.add(st1);
	return al;
	}
}
