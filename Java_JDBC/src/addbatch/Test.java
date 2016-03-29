package addbatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException   {
		
		Allstudent a=new Allstudent();
		ArrayList data=a.StudentData();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/student","root","root")	;
		ps=con.prepareStatement("Insert into data values(?,?,?)");
		
		Iterator itr=data.iterator();
		while(itr.hasNext())
		{
			Student stu=(Student)itr.next();
			ps.setInt(1, stu.getRollno());
			
			ps.setString(2,stu.getName());
			ps.setString(3,stu.getAdr());
			ps.addBatch();
		}
		ps.executeBatch();
		System.out.println("Data copied");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		}
		
	
	
}
