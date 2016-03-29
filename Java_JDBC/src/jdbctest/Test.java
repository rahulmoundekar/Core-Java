package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	
	
	public static void main(String[] args) throws ClassNotFoundException 
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	Statement smt=null;
	try {
		 con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/b60","root","root");
		
		 String sql="Insert into Student values(5,'Tanver','Karvenagar')";
	
		smt=con.createStatement();
		smt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			smt.close();
			con.close();
			System.out.println("Data copied in sql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
}
