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
		int[] left2Right = new int[arr.length]; //left2Right[i] 表示从左到右一直到i-1的所有元素的乘积和       
		left2Right[0] = 1;//[考点] 根据递推关系，初始化
		for (int i = 1; i < arr.length; i++) {
			left2Right[i] = left2Right[i - 1] * arr[i - 1];//left2Right[i] 表示从左到右一直到i-1的所有元素的的乘积和
		}
		//right2Left[arr.length - 1] = arr[arr.length - 1], 根据递推关系，已经默认 初始化了
		int[] right2Left = arr;
		int rightNei = right2Left[arr.length - 1];
		right2Left[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			int curr = right2Left[i];
			right2Left[i] = rightNei * right2Left[i + 1];//right2Left[i] 表示从右到左一直到i的所有元素的的乘积和
			rightNei = curr;
		}
		for (int i = 0; i < arr.length; i++) {
			left2Right[i] = left2Right[i] * right2Left[i];//left2Right[i] 表示从左到右一直到i的所有元素的的乘积和
		}
		return left2Right;
	}

//  Time: O(N), Space: O(1)
	public static int[] productExceptSelf_1(int[] arr) {
		// public int[] productExceptSelf_O(n)(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int[] left2Right = new int[arr.length]; //left2Right[i] 表示从左到右一直到i的所有元素的乘积和       
		left2Right[0] = arr[0];//[考点]根据递推关系，初始化
		for (int i = 1; i < arr.length; i++) {
			left2Right[i] = left2Right[i - 1] * arr[i];//left2Right[i] 表示从左到右一直到i的所有元素的的乘积和
		}

		int[] right2Left = arr;//right2Left[i] 表示从右到左一直到i的乘积和
		//right2Left[arr.length - 1] = arr[arr.length - 1], 根据递推关系，已经默认 初始化了
		for (int i = arr.length - 2; i >= 0; i--) {
			right2Left[i] = right2Left[i + 1] * right2Left[i];//right2Left[i] 表示从右到左一直到i的所有元素的的乘积和
		}
		right2Left[0] = right2Left[1];//[考点]
		left2Right[arr.length - 1] = left2Right[arr.length - 2];//[考点]

		// for(int i = 1; i < arr.length - 1 ; i++){
		for (int i = arr.length - 2; i >= 1; i--) {//[考点] 根据递推关系，为了重用left2Right，新值需要覆盖旧值，就必须从右到左扫描
			left2Right[i] = left2Right[i - 1] * right2Left[i + 1];
		}
		left2Right[0] = right2Left[0];
		return left2Right;
	}

}
