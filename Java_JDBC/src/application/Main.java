package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Data d=new Data();
		Scanner sc=new Scanner(System.in);
		ResultSet rs;
	while(true)
		{System.out.println("===========Menu============");
		System.out.println("1:Insert new data\n"+"2:Retrieve data\n"+"3:Update data\n"+"4:Exit");
		int a=sc.nextInt();
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		PreparedStatement ps=null;
		
		switch(a)
		{
		case 1:d.Insert();
			
		break;
		
		case 2:d.call();
		
				break;
		case 3:d.update();
		System.out.println("Data Updated Successfully");
		break; 
		
		case 4:
			
			System.out.println("Exited from the System");
			
	}
		}
}
}