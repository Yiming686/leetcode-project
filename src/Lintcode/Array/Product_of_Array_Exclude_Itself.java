package Lintcode.Array;

import java.util.ArrayList;

/**
Product of Array Exclude Itself Show result 

Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Have you met this question in a real interview? Yes
Example
For A = [1, 2, 3], return [6, 3, 2].

Tags Expand 
Forward-Backward Traversal LintCode Copyright

 *
 */
public class Product_of_Array_Exclude_Itself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 3, 2};
		ArrayList<Integer> A = new  ArrayList<Integer> ();
		for(int val : arr){
			A.add(val);
		}
		System.out.println(""+productExcludeItself(A));
	}

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> list = new ArrayList<Long>();
        int size = A.size();
        if(size == 1) {
            list.add(1L);
            return list;
        }
        long[] left = new long[size];
        long[] right = new long[size];
        long product = 1;
        for(int i = 0; i < size; i++){
            left[i] = A.get(i) * product;
            product = left[i];
        }
        product = 1;//product must be reset;
        for(int i = size - 1; i >= 0; i--){
            right[i] = A.get(i) * product;
            product = right[i];
        }
//        System.out.println(""+left);
//        System.out.println(""+right);
        for(int i = 0; i < size; i++){
            if(i == 0){
              list.add(right[1]);
              continue;
            } 
            if(i == size -1){
              list.add(left[size-2]);
              continue;
            } 
            list.add(i, left[i-1]*right[i+1]);
        }
        return list;
        
    }
}
