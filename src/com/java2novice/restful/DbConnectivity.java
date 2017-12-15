package com.java2novice.restful;
import java.sql.*;


public class DbConnectivity {
	
	 int fileidentifier=0;

	public  ResultSet   readdata(String FileN) throws ClassNotFoundException, SQLException {	

		
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="gaurav";
		String pass = "pearl";
		//String query = "Select machineip from filename where fileidentifier=1";
		String query = "Select * from filename ";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		//String userdata="";
		while(rs.next())
				{
					if (FileN==rs.getString(1))
					{
						break;
					}
					//userdata= rs.getString(1) + ":"+ rs.getString(2)+ ":"+ rs.getString(3);
					System.out.println(rs);
		
				}	//String name= rs.getString("machineip");

		st.close();
		con.close();
		
		return rs;
			
	}
	
	public void insert( String fileName ,String machineip,int filestatus,String location) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="gaurav";
		String pass = "pearl";
		 fileidentifier = fileidentifier + 1;
		//String machineip = "167.3.46.3";
		//String filestatus= "0";
		//String query = "Select machineip from filename where fileidentifier=1";
		//String location="";
		String query = "insert into filename values (?,?,?,?) ";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, fileName);
		st.setInt(2, fileidentifier);
		st.setString(3, machineip);
		st.setInt(4, filestatus);
		st.setString(5, location);
		
		int count = st.executeUpdate();

		System.out.println(count + "row/s affected");
		
		st.close();
		con.close();
	}

}
