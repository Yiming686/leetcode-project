package Lai.DFS_I;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;

import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TPB;

public class All_Subsets_I {
	
	public static void main(String[] args) {
//		System.out.println(""+subSets("abc"));
		System.out.println(""+subSets("abc"));
	}

	public static List<String> subSets(String set) {
		// Write your solution here.
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arr = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		// sb遍历所有可能的子集，快照进入result，最后返回result
		//index从0开始逐层向下递增，0--len-1每层遍历不同字符，append然后删除，下层即终止，只有arr不变
		
		TP paraRoot = TP.build("[sb:level]",  "0100", null, result, sb, String.valueOf(arr), 0);
		helper(result, sb, arr, 0, paraRoot);
		paraRoot.print();
		System.out.println("result: "+ result);
		return result;

	}

	private static void helper(List<String> result, StringBuilder sb, char[] arr, int pos, TP paraRoot) {
		if (pos == arr.length) {
			result.add(sb.toString());
			return;
		}
		sb.append(arr[pos]);
		helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));
		sb.deleteCharAt(sb.length() - 1);
		helper(result, sb, arr, pos + 1, TP.build(paraRoot, result, sb, String.valueOf(arr), pos + 1));

	}

}
