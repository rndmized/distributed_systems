package ie.gmit.sw.ds.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class FileSeverSetup {

	public static void main(String[] args) throws Exception{
		
		FolderReader fr = new FolderReader("serverFiles");
		ArrayList<String> file_list = (ArrayList<String>) fr.getList();
		
		FileService fs = new FileServiceImplementation(file_list);
		
		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
		//Bind our remote object to the registry with the human-readable name "fileServer"
		Naming.rebind("fileService", fs);
		//Print a nice message to standard output
		System.out.println("Server ready.");
		
	}
	
}
