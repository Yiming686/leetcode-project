package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 ��ȡ���� 1234
 �����ֵ䣬��һ��Ĩȥ�ո���ַ�������ȡ��ȫ�����ʡ�
 ���磬��thisisasentence��=> ��this is a sentence����
 */
public class LC_000_String_To_Sentence {

	// ����ǵݹ�ⷨ
	// input������String
	// d ���ֵ�
	// memorized��input��res Map
	static ArrayList<String>  tokenizeString(String input, HashSet<String> d,
			HashMap<String, ArrayList<String>> memorized) {
		System.out.printf(" IN:input=%s,memorized=%s  \n", input, memorized);

		ArrayList<String> res = new ArrayList<String>();
		if (input == null || input.length() == 0)
			return res;
		// ���ѱ���Ľ�����ҳ���ȡ��ĵ��ʣ��ӿ���ȡ�ٶ�
		if (memorized.containsKey(input))
			return memorized.get(input);
		if (d.contains(input))
			res.add(input); // �������������һ�����ʣ����������
		int len = input.length();
		System.out.printf(" IN:input=%s, res=%s  \n", input, res);

		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (d.contains(prefix)) {
				// ������ǰ׺��һ�����ʣ��ݹ���ú���
				for (String segSuffix : tokenizeString(input.substring(i, len),
						d, memorized)) {
					System.out.printf("OUT:prefix=%s, segSuffix=%s  \n", prefix, segSuffix);

					if (segSuffix != null) {
						// ������沿��Ҳ����ȡ�����ʣ������������
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
