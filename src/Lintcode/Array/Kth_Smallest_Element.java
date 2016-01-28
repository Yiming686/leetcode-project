package Lintcode.Array;

import java.util.ArrayList;

public class Kth_Smallest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,3,2,8,8,4,8};
		System.out.println(""+kthSmallestElement(7, arr));
	}

    public static int kthSmallestElement(int k, int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int val : nums){
            list.add(val);
        }
        return kthSmallestElement(k, list);
    }

    public static  int kthSmallestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers == null || numbers.size() == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(numbers, 0, numbers.size() - 1, k);
    }
    
    public static int helper(ArrayList<Integer> numbers, int l, int r, int k) {
        if (l == r) {
            return numbers.get(l);
        }
        int position = partition(numbers, l, r);
        if (position + 1 == k) {
            return numbers.get(position);
        } else if (position + 1 < k) {
            return helper(numbers, position + 1, r, k);
        }  else {
            return helper(numbers, l, position - 1, k);
        }
    }
    
    public static int partition(ArrayList<Integer> numbers, int l, int r) {
        if (l == r) {
            return l;
        }
        int num = numbers.get(r);
        int index = l;
        for (int i = l; i < r; i ++) {
            if (numbers.get(i) <= num) {
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(index));
                numbers.set(index, temp);
                index ++;
            }
        }
        
        numbers.set(r, numbers.get(index));
        numbers.set(index, num);
        return index;         
    }    

}
