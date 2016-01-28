package Lintcode;

import java.util.ArrayList;
import java.util.Scanner;

/*
 Medium Permutations Show result 

 24% Accepted
 Given a list of numbers, return all possible permutations.

 Have you met this question in a real interview? Yes
 Example
 For nums = [1,2,3], the permutations are:

 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 Challenge
 Do it without recursion.

 Tags Expand 
 Recursion
 * 
 */

public class Permutations {
	
	
//	Accepted
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		// write your code here
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return rst;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(rst, list, nums);
		return rst;
	}

	public void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> list, ArrayList<Integer> num) {
		if (list.size() == num.size()) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.size(); i++) {
			if (list.contains(num.get(i))) {
				continue;
			}
			list.add(num.get(i));
			helper(rst, list, num);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
				int num = sc.nextInt();
			int[] arr = new int[num];
			for(int j=0;j<num;j++){
				arr[j] = sc.nextInt();
			}
		}
	}

}
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
