package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC_127_Word_Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		String[] arr = { "hot", "dot", "dog", "lot", "log" };
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(arr));
		// System.out.println(start);
		// System.out.println(end);
		// System.out.println(dict);
		// System.out.println("-----------");
		System.out.println(ladderLength(start, end, dict));

	}

	//If you can say dict is changing, so you are very positive
	public static int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}
		dict.add(start);
		dict.add(end);
		
		HashSet<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		set.add(start);

		int minLen = 1;

		while (!queue.isEmpty()) {
			minLen++;
			// System.out.println(minLen);
			int size = queue.size();
			// traverse words in the same layer
			// System.out.printf("sizse=%s, %s\n", size, queue);
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				dict.remove(word);//精华之处，有了这一句，very positive,薪水增加2万
				// process
				ArrayList<String> list = getNextWords(word, dict);
				for (String nextWord : list) {
					if (nextWord.equals(end)) {
						return minLen;
					}
					if (set.contains(nextWord)) {
						continue;
					}
					set.add(nextWord);
					queue.offer(nextWord);
				}
			}
		}
		return 0;
	}

	// get connections with given word.
	// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	// it will return ['hit', 'hog']
	// 一定必须在字典里面
	private static ArrayList<String> getNextWords(String word, Set<String> dict) {
		ArrayList<String> nextWords = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;

	}

	// replace character of a string at given index to a given character
	// return a new string
	private static String replace(String s, int index, char c) {
		char[] arr = s.toCharArray();
		arr[index] = c;
		return new String(arr);
	}

//		 //jiuzhang solution, worked
//		 //after add"dict.add(end);"
//		public static int ladderLength(String start, String end, Set<String> dict) {
//			if (dict == null || dict.size() == 0) {
//				return 0;
//			}
//			dict.add(end);// 放进词典才对了
//	
//			HashSet<String> set = new HashSet<String>();
//			Queue<String> queue = new LinkedList<String>();
//			queue.offer(start);
//			set.add(start);
//	
//			int length = 1;
//			while (!queue.isEmpty()) {
//				length++;// 层数，层数的增加，可以说就是层数
//				int size = queue.size();// 当前层的元素个数
//				// 开始逐层遍历，遍历每一次层所有元素
//				for (int i = 0; i < size; i++) {
//					// 弹出该层的一个元素
//					String word = queue.poll();
//					// 对这个元素进行处理，第一步求得字典里面的一步相邻元素，不过注意存在双向关系
//					ArrayList<String> list = getNextWords(word, dict);
//					for (String nextWord : list) {
//						if (set.contains(nextWord)) {
//							continue;
//						}
//						if (nextWord.equals(end)) {
//							return length;
//						}
//	
//						set.add(nextWord);
//						queue.offer(nextWord);
//					}
//				}
//			}
//			return 0;
//		}
//	
//		// replace character of a string at given index to a given character
//		// return a new string
//		private static String replace(String s, int index, char c) {
//			char[] chars = s.toCharArray();
//			chars[index] = c;
//			return new String(chars);
//		}
//	
//		// get connections with given word.
//		// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
//		// it will return ['hit', 'hog']
//		private static ArrayList<String> getNextWords(String word, Set<String> dict) {
//			ArrayList<String> nextWords = new ArrayList<String>();
//			// 根据每一个字母，一位一位从前到后，检测单词每一个字符
//			for (char c = 'a'; c <= 'z'; c++) {
//				for (int i = 0; i < word.length(); i++) {
//					// 如果相等，跳过
//					if (c == word.charAt(i)) {
//						continue;
//					}
//					// 如果不等，替换，然后查看是否在字典里面，若在，加入结果集
//					String nextWord = replace(word, i, c);
//					if (dict.contains(nextWord)) {
//						nextWords.add(nextWord);
//					}
//				}
//			}
//			return nextWords;
//		}

}
