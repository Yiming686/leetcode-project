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

	// (1) result����������յĽ����Ҳ�������п��ܵ�����
	// (2) arr ������������ʼ��Ϊ��̬��ֵ�����Ǿ����ݹ�仯�����Զ�̬�������п��ܵ����У�������������ʱ������մ���result��
	// (3) index��ʾ������ߴ�0��ʼ����������λ���Ѿ�ѡ��Ԫ���ˣ�
	// ����ֻ��index���λ�ã���Ŀǰarr�������ѡ����ַ����棬ѡȡһ��
	// index��ʼ��Ϊ0����0λ�ÿ�ʼѡ�����п��ܵ�Ԫ�ط��룬һ��������ȱ����index��Ϊlen-1����lenʱ�Ϳ��Խ����ˡ�
	// Ҫ��Ԫ�ذ�����ȥ���������ѡȡ��stringҪ��Ϊ����

	private static void helper(List<String> result, char[] arr, int level, TP parent) {
		if (level == arr.length) {
			result.add(String.valueOf(arr));
//			System.out.printf("level:arr %d:%s \n", level, new String(arr));
			return;
		}
		for (int i = level; i < arr.length; i++) {
			swap(arr, level, i);//��i/n-1���Ѿ���ɣ��ܼ�n-1����level������
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
