package Lai.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

public class Alien_Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"zx","zy"};
//		String[] words = {"z","z"};
//		String[] words = {"ab","adc"};
		String[] words = {"wrt","wrf","er","ett","rftt"};
		
		System.out.println("==:"+alienOrder(words));
	}

	public static String alienOrder(String[] words) {
		// Write your solution here
		if (words == null) {
			return null;
		}
		if (words.length == 0) {
			return "";
		}
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> visited = new HashMap<>();
		for (int i = 0; i < words.length - 1; i++) {
			compare(words, i, map, visited);
		}
		// ¿ªÊ¼dfs ±éÀúÍ¼
		String[] max = new String[] {""};
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : visited.entrySet()) {
			if(dfs(max, sb, entry.getKey(), map, visited)) {
				return "";
			}
		}
		return max[0];
	}

	private static boolean dfs(String[] max, StringBuilder sb, Character root, Map<Character, Set<Character>> map,
			Map<Character, Integer> visited) {
		if(root == null) {
			return false;
		}
		if (visited.get(root) == 1) {
			return true;
		}
		if (visited.get(root) == 2) {
			return false;
		}
		visited.put(root, 1);//visiting    
		sb.append(root);
		if(map.get(root) != null) {
			for (Character ch : map.get(root)) {
				sb.append(ch);
				if(dfs(max, sb, ch, map, visited)) {
					return true;
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}else {
			if(sb.length() > max[0].length()) {
				max[0] = sb.toString();
			}
		}
		visited.put(root, 2);
		return false;
	}

	private static void compare(String[] words, int start, Map<Character, Set<Character>> map,
			Map<Character, Integer> visited) {
		for (int i = 0; i < Math.min(words[start].length(), words[start + 1].length()); i++) {
			char ch1 = words[start].charAt(i);
			char ch2 = words[start + 1].charAt(i);
			
			Set<Character> set = map.get(ch1);
			if (set == null) {
				set = new HashSet<Character>();
				map.put(ch1, set);
				visited.put(ch1, 0);
				visited.put(ch2, 0);
			}
			if (ch1 != ch2) {
				set.add(ch2);
				return;
			}
		}
	}

}
