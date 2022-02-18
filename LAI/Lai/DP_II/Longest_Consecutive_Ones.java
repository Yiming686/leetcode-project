package Lai.DP_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Consecutive_Ones {
	  static class Pair{
		    int left;
		    int right;
		    Pair(int left, int right){
		      this.left = left;
		      this.right = right;
		    }
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + left;
				result = prime * result + right;
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (left != other.left)
					return false;
				if (right != other.right)
					return false;
				return true;
			}
		    
		  }
	public static void main(String[] args) {
		System.out.println(""+(1-2)/2 );
		// TODO Auto-generated method stub
//		int[] arr = {0,0,1,1,0,0,1,1,1,0,1};
//		int[] arr = {1,0,1,1,0};
//		int[] arr = {0};
		int[] arr = {0,0,1,0,0};
//		int[] arr = {1,0,0};
//		int[] arr = {1,0, 1,1};
		System.out.println(""+Arrays.toString(longest2(arr)));
	}

	public static int longest(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int localMax = arr[0];
		int globalMax = localMax;
		int left = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				localMax++;
			} else {
				localMax = 0;
				left = i;
			}
			if(localMax > globalMax) {
				globalMax = localMax;
				System.out.printf("left:right %d:%d \n",left, i);
			}
//			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}

	public static int[] longest2(int[] arr) {
		System.out.println(""+Arrays.toString(arr));
		// Write your solution here
		int[] result = new int[3];
		if (arr == null || arr.length == 0) {
			return result;
		}
		result[0] = arr[0];
		int localMax = arr[0];
		int left = (arr[0] == 1) ? 0 : 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				localMax++;
			} else {
				localMax = 0;
				left = i + 1;
			}
			if(localMax > result[0]) {
				result[0] = localMax;
				result[1] = left;
				result[2] = i;
				System.out.printf("left:right %d:%d \n",result[1], result[2]);
			}
//			globalMax = Math.max(globalMax, localMax);
		}
		return result;
	}

}
