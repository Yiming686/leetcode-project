package Lai.Array.Sum;

import java.util.HashSet;
import java.util.Set;

/**
Given three arrays, determine if a set can be made by picking one element from each array that sums to the given target number.

Assumptions

The three given arrays are not null and have length of at least 1
Examples

A = {1, 3, 5}, B = {8, 2}, C = {3}, target = 14, return true(pick 3 from A, pick 8 from B and pick 3 from C)

 


 *
 */
public class Lai_187_3_Sum_3_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean exist(int[] a, int[] b, int[] c, int target) {
		// Write your solution here
		int lenA = a.length;
		int lenB = b.length;
		int lenC = c.length;
		//minimize space, find shortest
		int lenAB = lenA + lenB;
		int lenAC = lenA + lenC;
		int lenBC = lenB + lenC;
		if (lenBC < lenAC && lenBC < lenAB) {
			int[] longest = a;
			a = c;
			c = longest;
		} else if (lenAC < lenAB && lenAC < lenBC) {
			int[] temp = b;
			b = c;
			c = temp;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				set.add(a[i] + b[j]);
			}
		}
		for (int i = 0; i < c.length; i++) {
			if (set.contains(target - c[i])) {
				return true;
			}
		}
		return false;
	}

}
