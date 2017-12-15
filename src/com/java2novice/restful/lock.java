package com.java2novice.restful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lock {
	
	public void lock_file(String file) throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://localhost:3306/filedetails";
	String uname ="gaurav";
	String pass = "pearl";

	
	String query = "UPDATE filename  SET filestatus = '1' where fileName=" + "'" + file+ "'";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
	Statement st = con.createStatement();
	st.executeUpdate(query);
	st.close();
	con.close();
	
	}
	
	public boolean read_status(String File) throws SQLException, ClassNotFoundException
	{	boolean temp = false;
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="gaurav";
		String pass = "pearl";
		//String query = "Select machineip from filename where fileidentifier=1";
		String query = "Select * from filename ";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while(rs.next())
				{
					if (File==rs.getString(1))
					{
						if (rs.getInt(4)==1)
						{temp =true;}
						else
						{temp =false;}
					}
				}	

		st.close();
		con.close();
		
		return temp;
		
	}
	
	
	public void unlock_file(String file) throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://localhost:3306/filedetails";
	String uname ="gaurav";
	String pass = "pearl";

	
	String query = "UPDATE filename  SET filestatus = '0' where fileName=" + "'" + file+ "'";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
	Statement st = con.createStatement();
	st.executeUpdate(query);
	st.close();
	con.close();
	
	}

}
