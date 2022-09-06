package assessment1;

import java.util.HashMap;
import java.util.Map;

public class JSONParser {
	
	
	/* Static function to convert json String to Map object.
	 * @param json		The JSON String to be converted.
	 * @return			HashMap made from the JSON String.
	 */		
	public static Map<String, Object> parse (String json){
			
		String[] arr = starter(json);
		return parseDoer(arr);
			
	}
	
	/* This is going to be function making the HashMap.
	 * I decided to split the string into an Array of Strings and handle it that way.
	 * 
	 * @param			json here is a split up array of strings.
	 * @return			HashMap object of the converted JSON info.
	 */
	public static Map<String, Object> parseDoer (String[] json){
		Map<String,Object> m = new HashMap<String, Object>();
		String[] arr = json;
		int currin = 1;
		String skey = "";
		String obv = "";
		while(!arr[currin].equals("{") && !arr[currin].equals("}") && currin+2 < arr.length) {
			skey = arr[currin];

			if(arr[currin+1].equals(":")) {
				 obv = arr[currin+2];
				 currin += 2;
			}
			if(!obv.equals("{") && !obv.equals("}")) {

				if(obv.contains(",")) {
					obv = obv.substring(0, obv.indexOf(','));
					
				}
				
				
				try{
		            int number = Integer.parseInt(obv);
		            m.put(skey, number);
		        }
		        catch (NumberFormatException ex){
		        	m.put(skey.toString(), obv.toString()); 
		        	ex.printStackTrace();
		        }
				
				currin++;
			}
			if(obv.equals("{")){
				
				
				m.put(skey, parseDoer(continuer(arr,currin)));
			}
			if(obv.equals("[")) {
				//write function to give back arr from [ to ]
				
			}
			
		}
		if (arr[currin] == "}"){
			return m;		
			}
		
		
		
		return m;
		
	}
	
	
	/* Function to split up a String.
	 * 
	 * @param			String start will be the initial json input
	 * @return			a String array of the json data split by a space bar string.
	 */
	public static String[] starter(String start) {
		String[] holder = start.split(" ");
		
		return holder;
	}
	
	/*	Function to make a new HashMap once an '{' opening bracket is found during the iteration
	 *	 of the original String[] array.
	 * 	@param rest 	String[] of the rest of the original array marked by,
	 * 	@param i		an int noting the current index of traversal before a '{' was reached.	 * 
	 *	@return			ret is a String array of the rest of the json data to be converted.
	 */
	public static String[] continuer(String[] rest, int i) {
		
		String[]pass = rest;
		String[] ret = new String[(rest.length-1) -i];
		for(int j = 0; j < ret.length; j++) {
			ret[j] = pass[i+j];
		}
		
		return ret;
	
	
	
	}
	

}
