package deskCrwl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.mongodb.*;

public class crwl {
	static JSONObject json = new JSONObject();
	public static void main(String[] args) throws IOException, SAXException, TikaException {
		// TODO Auto-generated method stub		
		File folder = new File("C:/PDFs");
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getPath());
		        tikaExtractor(file.getPath());
		    }
		}
	}
	//create file
	
     //file2 = new FileWriter("C:\\tika\\test.json");
     public static File file21 = new File("C:\\tika\\test.json");
	//
		@SuppressWarnings({ "resource", "null" })
		public static void tikaExtractor(String path) throws IOException, SAXException, TikaException{
			File file = new File(path);
		      //Parser method parameters
		      Parser parser = (Parser) new AutoDetectParser();
		      BodyContentHandler handler = new BodyContentHandler();
		      Metadata metadata = new Metadata();
		      FileInputStream inputstream = new FileInputStream(file);
		      ParseContext context = new ParseContext();
		      
		      parser.parse(inputstream, handler, metadata, context);
		      System.out.println(handler.toString());

		      //getting the list of all meta data elements 
		      String[] metadataNames = metadata.names();
		      
		      for(String name : metadataNames) {		        
		         System.out.println(name + ": " + metadata.get(name));
		       //to json
			      //			      
			      json.append(name, metadata.get(name));			      
		         //
			      FileWriter file2 = null;
			      file2 = new FileWriter("C:\\tika\\test.json");
			      file2.write(json.toString());
			      file2.flush();		         
		      }		      

		}
		//reader
		//Assume that boy.jpg is in your current directory
	     	}

