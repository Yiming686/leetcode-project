package Lai.DB01.Binary_Search;

/**

Binary Search In Sorted 2D Array I
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The
first element of next row is larger than (or equal to) the last element of previous row.
Given a target number, returning the position that the target locates within the matrix. If the target
number does not exist in the matrix, return (-1, -1}.

http://app.laicode.io/app/problem/267

**
Search in sorted matrix, each row of the matrix is sorted in ascending order,
* and the first element of the row is equals to or larger than the last element
* of the previous row.
Return the position if the target is found, otherwise return {-1, -1}


 *
 */
public class Binary_Search_In_2D_Array_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int right = Integer.MAX_VALUE;
		int left = right - 10;
		System.out.println(""+right);
//		System.out.println(""+ (2<<16));
		System.out.println(""+ (2<<30));
		System.out.println(""+ (2<<29));
		System.out.println(""+ ((2<<30) - 1));
//		int mid = left + (right - left) / 2;
//		int mid = (right + left) / 2;
//		System.out.println("mid: "+ mid);
		
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
