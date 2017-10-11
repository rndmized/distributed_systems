package ie.gmit.sw.ds;

import java.net.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import java.io.*;

public class OrderClient {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JAXBException {
		String allOrdersAsBytecodes = "bytecodes>>orders>>null";
		String getOrderAsBytecodes = "bytecodes>>getOrder>>AAA-123";
		String allOrdersAsXML = "xml>>orders>>null";
		String getOrderAsXML = "xml>>getOrder>>AAA-123";
		JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
		PurchaseOrder po = new PurchaseOrder();
		
		
		try{
			System.out.println("------------ All Orders in XML Format ----------------");
			Unmarshaller um = jc.createUnmarshaller();
			StringReader sr = new StringReader((String) getResponse(allOrdersAsXML));
			po = (PurchaseOrder) JAXBIntrospector.getValue(um.unmarshal(sr));
			System.out.println(po);

			
		}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public static Object getResponse(String request) throws Exception{
		Socket s = new Socket("127.0.0.1", 9999);
		ObjectOutputStream output= new ObjectOutputStream(s.getOutputStream());
		output.writeObject(request);
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		Object response =  in.readObject();		
		s.close();
		return response;
	}
	
}
