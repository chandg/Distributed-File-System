package com.java2novice.restful;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("test2")
public class fileserv2upload {

   private static final String FOLDER_PATH = "C:/Users/Public/uploadedFiles/";
   int  fileidentifier=0;
   @POST
   @Path("/upload2")
   @Consumes(MediaType.MULTIPART_FORM_DATA)
   //@Produces(MediaType.TEXT_PLAIN)
   public String uploadFile(@FormDataParam("file") InputStream fis,
                   @FormDataParam("file") FormDataContentDisposition fdcd) throws ClassNotFoundException, SQLException, UnknownHostException {
 
       OutputStream outpuStream = null;
       String fileName = fdcd.getFileName();
       System.out.println("File Name: " + fdcd.getFileName());
       String filePath = FOLDER_PATH + fileName;
        
       try {
           int read = 0;
           byte[] bytes = new byte[1024];
           outpuStream = new FileOutputStream(new File(filePath));
           while ((read = fis.read(bytes)) != -1) {
               outpuStream.write(bytes, 0, read);
           }
           outpuStream.flush();
           outpuStream.close();
       } catch(IOException iox){
           iox.printStackTrace();
       } finally {
           if(outpuStream != null){
               try{outpuStream.close();} catch(Exception ex){}
           }
       }
       String IP =InetAddress.getLocalHost().getHostAddress();
       DbConnectivity b1 = new DbConnectivity();
		b1.insert( fileName,IP,0,FOLDER_PATH);
		
		lock l = new lock();
        l.lock_file(fileName);
		
       return "File Upload Successfully !!";
   }
}