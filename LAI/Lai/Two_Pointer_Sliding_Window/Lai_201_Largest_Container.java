package Lai.Two_Pointer_Sliding_Window;

/**
Given an array of non-negative integers, each of them representing the height of 
a board perpendicular to the horizontal line, the distance between any two adjacent boards is 1. 
Consider selecting two boards such that together with the horizontal line they form a container. 
Find the volume of the largest such container.

Assumptions

The given array is not null and has size of at least 2
Examples

{ 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.

 *
 */
public class Lai_201_Largest_Container {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
