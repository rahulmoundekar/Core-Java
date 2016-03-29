package com.extrimityindia.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conprovider {
static Connection con=null;
PreparedStatement ps=null;
	public static Connection getConnection() throws ClassNotFoundException
	{	Class.forName("com.mysql.jdbc.Driver");
		try{
		con=DriverManager.getConnection("JDBC:Mysql://localhost:3306/Studentdata","root","root");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return con;
	}
	public static void closeConnection()
	{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
	}
}
