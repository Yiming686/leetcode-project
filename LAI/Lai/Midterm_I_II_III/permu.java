package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;

public class permu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
//		permutations(str);
		System.out.println("" + permutations(str));
	}

	public static List<String> permutations(String str) {
		// Write your solution here
		List<String> result = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();
		String sb = new String();
		char[] arr = str.toCharArray();
		TP tracingPara = TP.build("[result:level]","0001",null, result, String.valueOf(arr), 0, sb.toString());
		helper(result, arr, 0, sb, tracingPara);
		tracingPara.print();

		return result;
	}

	// (1) result����������յĽ����Ҳ�������п��ܵ�����
	// (2) arr ������������ʼ��Ϊ��̬��ֵ�����Ǿ����ݹ�仯�����Զ�̬�������п��ܵ����У�������������ʱ������մ���result��
	// (3) index��ʾ������ߴ�0��ʼ����������λ���Ѿ�ѡ��Ԫ���ˣ�
	// ����ֻ��index���λ�ã���Ŀǰarr�������ѡ����ַ����棬ѡȡһ��
	// index��ʼ��Ϊ0����0λ�ÿ�ʼѡ�����п��ܵ�Ԫ�ط��룬һ��������ȱ����index��Ϊlen-1����lenʱ�Ϳ��Խ����ˡ�
	// Ҫ��Ԫ�ذ�����ȥ���������ѡȡ��stringҪ��Ϊ����

	private static void helper(List<String> result, char[] arr, int level,String sb , TP parent) {
		if (level == arr.length) {
			result.add(sb);
			return;
		}
//		sb.append(arr[level]);
		String temp1 = sb;
		sb += arr[level];
		if(level != arr.length -1) {
//			sb.append("_");
			String temp2 = sb;
			sb += "_";
			helper(result, arr, level + 1, sb, TP.build(parent, result, String.valueOf(arr), level + 1, sb.toString()));
			sb = temp2;
//			sb.deleteCharAt(sb.length() - 1);
		}
		helper(result, arr, level + 1, sb, TP.build(parent, result, String.valueOf(arr), level + 1, sb.toString()));
		sb = temp1;
//		sb.deleteCharAt(sb.length() - 1);
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
