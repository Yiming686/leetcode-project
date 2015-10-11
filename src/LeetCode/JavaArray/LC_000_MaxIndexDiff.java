package LeetCode.JavaArray;

/*
 * Given a integer array, find then max diff between indexs i and j, such that i < j and a[i] < a[j]
 * 
 *  this array is unsorted, and have duplicates
 * 
 * 
 */
public class LC_000_MaxIndexDiff {

	//provide a O(n) solution
	public int[] findMaxIndexDiff(int[] arr){
		if(arr == null) return null;
		int len = arr.length;
		int[] ret = {-1,-1};
		if(len<2){ return ret;}
		
		boolean [] arr2 = new boolean[len];
		
		int firstMax = arr[0];
		arr2[0] = true;
		int left = 0;
		for(int i = 1; i < len; i ++){
			if(arr[i] < firstMax){
				arr2[i] = true;
				left = i;
				firstMax = arr[i];
			} 
		}
		return ret;
	}
}
