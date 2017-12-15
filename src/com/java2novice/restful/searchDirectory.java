package com.java2novice.restful;

import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/directoryService") 
	public class searchDirectory {
		
		   @GET 
		   @Produces(MediaType.APPLICATION_XML) 
		   @Path("{fileName}")
		   public String GetFileData(@PathParam("fileName") String fileName) throws Exception{
			   
			   
			   DbConnectivity db = new DbConnectivity();
			   ResultSet rs  = db.readdata(fileName);
			  
			   
			   return rs.getString(1) + rs.getString(2) + rs.getString(4);
		   }
		   
		   
		  

}
