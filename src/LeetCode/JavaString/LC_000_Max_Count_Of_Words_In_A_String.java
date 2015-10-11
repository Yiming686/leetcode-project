package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import LeetCode.ArrayPrinter;

public class LC_000_Max_Count_Of_Words_In_A_String {

	static int maxCountOfWords_2(String s, HashSet<String> d) {
		if (s == null)
			return -1;
		int len = s.length();
		if (len == 0)
			return 0;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			String subStr = s.substring(0, i + 1);
			if (d.contains(subStr)) {
				dp[i] = 1;
			}
			if (i > 0) {
				dp[i] = Math.max(dp[i - 1], dp[i]);
			}
		}
		System.out.println("  1:" + ArrayPrinter.printIntegerArrayToStr(dp));

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				String subStr = s.substring(i + 1, j + 1);
				if (d.contains(subStr)) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
				dp[j] = Math.max(dp[j - 1], dp[j]);
				System.out.printf("for:%s, i=%2s,j=%2s \n",
						ArrayPrinter.printIntegerArrayToStr(dp), i, j);
			}
		}
		System.out.println("end:" + ArrayPrinter.printIntegerArrayToStr(dp));
		return dp[len - 1];
	}

	// dp[i]的含义搞清楚很重要:从0到i字符串，包含的最大单词数
	// 为什么必须有第一个for循环呢？答案是为了初始化dp[],下面的循环要用到有初始化的dp[]
	// 注释掉也好像可以运行
	static int maxCountOfWords(String s, HashSet<String> d) {
		if (s == null)
			return -1;
		int len = s.length();
		if (len == 0)
			return 0;
		int[] dp = new int[len];
		// ArrayList<Integer> dp = new ArrayList<Integer>(len);
		for (int i = 0; i < len; i++) {
			// dp.add(0);
			String subStr = s.substring(0, i + 1);
			if (d.contains(subStr)) {
				dp[i] = 1;
				// dp.set(i, 1);
			}
		}
		System.out.println("  1:" + ArrayPrinter.printIntegerArrayToStr(dp));

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				String subStr = s.substring(i + 1, j + 1);
				if (d.contains(subStr)) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
					// dp.set(j, Math.max(dp.get(j), dp.get(i) +1));
					System.out.printf("for:%s, i=%2s,j=%2s \n",
							ArrayPrinter.printIntegerArrayToStr(dp), i, j);
				}
			}
		}
		System.out.println("end:" + ArrayPrinter.printIntegerArrayToStr(dp));
		return dp[len - 1];
		// return dp.get(len-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "thisisasentence";
		input = "you7are8hand8somez";
//		input = "youarcc";
		// input = "aaaa";
//		input = "handsomehandsomeaaccrrwr";

		HashSet<String> d = new HashSet<String>();
		d.add("this");
		d.add("that");
		d.add("is");
		d.add("are");
		d.add("a");
		d.add("an");
		d.add("sentence");
		d.add("handsome");
		d.add("some");
		d.add("hand");
		d.add("you");
		System.out.println(maxCountOfWords_2(input, d));

	}
}
