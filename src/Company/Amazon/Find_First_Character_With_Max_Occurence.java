package Company.Amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Find_First_Character_With_Max_Occurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"HELLO WORLD!" return L
//		"HO HELLO!" display H
//        int[] result = new int[-9];

		System.out.println(""+findFirst("HELLO WORLD!"));
		System.out.println(""+findFirst("HO HELLO!"));
		System.out.println(""+findFirst("EH HELOLO!"));
	}
	
//	寻找第一个出现次数最多的字符，map类似的机制来统计个数是必须的
//	到底需要不需要LinkedHashMap，就要看：
//	返回出现次数最多的字符中的第一个字符：位置处于第一个的字符还是第一个达到最多出现次数的字符	

	//good, solution,
		private static Character findFirst(String str) {
			// TODO Auto-generated method stub
			int max = 0;
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
			for(Character ch : str.toCharArray()){
				if(!map.containsKey(ch)){
					map.put(ch, 1);
					max = Math.max(max, 1);
				}else{
					map.put(ch, map.get(ch)+1);
					max = Math.max(max, map.get(ch));
				}
			}
			Character ch = null;
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				if(entry.getValue() == max){//考点，必须是大于不能是等于
//					max = entry.getValue();
					ch = entry.getKey();
					break;
				}
			}

			return ch;
		}

// solution, 
	private static char findFirst2(String str) {
		// TODO Auto-generated method stub
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		char first = ' ';
		for(Character ch : str.toCharArray()){
			int count = 0;
			if(!map.containsKey(ch)){
				count = 1;
				map.put(ch, 1);
			}else{
				count = map.get(ch)+1;
				map.put(ch, count);
			}
			if(count > max){
				max = count;
				first = ch;
			}
		}
		return first;
	}


}
