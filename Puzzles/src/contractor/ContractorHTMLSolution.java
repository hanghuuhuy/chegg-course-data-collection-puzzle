package contractor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import common.Solution;
import common.WebBrowserRecord;

import employer.SolutionEvaluator;

public class ContractorHTMLSolution extends Solution {
	
	
	public ContractorHTMLSolution(){
		super("Put your oDesk email here");
	}
	
	
	
	/* You should write your code in the overridden runSolution() method.
	 * Your code should parse all the web browsers 
	 * -----------------------------------------------------------
	 * Here are the fields you need to parse for each web browser:
	 * -----------------------------------------------------------
	 * 		- Browser Name 	(String)
	 * 		- Creator	   	(String)
	 * 		- Cost			(String)
	 * 		- License Type 	(String)
	 * 		- Layout Engine (String)
	 * ------------------------------------------------------------
	 * Tips:
	 * --------
	 * 	[*] You should create a WebBrowserRecord instance for each parsed web browser
	 *  [*] The returned array list should contain all the browsers in the input html page (webbrowsers.html)
	 *  [*] inputFile parameter holds a reference of the File Object of webbrowsers.html
	 *  [*] You can use Regex or any technique you want to parse the file
	 */
	
	@Override
	public ArrayList<WebBrowserRecord> runSolution(File inputFile) { 
		
		//initializes the web browser list
		ArrayList<WebBrowserRecord> results = new ArrayList<WebBrowserRecord>();
		
		/* your code goes here.
		* 
		* for each web browser in the html file (webbrowsers.html) you should do:
		* -----------------------------------------------------------------------
		*	WebBrowserRecord wbr = new WebBrowserRecord();
		*	wbr.setName("name")
		*	wbr.setCost("cost")
		*	wbr.setCreator("creator")
		*	wbr.setLicense("license")
		*	wbr.setLayoutEngine("layout engine");
		*	results.add(wbr)
		*/
		
		try {
			Document doc = Jsoup.parse(inputFile, "UTF-8");
			
			Elements rows = doc.select("table[class=wikitable sortable jquery-tablesorter] > tbody > tr");
			
			for (Element row: rows) {
				
				WebBrowserRecord wbr = new WebBrowserRecord();
				
				Element cell0 = row.select("th").first();
				String name = cell0.text();
				
				Elements cells = row.select("td");
				String cost = cells.get(1).text();
				String creator = cells.get(0).text();
				String license = cells.get(2).text();
				String layoutEngine = cells.get(3).text();
				
				System.out.println("name=" + name);
				System.out.println("creator=" + creator);
				System.out.println("cost=" + cost);
				System.out.println("license=" + license);
				System.out.println("layoutEngine=" + layoutEngine);
				
				wbr.setName(name);
				wbr.setCost(cost);
				wbr.setCreator(creator);
				wbr.setLicense(license);
				wbr.setLayoutEngine(layoutEngine);
				results.add(wbr);	
			}
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return results;
	}

	public static void main(String [] args)throws Exception {
		System.out.println("Evaluating contractor's solution against model.");
		System.out.println("Max score is 1.0. Min score is 0.0.");
		List<WebBrowserRecord> actual = new ContractorHTMLSolution().runSolution(new File("resources/webbrowsers.html"));
		SolutionEvaluator s = new SolutionEvaluator();
		List<WebBrowserRecord> expected = s.readFromFile(new File("resources/model2.ser"));
		System.out.println(s.evaluate(expected, actual)); // this will run your code
	}
	


}
