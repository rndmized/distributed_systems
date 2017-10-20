package ie.gmit.sw.ds.server;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.rmi.Naming;

public class Client {
	public static void main(String[] args) throws Exception{
	
		//Ask the registry running on localhost and listening in port 1099 for the instannce of
				//the MessageService object that is bound to the RMI registry with the name howdayService.
				FileService fs = (FileService) Naming.lookup("rmi://127.0.0.1:1099/fileService");
				
				System.out.println(fs.getFileNames());
				
				String fileName = "serverFile1.txt";
				//Make the remote method invocation. This results in the Message object being transferred
				//to us over the network in serialized form. 
				byte[] file = fs.getFile(fileName);
				
				FileOutputStream stream = new FileOutputStream("clientFiles/" + fileName); 
				stream.write(file);  
				stream.close(); 
				
				String clientFileName = "clientFile1.txt";
				byte[] uploadFile = Files.readAllBytes(new File("clientFiles/" + clientFileName).toPath());
				fs.uploadFile("upload.txt", uploadFile);
				
				System.out.println(fs.getFileNames());
	}

}
