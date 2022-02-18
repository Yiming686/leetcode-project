package Lai.DFS_I;

import static Utils.TreeNodeUtils.toStr;

import java.sql.SQLClientInfoException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import com.sun.javafx.sg.prism.web.NGWebView;
import com.sun.org.apache.xml.internal.security.Init;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;

public class All_Permutations_I6 {


	public static void main(String[] dargs) {
		// TODO Auto-generated method stub
//		Deque<Integer> s1 = new ArrayDeque<Integer>();
//		s1.offerFirst(9);
//		s1.pollFirst();
//		Integer[] arr = {2,3,4};
//		List<Integer> list = Arrays.asList(3,6,9);
//		arr[2] = 66;
//		List<Integer> list2 = Arrays.asList(5,8,4);
//		arr[2] = 99;
//		System.out.println("list:"+list);
//		System.out.println("list:"+list2);
		
//		String str = "UHGT69";
		String str = "ABC";
		System.out.println("" + permutations(str));
	}

	public static List<String> permutations(String str) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		char[] arr = str.toCharArray();
		TP beforeTracingPara = TP.build("[result:level]","111","beforeTracingPara",null, result, String.valueOf(arr), 0);
		TP afterTracingPara = TP.build("[result:level]","101", "afterTracingPara", null);
		helper(result, arr, 4, beforeTracingPara, afterTracingPara);TP.build("afterTracingPara", null, result, StringUtils.toStr(arr), 0);
		beforeTracingPara.print();
		afterTracingPara.print();
		System.out.println("result: "+result);
		return result;
	}

	// (1) result存放所有最终的结果，也就是所有可能的排列
	// (2) arr 单个变量，初始化为静态的值，但是经过递归变化，可以动态遍历所有可能的排列，当符合条件的时候，其快照存入result，
	// (3) index表示它的左边从0开始不包含它的位置已经选好元素了，
	// 所以只给index这个位置，从目前arr里面可能选择的字符里面，选取一个
	// index初始化为0，从0位置开始选择所有可能的元素放入，一个都不能缺，当index变为len-1或者len时就可以结束了。
	// 要将元素搬来搬去，还能随机选取，string要变为数组

	private static void helper(final List<String> result,final char[] arr, final int pos, TP parent, TP afterParent) {
		if (pos == arr.length) {
			result.add(String.valueOf(arr));
//			System.out.printf("level:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = pos; i < arr.length; i++) {
			swap(arr, pos, i);//第i/n-1步已经完成，总计n-1步，level是索引
			helper(result, arr, pos + 1, TP.build(parent, result, String.valueOf(arr), pos+1 ), TP.build("afterParent"+i, afterParent));TP.build("afterParent" + i, afterParent, result, StringUtils.toStr(arr), pos + 1);
//			System.out.printf("arr: %s, level: %s, i: %s \n", String.valueOf(arr) ,level,i);
			swap(arr, pos, i);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
