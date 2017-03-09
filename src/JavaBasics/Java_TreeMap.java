package JavaBasics;

import java.util.Map;
import java.util.TreeMap;

public class Java_TreeMap {

	public static void main(String[] args) {
		int [] arr = {1,2,2,2,2,6};
		
		Map<String, Integer> map = new TreeMap<>();
		map.put("Google", 100);
		map.put("Data", 105);
		map.put("Apple", 200);
		
		System.out.println(""+map);
//		map.put(key, value)
	}

	
}
