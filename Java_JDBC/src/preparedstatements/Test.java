package preparedstatements;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	
	public static void main(String[] args) throws ClassNotFoundException {
		Allstudent a=new Allstudent();
		ArrayList al=a.Allstudent();
		System.out.println(al);
		Connection con=null;
		PreparedStatement ps=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
	
			con=DriverManager.getConnection("JDBC:mysql://localhost:3306/student","root", "root");
			ps=con.prepareStatement("Insert into data values (?,?,?)");
			Iterator itr=al.iterator();
			while(itr.hasNext())
			{
				StudentData stu=(StudentData)itr.next();
				ps.setInt(1,stu.getRollno());
				ps.setString(2, stu.getName());
				ps.setString(3,stu.getAddr());
				ps.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
}
