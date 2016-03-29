/*package jdbctest;
import java.sql.*;

public class OracleTest {

	public static void main(String[] args) throws ClassNotFoundException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from emp");  
				while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				  
				//step5 close the connection object  
				con.close();  
				  
				}catch(Exception e){ System.out.println(e);}  
				  
				}  
				}  
		
				}
*/