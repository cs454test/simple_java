package deskCrwl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class data_dump {

	public static void main(String[] args) throws IOException {
		
		File folder = new File("C://tika//");
		File[] listOfFiles = folder.listFiles();
		String path;
		String line = null;
		for (File fl : listOfFiles) {
		///
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(fl));
		 
		  StringBuffer stringBuffer = new StringBuffer();
		  
		 
		  while((line =bufferedReader.readLine())!=null){
		 
		   stringBuffer.append(line).append("\n");
		  }
		   
		  System.out.println(stringBuffer);
		 }
		
	}

}

