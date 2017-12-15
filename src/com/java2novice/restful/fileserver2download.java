package com.java2novice.restful;

import java.io.File;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/download2")
public class fileserver2download {
 
    @GET
    @Path("/service-record2")
    @Produces("application/pdf")
    public Response getFile() throws ClassNotFoundException, SQLException {
    	String File_n="08038776.pdf";
        File file = new File("C:/Users/Public/uploadedFiles/08038776.pdf");
        
        lock l2 = new lock();
        boolean temp= l2.read_status(File_n);
        ResponseBuilder response = null;
        if(temp==false) {
     
         response = Response.ok((Object) file);
        response.header("Content-Disposition",
            "attachment; filename=\"08038776.pdf\"");
        
        lock l = new lock();
        l.lock_file(File_n);
        }
        return response.build();
       }
       
     
        
        
    }



//http://localhost:8080/project3/rest/download/service-record  to download file from server