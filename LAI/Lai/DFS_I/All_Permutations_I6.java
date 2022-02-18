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

	// (1) result����������յĽ����Ҳ�������п��ܵ�����
	// (2) arr ������������ʼ��Ϊ��̬��ֵ�����Ǿ����ݹ�仯�����Զ�̬�������п��ܵ����У�������������ʱ������մ���result��
	// (3) index��ʾ������ߴ�0��ʼ����������λ���Ѿ�ѡ��Ԫ���ˣ�
	// ����ֻ��index���λ�ã���Ŀǰarr�������ѡ����ַ����棬ѡȡһ��
	// index��ʼ��Ϊ0����0λ�ÿ�ʼѡ�����п��ܵ�Ԫ�ط��룬һ��������ȱ����index��Ϊlen-1����lenʱ�Ϳ��Խ����ˡ�
	// Ҫ��Ԫ�ذ�����ȥ���������ѡȡ��stringҪ��Ϊ����

	private static void helper(final List<String> result,final char[] arr, final int pos, TP parent, TP afterParent) {
		if (pos == arr.length) {
			result.add(String.valueOf(arr));
//			System.out.printf("level:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = pos; i < arr.length; i++) {
			swap(arr, pos, i);//��i/n-1���Ѿ���ɣ��ܼ�n-1����level������
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
