package jdbcstudent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

//import com.sql.jdbc.Statement;

public class Display {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Allstudent all=new Allstudent();
		ArrayList al1=all.Allstudent();
		System.out.println(al1);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		Statement smt = null;

		try {
			//Enter Scheema name 
			con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/student","root","root");
			smt=con.createStatement();
			Iterator itr=al1.iterator();
			while(itr.hasNext())
			{
				Student stu=(Student)itr.next();
				//System.out.println();
				//enter table name
				String sql="Insert into data values('"+stu.getRollno()+"','"+stu.getName()+"','"+stu.getAddr()+"' )";
			
				//System.out.println(sql);
				
				smt.execute(sql);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally
		{try{
			smt.close();
			con.close();
			System.out.println("Data Copied in to the database");
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}}
		
		
		
	}

}
