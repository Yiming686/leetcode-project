package Lintcode.Google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class Find_Index_For_Character {
	static Map<Character, TreeSet<Integer>> char2indexesMap = new HashMap<Character,TreeSet<Integer>>();
	static Map<Integer, Character> index2charMap = new HashMap<Integer, Character>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		set(4, 'c');
		set(7, 'c');
		set(7, 'c');
		set(0, 'c');
//		System.out.println(""+char2indexesMap);
//		System.out.println(""+index2charMap);
		System.out.println(""+find('c'));
		set(4, 'h');
		set(7, 'h');
//		System.out.println(""+char2indexesMap);
//		System.out.println(""+index2charMap);
		System.out.println(""+find('h'));
		System.out.println(""+find('c'));
		System.out.println(""+find('d'));
//		System.out.println(""+char2indexesMap);
//		System.out.println(""+index2charMap);
	}




static void set(int index, char c) {
	if (!index2charMap.containsKey(index)) {
		index2charMap.put(index, c);
		TreeSet<Integer> set = char2indexesMap.containsKey(c) ? char2indexesMap.get(c) : new TreeSet<Integer>();
		set.add(index);
		char2indexesMap.put(c, set);
	} else {
		char prevChar = index2charMap.get(index);
		TreeSet<Integer> prevSet = char2indexesMap.get(prevChar);
		prevSet.remove(index);

		index2charMap.put(index, c);
		TreeSet<Integer> currSet = char2indexesMap.containsKey(c) ? char2indexesMap.get(c) : new TreeSet<Integer>();

		currSet.add(index);
		char2indexesMap.put(c, currSet);
	}
}

	static int find(char c) {
			if (!char2indexesMap.containsKey(c)) {
				return -1;
			} else {
				TreeSet<Integer> set = char2indexesMap.get(c);
				return set.first();
			}
		}
	
    static class Point{
        int value;
        int index;
		public Point(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + value;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (value != other.value)
				return false;
			return true;
		}
		
    }

}
