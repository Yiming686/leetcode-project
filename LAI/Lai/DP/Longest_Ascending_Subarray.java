package Lai.DP;

import Utils.ArrayUtils;

public class Longest_Ascending_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArrayNoDup(8,1, 9);
		System.out.println(""+longest(arr));
	}
//��������ϵĻ����ϣ�ÿһ����϶���Ӧһ�����͵ĳ���ֵ������ĳ���
//��Ȼ�������������ϣ�����ֻ�������ֱ�ӵĳ���
	public static int  longest(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int max = 1;
		int localMax = 1;
		for(int i = 1; i < arr.length; i++) {
//			if(arr[i - 1] < arr[i]) {
//				localMax++;
//			}else{
//				localMax = 1;
//			}
			localMax = (arr[i - 1] < arr[i]) ? localMax + 1 : 1;
			System.out.println("i:localMax "+ i+":"+localMax);
			max = Math.max(max, localMax);
		}
		return max;
	}

}
