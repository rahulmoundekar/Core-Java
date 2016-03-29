/*package jdbctest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class TestResult {
	Scanner sc=new Scanner(System.in);
	
	String Update()
	{ System.out.println("Enter the Employee name which you want to update");
		String str=sc.next();
		System.out.println("Enter the Employee ID");
		int empno=sc.nextInt();
			String d="UPDATE employee SET Name='"+str+"' WHERE Empno='"+empno+"';"  ;
	    		return d;
	}
	
	
	Employee Add()
	{	
		ArrayList emp=new ArrayList();
		Employee e=new Employee();
		int i1 = 0;
		String s=null;
		String s1=null;String d=null;
		System.out.println("How many Employees do you want to add");
		int input=sc.nextInt();
	
		for (int i=1;i<=input;i++)
		{System.out.println("Enter the Employee no");
		i1=sc.nextInt();
		e.setEmpno(input);
		System.out.println("Enter the Employee Name");
		 s=sc.next();
		 e.setEmpname(s);
		System.out.println("Enter the city name");
		s1=sc.next();
		e.setCity(s1);
		emp.add(e);
		} //d="Insert into employee values('"+i1+"','"+s+"','"+s1+"')";
		//return d1
		//al.add();
		return e;
	}
	
	String Delete()
	{
		
		System.out.println("Enter the Employee id whose content you want to delete");
		int a=sc.nextInt();
		String d="Delete from employee where Empno='"+a+"' ";
		
		return d;
	}
	
public static void main(String[] args) throws ClassNotFoundException {
	TestResult t=new TestResult();
	
	Class.forName("com.mysql.jdbc.Driver");//claas address of mysql jdbc drivers
	Connection con=null;
	Statement smt =null;
	Scanner sc=new Scanner(System.in);
	try {
		System.out.println("=================Menu=====================");
		System.out.println("1:Add");
		System.out.println("2:Update");
		System.out.println("3:Delete");
		
		
		String str1=null;
		int a=sc.nextInt();
		switch(a)
		{
		case 1: str1=t.Add();
		break;
		case 2: str1=t.Update();
		break;
		case 3: str1=t.Delete();
		break;
		}
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/a","root", "root");
		// con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/b60","root","root");
		
		//String str=;//to pass objects
		//String str1=t.Update();
		smt=con.createStatement();
		smt.executeUpdate(str1);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally
	{	
		try {
		smt.close();
		con.close();
		System.out.println("done");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			}
}
}
*/