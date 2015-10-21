package JavaBasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Java_Map {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
//		System.out.println(map.size());
//		map.put("eee", 5);
//		System.out.println(map.size());
//		map.put("eee", 9);
//		map.put("eee", 2);
//		System.out.println(map.size());
//		System.out.println(map.get("eee"));
		
		LinkedHashMap<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		map2.put("eee", 5);
		map2.put("eee", 9);
		map2.put("eee2", 2);
		LinkedHashSet<Integer> map3 = new LinkedHashSet<Integer>();
		map3.add(5);
		map3.add(9);
		map3.add( 2);
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(map3.size());
		System.out.println(list.addAll(map3));
		System.out.println(list);
	}

}
