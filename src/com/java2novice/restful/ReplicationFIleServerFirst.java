package com.java2novice.restful;

import java.io.File;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("replicationFileServer")
public class ReplicationFIleServerFirst {
	
	
	@GET
	   @Produces(MediaType.APPLICATION_OCTET_STREAM)
	   @Path("/read2/{fileName3       }")
	   public Response getFileForRead(@PathParam("fileName") String fileName) throws Exception{
		   File folder = new File("C:\\Users\\chandg\\Desktop\\project3\\project3\\WebContent\\RepositoryFirst");
		   
		   LocationOfFile lf = new LocationOfFile();
		   listFilesForFolder(folder, lf.getFirstRepository());
	     return Response.ok(folder, MediaType.APPLICATION_OCTET_STREAM)
	         .header("Content-Disposition", "attachment; filename=\"" + folder.getName() + "\"" ) //optional
	         .build();
	   }
	   
	   
	   public void listFilesForFolder(final File folder ,  HashMap< String, String> map) {
		    for (final File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		        	
		            listFilesForFolder(fileEntry,map);
		        } else {
		            System.out.println(fileEntry.getName());
		            map.put("fileEntry.getName()", "C:\\Users\\chandg\\Desktop\\project3\\project3\\WebContent\\RepositoryFirst");
		        }
		    }
		}
	
	
	
	

}
