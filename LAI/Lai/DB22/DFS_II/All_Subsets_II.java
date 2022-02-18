package Lai.DB22.DFS_II;

import java.util.ArrayList;
import java.util.List;

public class All_Subsets_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+subSets("abgytygfhhhfhuffhhb"));
		System.out.println(""+subSets("abbc"));
	}

	public static List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arr = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		// sb�������п��ܵ��Ӽ������ս���result����󷵻�result
		//index��0��ʼ������µ�����0--len-1ÿ�������ͬ�ַ���appendȻ��ɾ�����²㼴��ֹ��ֻ��arr����
		helper(result, sb, arr, 0);
		return result;

	}

	private static void helper(List<String> result, StringBuilder sb, char[] arr, int index) {
		// TODO Auto-generated method stub
		if(index == arr.length) {
			String str = sb.toString();
			if(result.contains(str)) {
//				result.add(str + '*');	
			}else {
				result.add(str);
			}
			return;
		}
		sb.append(arr[index]);
		helper(result, sb, arr, index + 1);
		sb.deleteCharAt(sb.length() - 1);
		helper(result, sb, arr, index + 1);
		
	}
	

}
