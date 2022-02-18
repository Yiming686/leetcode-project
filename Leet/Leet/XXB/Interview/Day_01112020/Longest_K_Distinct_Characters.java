package Leet.XXB.Interview.Day_01112020;

import static Utils.TreeNodeUtils.toPrintNullNode;

import java.util.HashMap;
import java.util.Map;

public class Longest_K_Distinct_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "dffaaabbbaabbaaaaffcdffddd";
		String str = "dffaabbbgaabbaahab";
		int k = 2;
		System.out.println(""+longestKthDistinctCha(str, k));
	}
	
	static int longestKthDistinctCha(String str, int k) {
		if(str == null || k < 0) {
			return -1;
		}
		if(str.length() == 0 || k == 0) {
			return 0;
		}
		int globalMax = 1;
		int left = 0;
//		int right = 0; //a sliding window is created here
		Map<Character, Integer> map = new HashMap<>();
		//old left, old map,
		for(int right = 0; right < str.length(); right++) {
			//add new char
			char ch = str.charAt(right);
			Integer count = map.getOrDefault(ch, 0);
			if(map.size() < k) {
				map.put(ch, count + 1);
			}else if (count != null) {//new 
				map.put(ch, count + 1);
			}else {//maintain left and map, 
				while(left != right && map.size() == k ) {
					char leftCh = str.charAt(left);
					int leftCount = map.get(leftCh);
					if(leftCount == 1) {
						map.remove(leftCh);
					}else {
						map.put(leftCh, leftCount - 1);
					}					
					left++;
				}							
			}			
//			update gloalMax with new right and new left
			globalMax = Math.max(globalMax, right - left + 1);
			//update right
		}
		return globalMax;
	}

}
