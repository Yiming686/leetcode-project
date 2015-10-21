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
//	��˼·������ַ���s���иÿ���ֶ�Ҫ�Գƣ�
    public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		partitionHelper(result, list, s, 0 );
		return result;
	}
//    ��˼·�������⻯ΪС���⣬��ģ��һ
//    result ���ܵĽ�����仯��
//    listÿһ���ڵ��ֵ��˳�򼯺ϣ������������������result��
//    s��Զ���䣬��pos����ʾ�仯����Χ��0�����ȱ仯������ͨ���±귶Χ
//    �����ĺ��弴Ϊ���ַ���s����pos��ʼ�����и
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
	
	// subset����ı仯
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
