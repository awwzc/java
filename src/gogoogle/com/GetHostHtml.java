package gogoogle.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.entity.mime.content.FileBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetHostHtml {
	private static String  hostHtmlURL = "http://www.360kb.com/kb/2_150.html";
	private  String hostContent = new String();
	
	public static String  getHtml(){
		String html = "";
		try {
			Document doc = Jsoup.connect(hostHtmlURL).get();
			Element div = doc.select("div.v_story").first();
			Element pre = div.select("div").first();
			html = pre.html().substring(pre.html().indexOf("#google-hosts-2015"),pre.html().indexOf("</pre>"));
			System.out.println(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return html; 
	}
	
	public static void main(String[] args) {
		 String hostContent = getHtml();
		 File host = new File("c:\\windows\\system32\\drivers\\etc\\hosts");
		 StringBuilder  sb = new StringBuilder();
		 try {
			FileReader fr = new FileReader(host);
			BufferedReader bf = new BufferedReader(fr);
			try {
				String str = null;
				while((str=bf.readLine())!=null){
					sb.append(str);
				}
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 System.out.println(sb.toString());
	//	 sb.replace(sb.indexOf("#google-hosts-2015")-1, sb.indexOf("#google-hosts-2015-end")+1, hostContent);
	//	 System.out.println("================================================================");
	//	 System.out.println(sb.toString());
/*		 try {
			FileWriter ft = new FileWriter(host,true);
		    ft.write(sb.toString());;
			ft.flush();
			ft.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		 
	*/	 
	}
	
}
