package deskCrwl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.uwyn.jhighlight.tools.FileUtils;


public class urlJsoup {	
		
		static String inputLink="http://onlineconvert-free.com";
		static String title;
		static ArrayList<String> urls=new ArrayList<String>();    
		public void run(String link)
		{
			Document doc = null;
			try {
				doc = Jsoup.connect(link).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			    
			Elements elts = doc.select("a[href]");
			
			for (Element link1 : elts) {                
                // 
				///System.out.println("\nlink : " + link.attr("href"));
				//System.out.println("text : " + link.text());
				//absolute ********URL
				System.out.println(">>>>>"+link1.attr("abs:href"));
				
				urls.add(link1.attr("abs:href"));
				//for save document
			}
			
				//get doc
				try {					
					//get filename from url
					title=doc.html();			
					String inputUrl = link;
					String file = inputUrl.substring(inputUrl.lastIndexOf('/')+1, inputUrl.lastIndexOf('.'));
					System.out.println(file);
					//Download file
					//new PrintWriter("C://tika//file.html", title);
					Writer writer = new BufferedWriter(new OutputStreamWriter(
						    new FileOutputStream("C://tika//"+file+".html"), "UTF-8"));
					writer.write(title);
					writer.close();
					
					} catch (Exception e) {
						// TODO: handle exception
					}
				
					
					
	}
		//
		public void getDoc() throws IOException
		{
		
			
		}

	public static void main(String[] args) throws IOException 
	{
		urlJsoup urlj=new urlJsoup();
		urlj.run(inputLink);
		//urls.removeAll(urls);
		if(!urls.isEmpty()){
			synchronized (urls) {
				
			
			for (String stringUrl : urls) {
				
				//String stringUrl : urls.subList(1, urls.size())
			
				urlj.run(stringUrl);	
				urls.remove(urls);
				//urlj.getDoc();
			}
			}
			//urls.removeAll(urls);
		}		
		
	}

}


