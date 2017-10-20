package ie.gmit.sw.ds.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class FileServiceImplementation extends UnicastRemoteObject implements FileService {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> file_list;

	public FileServiceImplementation(ArrayList<String> file_list) throws Exception {
		this.file_list = file_list;
	}

	@Override
	public byte[] getFile(String fileName) throws RemoteException {	
		try {
			return Files.readAllBytes(new File("serverFiles/" + fileName).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> getFileNames() throws RemoteException {
		FolderReader fr = new FolderReader("serverFiles");
		file_list = (ArrayList<String>) fr.getList();
		return file_list;
	}

	@Override
	public void uploadFile(String fileName, byte[] file) throws RemoteException {
		
		try {
			FileOutputStream stream = new FileOutputStream("serverFiles/" + fileName); 
			stream.write(file);
			stream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
}
