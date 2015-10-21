package LeetCode.JavaArray;

import java.util.Arrays;

import LeetCode.ArrayBuilder;
import LeetCode.ArrayPrinter;

/*
 * ����һ���������飬�ܷ��ҳ����е�������ʹ�����ǵĺ�Ϊһ������������
 * ���룺�������飬����
 * �����true or false
 * 
 * ������to clarify��
 * 1. �������ź������ Is this array sorted?
 * ��������ģ���ô�죿������ģ���ô�죿
 * 2.Does this array contain duplicate elements?
 * usually the answer should be no.
 * 
 * ��solutions����ע��������������ֿ��������и���
 *1.�����ƽⷨ����������������ѭ����������ͣ��ҵ��ͷ���true�˳�������Ҳ���������false��TCΪO��n^2��
 *
 *2.��ǰ���򷨣�Ϊ�����Ч�ʣ�������TCΪO��nlogn����
 * note: ������������Ϊ������ں�˳���������ں����򣬲������򣬻��߲��ܶ�ʧ������Ϣ��
 * 
 * 
 * �ƶ���֮�����Ҫ���ҳ���������ʹ�����ǵĺ�Ϊһ�������������ء�
 */
public class LC_001_Two_Sum_III {
	
	public void save(int input){
		
	}
	
	public boolean Test(int target){
		return false;
	}

	// Solution One: TC is O(n^2)
	public static boolean twoSum_ON2(int[] arr, int sum) {
		if (arr == null)
			return false;
		int len = arr.length;
		if (len < 2)
			return false;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] + arr[j] == sum)
					return true;
			}
		}
		return false;
	}

	// TC is O(nlogn)
	public static boolean twoSum(int[] arr, int sum) {
		ArrayPrinter.printIntegerArray(arr);
		Arrays.sort(arr);
		ArrayPrinter.printIntegerArray(arr);
		if (arr == null)
			return false;
		int len = arr.length;
		if (len < 2)
			return false;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			int sumOf2Elements = arr[left] + arr[right];
			if (sumOf2Elements == sum) {
				System.out.printf("%3s %3s %3s %3s \n", left, right, arr[left],
						arr[right]);
				return true;
			} else if (sumOf2Elements < sum) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayBuilder.createIntegerArray_WithDups(1, -18, 1);
		System.out.println(twoSum(arr, -13));
	}

}
