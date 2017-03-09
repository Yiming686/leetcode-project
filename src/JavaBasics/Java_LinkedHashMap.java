package JavaBasics;

import java.util.LinkedHashMap;
import java.util.Map;

public class Java_LinkedHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		map.put(-3, -6);
		map.put(4, 8);
		map.put(2, 4);
		map.put(6, 12);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			System.out.println("k,v: "+entry.getKey() +", "+entry.getValue());
		}
	}

}
