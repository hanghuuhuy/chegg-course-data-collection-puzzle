package employer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.WebBrowserRecord;

public class SolutionEvaluator {

	public SolutionEvaluator() {
		
	}

	
	
	private Map<String, WebBrowserRecord> createMap(List<WebBrowserRecord> list){
		Map<String, WebBrowserRecord> out  = new HashMap<String, WebBrowserRecord>();
		for(WebBrowserRecord r: list){
			if(r != null && r.getName() != null){
				out.put(r.getName(), r);
			}
		}
		return out;
	}
	
	//works independent of the data structure
	public double evaluate(List<WebBrowserRecord> expected, List<WebBrowserRecord> actual) {
		
		Map<String,WebBrowserRecord> actualMap = createMap(actual);
		double score = 0.0;
		for(WebBrowserRecord r: expected){
			WebBrowserRecord a = actualMap.get(r.getName());
			if(a != null ){
				score += r.similarityTo(a);
			}
		}
		
		return score / (double) expected.size();
	}

	
	public void writeToFile(List<WebBrowserRecord> records, File f) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		try {
			oos.writeObject(records);
		} finally {
			oos.close();
		}
	}
	
	public List<WebBrowserRecord> readFromFile(File f) throws IOException, ClassNotFoundException {
		List<WebBrowserRecord> out = new ArrayList<WebBrowserRecord>();
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			List<?> temp = (List<?>) ois.readObject();
			for(Object o: temp){
				out.add((WebBrowserRecord) o);
			}
		} finally {
			ois.close();
		}
		return out;
	}
	

}
