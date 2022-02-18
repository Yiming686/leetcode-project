package Lai.String_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

/**
 * Find all occurrence of anagrams of a given string s in a given string l.
 * Return the list of starting indices.
 * 
 * Assumptions
 * 
 * s is not null or empty. l is not null. Examples
 * 
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2
 * starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 *
 * 
 */
public class All_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer num = 7;
//		System.out.println("" + num.toBinaryString(num));
//		System.out.println("" + num);
//		System.out.println("" + (num & 0));
//		System.out.println("" + num);
//		System.out.println("" + num.toBinaryString(~num));
		System.out.println("" + allAnagrams("abc", "abcaaa")); //0, 2, 3
//		String shorter = "abc";
//		String longer = "abcbac";
//		System.out.println("" + allAnagrams(shorter, longer));
//		System.out.println("" + allAnagrams("abc", "abcbac")); //0, 2, 3
//		System.out.println("" + allAnagrams("aab", "ababacbbaac")); //0, 2, 7
	}

//	longer: N, shorter: M
//	Time: O(M+N)        Space: O(M)
	public static List<Integer> allAnagrams(String shorter, String longer) {
		// Write your solution here
		List<Integer> result = new ArrayList<>();
		if (longer == null || longer.length() == 0 || shorter.length() >= longer.length()) {
			return result;
		}
		Map<Character, Integer> map = countMap(shorter);//��¼Anagram��Ψһ��
		int match = 0;//����match�˶��ٸ���ͬ���ַ�
		for (int i = 0; i < longer.length(); i++) {
			char ch = longer.charAt(i);//�õ���ǰ�ַ�
			Integer count = map.get(ch);//����map���滹�м���ʣ���
			if (count != null) {//map������
				map.put(ch, --count);//�õ�һ��������һ��;���һ��Ϊ0
				if (count == 0) {//�����0����ʾ���ַ������ˣ���ʱ����match����ַ��ˡ�����Ϊ���ƣ�
					match++;
				}
			}
			if (i >= shorter.length()) {//�е��ں���
				ch = longer.charAt(i - shorter.length());//ȡ��������ַ�
				count = map.get(ch);//ʣ���˼���
				if (count != null) {
					map.put(ch, ++count);//���ַ��˳�����ô���ַ��Ŀ��ø�������һ������������1
					if (count == 1) {//�����1����ʾ���ַ������ˣ�״̬��Ϊ����һ�����õģ���ʱmatch�����һ
						match--;
					}
				}
			}
			if (match == map.size()) {//map��key��match��
				result.add(i - shorter.length() + 1);//��ô��⣿
			}
		}
		return result;
	}

	private static Map<Character, Integer> countMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}
		return map;
	}

}
