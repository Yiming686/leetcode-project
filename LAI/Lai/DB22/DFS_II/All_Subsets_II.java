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
		// sb遍历所有可能的子集，快照进入result，最后返回result
		//index从0开始逐层向下递增，0--len-1每层遍历不同字符，append然后删除，下层即终止，只有arr不变
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
