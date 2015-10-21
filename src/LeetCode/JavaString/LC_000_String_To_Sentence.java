package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 提取单词 1234
 根据字典，从一个抹去空格的字符串里提取出全部单词。
 例如，”thisisasentence”=> “this is a sentence”。
 */
public class LC_000_String_To_Sentence {

	// 这个是递归解法
	// input是输入String
	// d 是字典
	// memorized是input，res Map
	static ArrayList<String>  tokenizeString(String input, HashSet<String> d,
			HashMap<String, ArrayList<String>> memorized) {
		System.out.printf(" IN:input=%s,memorized=%s  \n", input, memorized);

		ArrayList<String> res = new ArrayList<String>();
		if (input == null || input.length() == 0)
			return res;
		// 从已保存的结果中找出提取后的单词，加快提取速度
		if (memorized.containsKey(input))
			return memorized.get(input);
		if (d.contains(input))
			res.add(input); // 如果整个串就是一个单词，将其加入结果
		int len = input.length();
		System.out.printf(" IN:input=%s, res=%s  \n", input, res);

		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (d.contains(prefix)) {
				// 如果这个前缀是一个单词，递归调用函数
				for (String segSuffix : tokenizeString(input.substring(i, len),
						d, memorized)) {
					System.out.printf("OUT:prefix=%s, segSuffix=%s  \n", prefix, segSuffix);

					if (segSuffix != null) {
						// 如果后面部分也能提取出单词，将其加入结果中
						res.add(prefix + " " + segSuffix);
					}
				}
			}
		}
		memorized.put(input, res);
		System.out.printf("OUT:input =%s,memorized=%s  \n", input, memorized);
		System.out.printf("OUT:res=%s  \n", res);

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "thisisasentence";
		HashSet<String> d = new HashSet<String>();
		d.add("this");d.add("that");
		d.add("is");d.add("are");
		d.add("a");d.add("an");
		d.add("sentence");
		HashMap<String, ArrayList<String>> memorized = new HashMap<String, ArrayList<String>>();
		ArrayList<String> ab =  tokenizeString(input,  d, memorized);
		System.out.println(ab);
	}
}
