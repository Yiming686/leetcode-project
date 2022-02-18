package Lai.DP_II;

import java.util.Arrays;

import Utils.ArrayUtils;

public class Largest_SubArray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = ArrayUtils.generateIntArray(6, -10, 10);
//		int[] arr = {0,0,1,1,1,0,0};
		int[] arr = {2, -1, 4, -2, 1};
		System.out.println(""+Arrays.toString(largestSum(arr)));
	}

	public static int[] largestSum(int[] arr) {
		// Write your solution here
		int[] indices = new int[3];
		if (arr == null || arr.length == 0) {
			return indices;
		}
		int localMax = arr[0];
		int globalMax = localMax;
		indices[0] = globalMax;
		int left = 0;
		for (int right = 1; right < arr.length; right++) {
//		      arr[i] <==> localMax + arr[i]        
			if (localMax > 0) {
				localMax += arr[right];
			} else {
				localMax = arr[right];
				left = right;
				System.out.println("left:  "+left);
			}
			System.out.printf("left:right %d:%d \n",left, right);
			if (localMax > globalMax) {// leftmost
				globalMax = localMax;
				indices[0] = globalMax;
				indices[1] = left;
				indices[2] = right;
				;
			}
		}

		return indices;
	}

}
