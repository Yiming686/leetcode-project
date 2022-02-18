package Leet.Array;

import static Utils.ArrayUtils.print;

public class Leet_238_Product_of_Array_Except_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr  = {1,2,3,4};
		print(productExceptSelf(arr));
		
	}

//  Time: O(N), Space: O(1)
	public static int[] productExceptSelf(int[] arr) {
		// public int[] productExceptSelf_O(n)(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int[] left2Right = new int[arr.length]; //left2Right[i] ��ʾ������һֱ��i-1������Ԫ�صĳ˻���       
		left2Right[0] = 1;//[����] ���ݵ��ƹ�ϵ����ʼ��
		for (int i = 1; i < arr.length; i++) {
			left2Right[i] = left2Right[i - 1] * arr[i - 1];//left2Right[i] ��ʾ������һֱ��i-1������Ԫ�صĵĳ˻���
		}
		//right2Left[arr.length - 1] = arr[arr.length - 1], ���ݵ��ƹ�ϵ���Ѿ�Ĭ�� ��ʼ����
		int[] right2Left = arr;
		int rightNei = right2Left[arr.length - 1];
		right2Left[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			int curr = right2Left[i];
			right2Left[i] = rightNei * right2Left[i + 1];//right2Left[i] ��ʾ���ҵ���һֱ��i������Ԫ�صĵĳ˻���
			rightNei = curr;
		}
		for (int i = 0; i < arr.length; i++) {
			left2Right[i] = left2Right[i] * right2Left[i];//left2Right[i] ��ʾ������һֱ��i������Ԫ�صĵĳ˻���
		}
		return left2Right;
	}

//  Time: O(N), Space: O(1)
	public static int[] productExceptSelf_1(int[] arr) {
		// public int[] productExceptSelf_O(n)(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int[] left2Right = new int[arr.length]; //left2Right[i] ��ʾ������һֱ��i������Ԫ�صĳ˻���       
		left2Right[0] = arr[0];//[����]���ݵ��ƹ�ϵ����ʼ��
		for (int i = 1; i < arr.length; i++) {
			left2Right[i] = left2Right[i - 1] * arr[i];//left2Right[i] ��ʾ������һֱ��i������Ԫ�صĵĳ˻���
		}

		int[] right2Left = arr;//right2Left[i] ��ʾ���ҵ���һֱ��i�ĳ˻���
		//right2Left[arr.length - 1] = arr[arr.length - 1], ���ݵ��ƹ�ϵ���Ѿ�Ĭ�� ��ʼ����
		for (int i = arr.length - 2; i >= 0; i--) {
			right2Left[i] = right2Left[i + 1] * right2Left[i];//right2Left[i] ��ʾ���ҵ���һֱ��i������Ԫ�صĵĳ˻���
		}
		right2Left[0] = right2Left[1];//[����]
		left2Right[arr.length - 1] = left2Right[arr.length - 2];//[����]

		// for(int i = 1; i < arr.length - 1 ; i++){
		for (int i = arr.length - 2; i >= 1; i--) {//[����] ���ݵ��ƹ�ϵ��Ϊ������left2Right����ֵ��Ҫ���Ǿ�ֵ���ͱ�����ҵ���ɨ��
			left2Right[i] = left2Right[i - 1] * right2Left[i + 1];
		}
		left2Right[0] = right2Left[0];
		return left2Right;
	}

}
