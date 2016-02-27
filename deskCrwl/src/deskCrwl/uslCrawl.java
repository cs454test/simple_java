package deskCrwl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import org.jsoup.Jsoup;

public class uslCrawl {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		org.jsoup.nodes.Document doc = Jsoup.parse(new URL("www.stackoverflow.com"), 2000);

		org.jsoup.select.Elements resultLinks = doc.select("div.post-title > a");
		for (org.jsoup.nodes.Element link : resultLinks) {
		    String href = link.attr("href");
		    System.out.println("title: " + link.text());
		    System.out.println("href: " + href);
		}
		
	}

}
