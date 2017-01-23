package Lintcode.Array.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Merge k Sorted Arrays

30:00
 Start
Given k sorted integer arrays, merge them into one sorted array.

Have you met this question in a real interview? Yes
Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge
Do it in O(N log k).

N is the total number of integers.
k is the number of arrays.
Tags Expand 
Heap Priority Queue


Related Problems Expand 
Medium Merge k Sorted Lists

 *
 */
public class Merge_k_Sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = new int[][]{
			{1, 3, 5, 7},
			{2, 4, 6},
			{0, 8, 9, 10, 11}
		}; 
		System.out.println(""+Arrays.toString(mergekSortedArrays(arrays)));
	}

    public static int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }
        
        Queue<Element> queue = new PriorityQueue<Element>(
            arrays.length, new Comparator<Element>(){

				@Override
				public int compare(Element e1, Element e2) {
					// TODO Auto-generated method stub
					return e1.val - e2.val;
				}
            	
            });
            
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element elem = new Element(i, 0, arrays[i][0]);
                queue.add(elem);
                size += arrays[i].length;
            }
        }
        
        int[] result = new int[size];
        int index = 0;
        while (!queue.isEmpty()) {
            Element elem = queue.poll();
            result[index++] = elem.val;
            //如果最小元素的所在行，数组还有元素，则继续添加，直接update元素的col和val，然后添加
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                queue.add(elem);
            }
        }
        
        return result;
    }

    static class Element {
        public int row, col, val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

	
}
