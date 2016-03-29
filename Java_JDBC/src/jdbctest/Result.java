package jdbctest;
import java.sql.*;

public class Result {
public static void main(String[] args) throws ClassNotFoundException {
	
Connection con=null;
Statement smt=null;
ResultSet rs;
System.out.println("Emp code "+"Emp Name "+"Emp city");
	Class.forName("com.mysql.jdbc.Driver");
	try {
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/a","root","root");
		
		String sql="select * from employee ";
		//String sql1="delete";
		smt=con.createStatement();
		smt.executeQuery(sql);
		rs=smt.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(""+rs.getInt(1)+" |"+ rs.getString(2)+" |" +rs.getString(3));
			System.out.println();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			smt.close();
			con.close();
			System.out.println("Data got");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}