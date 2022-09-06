package assessment1;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Object> m = new HashMap<String, Object>();
		//JSONParser j = new JSONParser;
		
		
		/* The functions written here can only take in a JSON string in the following format with white space
		 * after each { and } before and after each : with commas being immediately after each object.
		 * Only Strings and Integers can be passed through to the final HashMap.
 		 * 
		 */
		String s = "{ \"debug\" : \"on\", \"window\" : { \"title\" : \"sample\", \"size\" : 500 } } ";
		

		
	
		
		
		
		System.out.println(s);
		JSONParser j = new JSONParser();
		
				
		Map<String, Object> output = j.parse(s);
		System.out.println("output is ");
		System.out.println(output);

		for (String name: output.keySet()) {
		    
			String key = name.toString();
		    String value = output.get(name).toString();
		}

		/*
		 * It is worth noting that the Map is constructed using <String, Object> format however
		 * every key entered into the map returns a null object and I cannot figure out why,
		 * so the assertion methods in the prompt document do not work, however when I tried to print
		 * the keys and values in the returned Map they were all either Strings, ints, or HashMaps and
		 * were as predicted from json input.
		 * 
		 */

		
	}

}
