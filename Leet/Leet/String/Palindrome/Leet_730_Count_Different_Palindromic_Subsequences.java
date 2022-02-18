package Leet.String.Palindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet_730_Count_Different_Palindromic_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "bccb";
		System.out.println("" + countPalindromicSubsequences(str));
	}


//	����֪��ÿһ���ַ��������ַ�����һ������λ�ã�
//	Ȼ�������һ�����䣬��ָ������������Զ�������ַ��ľ���
//	����С���Ӷ��Ƕ��٣�
//	2  3  5  9 13 19
//	0, 1, 2, 3, 4, 5,
//	[3, 19]
//	[5,13]
//	class Node{
//		
//	}
//	Time: O(n^2)
//	Leet_647_Palindromic_Substrings ���涼�����index unique�ģ���������
//	�𰸣����ǣ�����bccb��'b', 'c', 'bb', 'cc', 'bcb', 'bccb'�����Կ���������bֻ������һ�Σ�û������
//	��ô����������index unique���أ���ô�����أ�
	public static int countPalindromicSubsequences(String str) {
//		public static int countPalindromicSubsequences_n_2_c(String str) {
		int mod = 1000000007;
		char[] arr = str.toCharArray();
		int len = str.length();
		int[] rightClosest = new int[len];//given i, find right closest char
		int[] leftClosest = new int[len];//given i, find left closest char
		Arrays.fill(rightClosest, len);
		Arrays.fill(leftClosest, -1);
//	         index to indexList
		Map<Character, Integer> char2LeftClosestMap = new HashMap<>();
        Map<Character, Integer> char2RightClosestMap = new HashMap<>();
		for (int i = 0; i < len; i++) {            
            Integer leftClosestIndex = char2LeftClosestMap.get(arr[i]);
            leftClosest[i] = leftClosestIndex == null ? -1 : leftClosestIndex;
            char2LeftClosestMap.put(arr[i], i);
		}
		for (int i = len - 1; i >= 0; i--) {
            Integer rightClosestIndex = char2RightClosestMap.get(arr[i]);
            rightClosest[i] = rightClosestIndex == null ? len : rightClosestIndex;
            char2RightClosestMap.put(arr[i], i);
		}

		int[][] count = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			count[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					count[i][j] = count[i + 1][j - 1] * 2;
					int left = rightClosest[i];//right closest
					int right = leftClosest[j];//left cloest
					if (left == right) {
						count[i][j] += 1;
					} else if (left > right) {
						count[i][j] += 2;
					} else {
						count[i][j] -= count[left + 1][right - 1];
					}
				} else {
					count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];
				}
				count[i][j] = count[i][j] < 0 ? count[i][j] + mod : count[i][j] % mod;
			}
		}
		return count[0][len - 1];
	}

//	public static int countPalindromicSubsequences(String str) {
		public static int countPalindromicSubsequences_n_2_b(String str) {
		int mod = 1000000007;
		char[] arr = str.toCharArray();
		int len = str.length();
		int[] rightClosest = new int[len];//given i, find right closest char
		int[] leftClosest = new int[len];//given i, find left closest char
		Arrays.fill(rightClosest, len);
		Arrays.fill(leftClosest, -1);
//	         index to indexList
//		Map<Character, ArrayList<Integer>> char2ListMap = new HashMap<>();
//		Map<Integer, Integer> indexOfArr2IndexOfListMap = new HashMap<>();
//		for (int i = 0; i < len; i++) {
//			ArrayList<Integer> list = char2ListMap.getOrDefault(arr[i], new ArrayList<>());
//			list.add(i);
//			char2ListMap.put(arr[i], list);
//			indexOfArr2IndexOfListMap.put(i, list.size() - 1);
//		}
//		for (int i = 0; i < len; i++) {
//			int indexOfList = indexOfArr2IndexOfListMap.get(i);
//			ArrayList<Integer> list = char2ListMap.get(arr[i]);
//			int prev = indexOfList == 0 ? -1 : list.get(indexOfList - 1);
//			int next = indexOfList == list.size() - 1 ? len : list.get(indexOfList + 1);
//			leftClosest[i] = prev;
//			rightClosest[i] = next;
//		}
		
		Map<Character, Integer> char2LeftClosestMap = new HashMap<>();
        Map<Character, Integer> char2RightClosestMap = new HashMap<>();
		for (int i = 0; i < len; i++) {            
            Integer leftClosestIndex = char2LeftClosestMap.get(arr[i]);
            leftClosest[i] = leftClosestIndex == null ? -1 : leftClosestIndex;
            char2LeftClosestMap.put(arr[i], i);
		}
		for (int i = len - 1; i >= 0; i--) {
            Integer rightClosestIndex = char2RightClosestMap.get(arr[i]);
            rightClosest[i] = rightClosestIndex == null ? len : rightClosestIndex;
            char2RightClosestMap.put(arr[i], i);
		}

		int[][] count = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			count[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					count[i][j] = count[i + 1][j - 1] * 2;
					int left = rightClosest[i];//right closest
					int right = leftClosest[j];//left cloest
					if (left == right) {
						count[i][j] += 1;
					} else if (left > right) {
						count[i][j] += 2;
					} else {
						count[i][j] -= count[left + 1][right - 1];
					}
				} else {
					count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];
				}
				count[i][j] = count[i][j] < 0 ? count[i][j] + mod : count[i][j] % mod;
			}
		}
		return count[0][len - 1];
	}

//	public static int countPalindromicSubsequences(String str) {
	public static int countPalindromicSubsequences_n_2(String str) {
		int mod = 1000000007;
		char[] arr = str.toCharArray();
		int len = str.length();
		int[] leftMost = new int[len];//given i, find right closest char
		int[] rightMost = new int[len];//given i, find left closest char
		Arrays.fill(leftMost, len);
		Arrays.fill(rightMost, -1);
		for (int i = 0; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == arr[i]) {
					rightMost[i] = j;
					break;
				}
			}
			for (int j = i + 1; j < len; j++) {
				if (arr[j] == arr[i]) {
					leftMost[i] = j;
					break;
				}
			}
		}
		int[][] count = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			count[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					count[i][j] = count[i + 1][j - 1] * 2;
					int left = leftMost[i];
					int right = rightMost[j];
					if (left == right) {
						count[i][j] += 1;
					} else if (left > right) {
						count[i][j] += 2;
					} else {
						count[i][j] -= count[left + 1][right - 1];
					}
				} else {
					count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];
				}
				count[i][j] = count[i][j] < 0 ? count[i][j] + mod : count[i][j] % mod;
			}
		}
		return count[0][len - 1];
	}

//	Time: O(n*n*n)
	public static int countPalindromicSubsequences_n_3(String str) {
		int mod = 1000000007;
		int len = str.length();
		int[][] count = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			count[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count[i][j] = count[i + 1][j - 1] * 2;
					int l = i + 1;
					int r = j - 1;
					while (l <= r && str.charAt(l) != str.charAt(i)) {
						l++;
					}
					while (l <= r && str.charAt(r) != str.charAt(i)) {
						r--;
					}
					if (l == r) {
						count[i][j] += 1;
					} else if (l > r) {
						count[i][j] += 2;
					} else {
						count[i][j] -= count[l + 1][r - 1];
					}
				} else {
					count[i][j] = count[i + 1][j] + count[i][j - 1] - count[i + 1][j - 1];
				}
				count[i][j] = count[i][j] < 0 ? count[i][j] + mod : count[i][j] % mod;
			}
		}
		return count[0][len - 1];
	}

}

/*
 * 
 * Base Case: count[i][i] = 1, count[i][i+1] = 2 , case 1: if arr[i] == arr[j] =
 * 2, case 2: if arr[i] != arr[j] Induction Rule: count[i][j] = case1 + case2 =
 * case1.1+ case1.2 + case2�� part1 == count[i+1][j], case 1: do not pick arr[i]
 * part1.1 == count[i+1][j-1], case 1: do not pick arr[j] part1.2 case 2: pick
 * arr[j] part2 case 2: pick arr[i] OR count[i][j] = case1 + case2 = case1.1+
 * case1.2 + case2���� part1 == count[i][j-1], case 1: do not pick arr[j] part1.1
 * == count[i+1][j-1], case 1: do not pick arr[i] part1.2 case 2: pick arr[i]
 * part2 case 2: pick arr[j]
 * 
 * count[i][j] = count[i+1][j] + count[i][j-1] - count[i+1][j-1], case 1: if
 * arr[i] != arr[j], add +arr[i],+arr[j]
 * 
 * = 2 , case 1: case 2: if arr[i] == arr[j]
 * 
 * 
 * �������� dp[i][j] = s[i,j]���ַ����������Ĳ�ͬpalindrome���� A: ������β�ַ�����ͬ�������������ֻ��һ�֣�
 * 
 * dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
 * 
 * B: ������β�ַ���ͬ�Ĵ��࣬����������ϸ�������
 * 
 * 1. �м䲿�ֲ�������β�ַ������������򵥣�����"bccb", ��count("bccb") = count("cc")*2 + 2,
 * Ҳ����dp[i][j] = dp[i+1][j-1] * 2 + 2. ���Զ�����Ϊÿ��ԭ�ַ���"cc"����ɵĻ��Ķ���������������˰�����bb, ����c
 * -> bcb, cc -> bccb�� �Ӷ��Ǽ������������Լ�������ɵĻ��ģ�b, bb. 2.�м䲿�ֺ���һ����β�ַ������������dp[i][j] =
 * dp[i+1][j-1] * 2 + 1Ϊʲô������������һ�أ���ʵ������Ϊbcbcb���������
 * ����������ɵĻ���b��ԭ��cbc���еĻ���b�ظ��ˣ���������������ʵֻ�����bb��һ���������ģ������Ǽ�һ 3.�м䲿�ֺ������������ϸ���β�ַ���
 * ���������dp[i][j] = dp[i+1][j-1] * 2 - dp[l+1][r-
 * 1]�����l��r�����ҵ��ĵ�һ�������һ����β�ַ����ڵ�index. ���ȳ��Զ���ԭ�򲻱䣬��ôΪʲôҪ��ȥdp[l+1][r-
 * 1]�أ����Ⱥ��������ǲ��ü�һҲ���üӶ�����Ϊԭ�ַ�������϶��������ڵ���β�ַ��ģ� ���Լӽ�ȥ���������µ�������b,
 * bb���ֻ��ġ�Ȼ��ΪʲôҪ���أ���Ϊ���ǳ��Զ���ʱ�򣬾����ڰ�ԭ�����п��ܵĻ���������ٰ�����β�ַ���
 * ����Ϊ�������Ҹ��ַ��������Ļ��������Ѿ�����һ���ڲ����еĻ��İ��ϸ��ַ����������»��ģ���ô�����ٸ�֮ǰ�Ĵ𰸰��Ͼͻ�����ظ��� ������
 * babacabab, ����������Ǽ���count("babacabab") = 2*count("abacaba") - count("aca"),
 * ��Ϊ��count(��bacab��)��������棬 ����������"aca"���߰�����bb��ɡ�bacab"��������ˣ����Բ���Ҫ�ظ����㡣
 * 
 * 
 */
