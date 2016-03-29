package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Data {
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	PreparedStatement ps=null; 
	ResultSet rs;
ArrayList al=new ArrayList();

ArrayList data()
{	
	System.out.println("How Many New Students you want to add");
	int input=sc.nextInt();
	for(int i=1;i<=input;i++)
	{
		Student s=new Student();
	System.out.println("Enter the Roll Number");
	s.setRollno(sc.nextInt());
	System.out.println("Enter the Student Name");
	s.setName(sc.next());
	System.out.println("Enter the Address");
	s.setAdr(sc.next());
	
	al.add(s);
	}
	return al;
	
}

void Insert()
{Data d=new Data();
	
	ArrayList input=d.data();
	//System.out.println(input);
	//System.out.println(input);
	try
	{
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/student","root","root");
	
	Iterator itr=input.iterator();
	while(itr.hasNext())
	{
		Student stu=(Student)itr.next();
		ps=con.prepareStatement("Insert into data values (?,?,?)");
		ps.setInt(1, stu.getRollno());
		ps.setString(2, stu.getName());
		ps.setString(3, stu.getAdr());
		
	//	ps.addBatch();
		ps.execute();
	}
	//ps.executeBatch();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			ps.close();
			con.close();
			System.out.println("Data Inserted Successfully");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}}
void call()
{
	try {
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/student","root","root");
		System.out.println("RollNo\t"+"Name\t"+"Address");
		System.out.println("============================");
		ps=con.prepareStatement("Select * from data");
		//ps.executeQuery();
		rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(+rs.getInt(1)+"\t"+ rs.getString(2)+"\t" +rs.getString(3));
			System.out.println("............................");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
void update()
{try {
	System.out.println("Enter the Student Rollno where you want to make update");
	int empno=sc.nextInt();
	
	System.out.println("Enter the new Student name which you want to update");
	String str=sc.next();
	
	

	ps=con.prepareStatement("UPDATE data SET Name='"+str+"' WHERE Rollno='"+empno+"'");
	
	int a=ps.executeUpdate();
	System.out.println(a+" Update is done");
	ps.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
		
    	}
}
