package JavaBasics;

import LeetCode.ArrayPrinter;

public class Java_Bit_Manipulation {

	public static int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				// System.out.printf("i=%s, j=%s\n", i, j);
				// ArrayPrinter.printIntegerArray(bits);
				// ������ȡ����A��Ԫ�ص����һλ����Ϣ�ͣ�Ȼ���3ȡ�࣬����һ��bitλ
				// ��ͨ��򣬾�����ȡ����A��Ԫ�ص����һλ����Ϣ�ͣ�Ȼ���2ȡ��
				// ��ʵ����ͳ���������ֵ�iλ�õĸ�����3*m*0+3*n*1+0����1������
				// �����뷨���˵�3*m*0+3*n*1�������õ�Ҫ�ҵ�����
				bits[i] += A[j] >> i & 1;
				// System.out.printf("               bits[i]=%s, A[j] >> i=%s\n",
				// bits[i], A[j] >> i);

			}
			bits[i] %= 3;
			System.out.printf("--> bit[i]=%s, after bits[i] = 3 \n", bits[i]);

		}
		for (int i = 0; i < 32; i++) {
			result |= (bits[i] << i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { Integer.MIN_VALUE/2,1, 1, 2, 3, 3, 3, 2, 2, Integer.MIN_VALUE/2, 1 };
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = -arr[i];
		}
		ArrayPrinter.printIntegerArray(arr);
		// int[] arr = {11,21,31,41,51,11,21,31,41,51,11,21,31,41,51,88};
		// int [] arr = {1,1,2,3,3,3,2,2,4,1};
		// for(int i = 0; i < arr.length; i ++){
		// arr[i] >>= 1 & 1;
		// arr[i] >>= i & 1;
		// }
		// int[] arr = {8,2,6,4};

		int result = singleNumber(arr);
		System.out.println(result);
		ArrayPrinter.printIntegerArray(arr);

	}

}
