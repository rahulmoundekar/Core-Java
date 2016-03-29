package com.cjc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	static Connection con = null;

	public static Connection createMysqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javaclasses", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return con;
	}

	public static Connection createOracleconnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * to get a result set of a query
	 * 
	 * @param query
	 *            custom query
	 * @return a result set of custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static ResultSet getResultSet(String query) throws SQLException {
		Connection con = createMysqlConnection();
		ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		rs = st.executeQuery();
		return rs;
	}

	/**
	 * to run an update query such as update, delete
	 * 
	 * @param query
	 *            custom query
	 * @return 
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static Integer runQuery(String query) throws SQLException {
		Connection con = createMysqlConnection();
		// ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		Integer result=st.executeUpdate();
		return result;
	}

	public static void close() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
