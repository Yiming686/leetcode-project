package Lai.Array.Binary_Search;

public class Binary_Search_In_2D_Array_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] {{1,2,3,3,4},{4,5,6,7,10},{12,14,14,17,19},{22,22,22,24,25}};
		System.out.println(""+binarySearchIn2DArrayI(arr, 6));
		
	}

	public static int[] binarySearchIn2DArrayI(int[][] arr, int target) {
		// Write your solution here
		int[] result = new int[]{-1, -1};
		if (arr == null || arr.length == 0) {
			return result;
		}
		int row = arr.length;
		int col = arr[0].length;
		int left = 0;
		int right = row * col - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid/col][mid%col] == target) {
				result[0] = mid/col;
				result[1] = mid%col;
				return result;
			} else if (arr[mid/col][mid%col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

}
