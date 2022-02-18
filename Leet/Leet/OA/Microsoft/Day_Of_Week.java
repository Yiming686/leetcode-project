package Leet.OA.Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Day_Of_Week {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+solution("Wed", 2));
		System.out.println(""+solution("Sat", 23));
	}
	public static String solution(String str, int k){
	    String[] week = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	    Map<String, Integer> map = new HashMap<>();
	    for(int i = 0; i < 7; i ++){
	        map.put(week[i], i);
	    }
	    return week[(map.get(str) + k) % 7];
	}

}
