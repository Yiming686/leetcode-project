package GeeksForGeeks.Array;

/**

Smallest Difference Triplet from Three arrays
Three arrays of same size are given. Find a triplet such that maximum ¨C minimum in that triplet is minimum of all the triplets. A triplet should be selected in a way such that it should have one number from each of the three given arrays.

If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.

Examples:

Input : arr1[] = {5, 2, 8}
	arr2[] = {10, 7, 12}
	arr3[] = {9, 14, 6}
Output : 8, 7, 6

Input : arr1[] = {15, 12, 18, 9}
	arr2[] = {10, 17, 13, 8}
	arr3[] = {14, 16, 11, 5}
Output : 11, 10, 9
Note:The elements of the triplet are displayed in non-decreasing order.

Recommended: Please solve it on ¡°PRACTICE ¡± first, before moving on to the solution.
Simple Solution : Consider each an every triplet and find the required smallest difference triplet out of them. Complexity of O(n3).

Efficient Solution:

Sort the 3 arrays in non-decreasing order.
Start three pointers from left most elements of three arrays.
Now find min and max and calculate max-min from these three elements.
Now increment pointer of minimum element¡¯s array.
Repeat steps 2, 3, 4, for the new set of pointers until any one pointer reaches to its end.


 *
 */
public class Smallest_Difference_Triplet_from_Three_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int arr1[] = {5, 2, 8};
	    int arr2[] = {10, 7, 12};
	    int arr3[] = {9, 14, 6};
	    int n = arr1.length;
	    findSmallestDifferenceTriplet(arr1, arr2, arr3);
//	    Output:
//	    	7, 6, 5
	    return;
	}

	private static void findSmallestDifferenceTriplet(int[] arr1, int[] arr2, int[] arr3) {
		// TODO Auto-generated method stub
		
	}

}
