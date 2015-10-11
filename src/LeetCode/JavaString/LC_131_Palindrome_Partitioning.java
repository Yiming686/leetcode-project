package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.List;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 Hide Tags Backtracking

 * 
 * 
 */
public class LC_131_Palindrome_Partitioning {

//	Accepted
//	【思路】针对字符串s，切割，每部分都要对称，
    public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		partitionHelper(result, list, s, 0 );
		return result;
	}
//    【思路】大问题化为小问题，规模减一
//    result 是总的结果，变化中
//    list每一步节点的值的顺序集合，如果满足条件，加入result中
//    s永远不变，用pos来表示变化，范围从0到长度变化，不是通常下标范围
//    函数的含义即为对字符串s，从pos开始进行切割，
	private void partitionHelper(List<List<String>> result, List<String> list,
			String s, int pos) {
		// TODO Auto-generated method stub
		if (pos == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}

		for (int i = pos + 1; i <= s.length(); i++) {
			String sub1 = s.substring(pos, i);
			if (isPalindrome(sub1)) {
				list.add(sub1);
				partitionHelper(result, list, s, i);
				list.remove(list.size() - 1);
			}
		}
	}
	
	// subset问题的变化
//	Accepted, but not good, see solution above
    public List<List<String>> partition2(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		partitionHelper2(result, list, s, 0, 0 );
		return result;
	}

	private void partitionHelper2(List<List<String>> result, List<String> list,
			String s, int lenOfList, int index) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (lenOfList == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}

		for (int i = index + 1; i <= s.length(); i++) {
			String sub1 = s.substring(index, i);
//			String sub2 = s.substring(i, s.length());

			if (isPalindrome(sub1)) {
				list.add(sub1);
				partitionHelper2(result, list, s, lenOfList + sub1.length(),
						index + sub1.length());
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		// String rev = new StringBuilder(str).reverse().toString();
		// return rev.equals(str);
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException();

		for (int start = 0, end = str.length() - 1; start < end; start++, end--) {
			if (str.charAt(start) != str.charAt(end))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
