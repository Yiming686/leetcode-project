package Lai.DFS_I;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class All_Permutations_I5 {


	public static void main(String[] dargs) {
		String str = "ABC";
		System.out.println("" + permutations(str));
	}

	public static List<String> permutations(String str) {
		List<String> result = new ArrayList<>();
		char[] arr = str.toCharArray();
		TP tracingPara = TP.build("[result:level]","111",null, result, String.valueOf(arr), 0);
		helper(result, arr, 0, tracingPara);
		tracingPara.print();
		System.out.println("result: "+result);
		return result;
	}

	// (1) result存放所有最终的结果，也就是所有可能的排列
	// (2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	// (3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	// 所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	// index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	// 要将元素搬来搬去，还能随机选取，string要变为数组

	private static void helper(List<String> result, char[] arr, int level, TP parent) {
		if (level == arr.length) {
			result.add(String.valueOf(arr));
//			System.out.printf("level:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = level; i < arr.length; i++) {
			swap(arr, level, i);//第i/n-1步已经完成，总计n-1步，level是索引
			helper(result, arr, level + 1, TP.build(parent, result, String.valueOf(arr), level+1 ));
//			System.out.printf("arr: %s, level: %s, i: %s \n", String.valueOf(arr) ,level,i);
			swap(arr, level, i);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
