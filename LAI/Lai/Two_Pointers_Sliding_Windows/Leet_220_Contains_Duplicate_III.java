package Lai.Two_Pointers_Sliding_Windows;

import java.util.TreeSet;

public class Leet_220_Contains_Duplicate_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, 2147483647 };
		int k = 1;
		int d = 2147483647;
		System.out.println("" + containsNearbyAlmostDuplicate(arr, k, d));
	}

public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int d) {
	// validate skipped.
	TreeSet<Integer> window = new TreeSet<>();
	for (int fast = 0; fast < arr.length; fast++) {
		// invariant: check arr[fast], window records the last k elements       
		// step1. floor
		Integer floor = window.floor(arr[fast]);
		if (floor != null && arr[fast] - floor <= d) {
			return true;
		}
		// if (floor != null && arr[fast] <= (floor + d)) return true;
		// step2. ceiling
		Integer ceiling = window.ceiling(arr[fast]);
		// if (ceiling != null && ceiling - arr[fast]<= d) return true; 
		if (ceiling != null && ceiling <= arr[fast] + d) {
			return true;
		}
		// add fast delta
		window.add(arr[fast]);
		// remove slow delta
		if (fast >= k) {
			// if (window.size() > k) {
			window.remove(arr[fast - k]);
		}
	}
	return false;
}

	// Time: O(n * logk)
// Space: O(k)

}
