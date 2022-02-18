package Lai.DP_II;

import Utils.ArrayUtils;

public class Array_Hopper_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArrayWithDup(12, 0, 6);
		System.out.println("A:"+minJumpA(arr));
		System.out.println("B:"+minJumpB(arr));
		
	}

//	:: Best Candidate Ever
//	Two conclusions: 
//	1. min[0] === 0
//	2. if arr[0], min[i] === -1, when i > 0
//	public static int minJump_00(int[] arr) {
	public static int minJumpA(int[] arr) {		
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int len = arr.length;
		//0---len-1, len; return min[len]
		//min[i] represents the min num of jumps from 0 to i 
		int[] min = new int[len + 1];//从0到i-1的位置，跳到i位置，需要的最少的步数
		min[0] = 0;
		for (int i = 1; i <= len; i++) {
			min[i] = -1;//默认不可抵达
			for (int j = 0; j < i; j++) {//遍历所有可能，尽可能更新
				if (j + arr[j] >= i && min[j] != -1) {//发现右侧有可以抵达i的,并且知道右侧可以跳到
					if (min[i] == -1) {//如果第一次
						min[i] = min[j] + 1;
					} else {//如果不是第一次
						min[i] = Math.min(min[i], min[j] + 1);
					}
				}
			}
		}
		ArrayUtils.printIntArray(min);
		return min[len];
	}

//	With Dup Array: 
//	        Array: [  6,  4,  2,  5,  5,  1,  3,  2,  0,  0,  5,  3]
//			Index:    0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11 
//
//			Array: [  0,  1,  1,  1,  1,  1,  1,  2,  2,  2, -1, -1, -1]
//			Index:    0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12 
//
//			A:-1
//			B:4
//	With Dup Array: 
//		Array: [  1,  0,  6,  6,  6,  5,  3,  2,  3,  4,  4,  6]
//		Index:    0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11 
//
//		Array: [  0,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
//		Index:    0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12 
//
//		A:-1
//		B:5
	//能到达len位置吗？
	public static int minJumpB(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int len = arr.length;
		int min = 0;//from 0 to current pos i
		int currReach = 0;//current reach for i
		int lastReach = 0;//last reach
		for (int i = 0; i <= len; i++) {
			if(i > lastReach) {
				min++;
				lastReach = currReach;
			}
			if(i < arr.length) {
				currReach = Math.max(currReach, i + arr[i]);//新的 current reach
				if(lastReach == currReach) return -1;;
			}
		}
		return currReach >= len ? min : -1;
	}

}
