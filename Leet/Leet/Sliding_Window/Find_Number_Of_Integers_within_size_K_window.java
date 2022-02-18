package Leet.Sliding_Window;

import static Utils.ArrayUtils.printIntArray;

import java.util.Arrays;

import Utils.ArrayUtils;
import Utils.SU;

public class Find_Number_Of_Integers_within_size_K_window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("3. Longest Substring Without Repeating Characters\n" + 
				"");
		int[] arr = ArrayUtils.buildIntArraySorted(5, 0,20);
		printIntArray(arr, 3);
		
		printIntArray(findNumberOfIntegersWithinSizeKWindow(arr, 10), 3);;
	}

	private static int[] findNumberOfIntegersWithinSizeKWindow(int[] arr, int k) {
		Arrays.sort(arr);
		int[] result = new int[arr.length];
		int slow = 0;
		int count = 0;
		for(int fast = 0; fast < arr.length; fast++) {
			count++;
			while(arr[slow] <= arr[fast] - k) {
				count--;
				slow++;
			}
//			if(fast >= k - 1) {				
				result[fast] = count;
//			}
		}
		return result;
	}

}
