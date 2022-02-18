package Lai.Recursion_I_Sorting_Algorithm;


/**
Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, 
sort the balls such that all balls with same color are grouped together and from left to right 
the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  
Blue is denoted by 2 and Black is denoted by 3).

Examples	

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}
Assumptions

The input array is not null

 */
public class Lai_399_Rainbow_Sort_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] rainbowSortII(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int slow0 = 0;
		int slow1 = 0;
		int slow2 = 0;
		int slow3 = 0;
		while (slow3 < arr.length) {
			if (arr[slow3] == 3) {
				slow3++;
			} else if (arr[slow3] == 2) {
				swap(arr, slow2, slow3);
				slow3++;
				slow2++;
				// swap(arr, slow2++, slow3);
			} else if (arr[slow3] == 1) {
				swap(arr, slow2, slow3);
				swap(arr, slow1, slow2);
				slow3++;
				slow2++;
				slow1++;
			} else {
				swap(arr, slow2, slow3);
				swap(arr, slow1, slow2);
				swap(arr, slow0, slow1);
				slow3++;
				slow2++;
				slow1++;
				slow0++;
			}
		}
		return arr;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
