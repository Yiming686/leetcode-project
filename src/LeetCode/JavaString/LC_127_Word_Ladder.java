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
		
		HashSet<String> visitedWordSet = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		visitedWordSet.add(start);

		int minLen = 1;

		while (!queue.isEmpty()) {
			minLen++;
			// System.out.println(minLen);
			int size = queue.size();
			// traverse words in the same layer
			// System.out.printf("sizse=%s, %s\n", size, queue);
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				dict.remove(word);//����֮����������һ�䣬very positive,нˮ����2��
				// process
				ArrayList<String> list = getNextWords(word, dict);
				for (String nextWord : list) {
					if (nextWord.equals(end)) {
						return minLen;
					}
					if (visitedWordSet.contains(nextWord)) {
						continue;
					}
					visitedWordSet.add(nextWord);
					System.out.println(""+visitedWordSet);
					queue.offer(nextWord);
				}
			}
		}
//		System.out.println(""+set);
		return 0;
	}

	// get connections with given word.
	// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	// it will return ['hit', 'hog']
	// һ���������ֵ�����
	private static ArrayList<String> getNextWords(String word, Set<String> dict) {
		ArrayList<String> nextWords = new ArrayList<String>();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < word.length(); i++) {
				if (ch == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, ch);
				if (dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;

	}

	// replace character of a string at given index to a given character
	// return a new string
	private static String replace(String s, int index, char ch) {
		char[] arr = s.toCharArray();
		arr[index] = ch;
		return new String(arr);
	}

//		 //jiuzhang solution, worked
//		 //after add"dict.add(end);"
//		public static int ladderLength(String start, String end, Set<String> dict) {
//			if (dict == null || dict.size() == 0) {
//				return 0;
//			}
//			dict.add(end);// �Ž��ʵ�Ŷ���
//	
//			HashSet<String> set = new HashSet<String>();
//			Queue<String> queue = new LinkedList<String>();
//			queue.offer(start);
//			set.add(start);
//	
//			int length = 1;
//			while (!queue.isEmpty()) {
//				length++;// ���������������ӣ�����˵���ǲ���
//				int size = queue.size();// ��ǰ���Ԫ�ظ���
//				// ��ʼ������������ÿһ�β�����Ԫ��
//				for (int i = 0; i < size; i++) {
//					// �����ò��һ��Ԫ��
//					String word = queue.poll();
//					// �����Ԫ�ؽ��д�����һ������ֵ������һ������Ԫ�أ�����ע�����˫���ϵ
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
//			// ����ÿһ����ĸ��һλһλ��ǰ���󣬼�ⵥ��ÿһ���ַ�
//			for (char c = 'a'; c <= 'z'; c++) {
//				for (int i = 0; i < word.length(); i++) {
//					// �����ȣ�����
//					if (c == word.charAt(i)) {
//						continue;
//					}
//					// ������ȣ��滻��Ȼ��鿴�Ƿ����ֵ����棬���ڣ���������
//					String nextWord = replace(word, i, c);
//					if (dict.contains(nextWord)) {
//						nextWords.add(nextWord);
//					}
//				}
//			}
//			return nextWords;
//		}

}
