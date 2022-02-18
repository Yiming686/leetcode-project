package Lai.Two_Pointer_Sliding_Window;


/**

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.


 *
 */
public class Leet_11_Container_With_Most_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		return largest(height);
	}

	public int largest(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			max = Math.max(max, Math.min(arr[left], arr[right]) * (right - left));
			if (arr[left] < arr[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

}
