package Lai.Array.Sum;

import java.util.HashSet;
import java.util.Set;

/**
Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.

Assumptions

The two given arrays are not null and have length of at least 1
Examples

A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)

A = {1, 3, 5}, B = {2, 8}, target = 6, return false


 *
 *
 */
public class Lai_185_2_Sum_2_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean existSum(int[] a, int[] b, int target) {
		// Write your solution here
		int lenA = a.length;
		int lenB = b.length;
		//minimize space, find shortest
		if (lenA > lenB) {
			int[] longer = a;
			a = b;
			b = longer;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			if (set.contains(target - b[i])) {
				return true;
			}
		}
		return false;
	}

}
