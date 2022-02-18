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


//	必须知道每一个字符，其在字符串中一连串的位置，
//	然后给定，一个区间，求指定区间里面最远的两个字符的距离
//	其最小复杂度是多少？
//	2  3  5  9 13 19
//	0, 1, 2, 3, 4, 5,
//	[3, 19]
//	[5,13]
//	class Node{
//		
//	}
//	Time: O(n^2)
//	Leet_647_Palindromic_Substrings 里面都是针对index unique的，这里是吗？
//	答案：不是，比如bccb，'b', 'c', 'bb', 'cc', 'bcb', 'bccb'，可以看出，其中b只计算了一次，没有两次
//	那么如果问是针对index unique的呢？怎么计算呢？
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
 * case1.1+ case1.2 + case2； part1 == count[i+1][j], case 1: do not pick arr[i]
 * part1.1 == count[i+1][j-1], case 1: do not pick arr[j] part1.2 case 2: pick
 * arr[j] part2 case 2: pick arr[i] OR count[i][j] = case1 + case2 = case1.1+
 * case1.2 + case2；； part1 == count[i][j-1], case 1: do not pick arr[j] part1.1
 * == count[i+1][j-1], case 1: do not pick arr[i] part1.2 case 2: pick arr[i]
 * part2 case 2: pick arr[j]
 * 
 * count[i][j] = count[i+1][j] + count[i][j-1] - count[i+1][j-1], case 1: if
 * arr[i] != arr[j], add +arr[i],+arr[j]
 * 
 * = 2 , case 1: case 2: if arr[i] == arr[j]
 * 
 * 
 * 处理方法： dp[i][j] = s[i,j]子字符串所包含的不同palindrome个数 A: 对于首尾字符不相同的情况，处理方法只有一种：
 * 
 * dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
 * 
 * B: 对于首尾字符相同的大类，可能有三种细分情况：
 * 
 * 1. 中间部分不含有首尾字符，这种情况最简单，比如"bccb", 则count("bccb") = count("cc")*2 + 2,
 * 也就是dp[i][j] = dp[i+1][j-1] * 2 + 2. 乘以二是因为每个原字符串"cc"能组成的会文都可以再在外层两端包裹上bb, 比如c
 * -> bcb, cc -> bccb； 加二是加上新增部分自己所能组成的回文：b, bb. 2.中间部分含有一个首尾字符，这种情况是dp[i][j] =
 * dp[i+1][j-1] * 2 + 1为什么比上面的情况少一呢，其实就是因为bcbcb这种情况，
 * 新增的能组成的回文b跟原来cbc就有的回文b重复了，所以新增部分其实只能组成bb这一个新增回文，所以是加一 3.中间部分含有两个或以上个首尾字符。
 * 这种情况是dp[i][j] = dp[i+1][j-1] * 2 - dp[l+1][r-
 * 1]这里的l和r是能找到的第一个和最后一个首尾字符所在的index. 首先乘以二的原因不变，那么为什么要减去dp[l+1][r-
 * 1]呢？首先很明显我们不用加一也不用加二，因为原字符串里面肯定是有现在的首尾字符的， 所以加进去产生不了新的类似于b,
 * bb这种回文。然后为什么要减呢？因为我们乘以二的时候，就是在把原来所有可能的回文最外层再包上首尾字符，
 * 而因为最左最右该字符所包含的回文里面已经算了一遍内部所有的回文包上该字符所产生的新回文，那么我们再给之前的答案包上就会产生重复。 举例：
 * babacabab, 这种情况我们计算count("babacabab") = 2*count("abacaba") - count("aca"),
 * 因为在count(“bacab”)这个串里面， 我们早就算过"aca"两边包裹上bb变成“bacab"这种情况了，所以不需要重复计算。
 * 
 * 
 */
