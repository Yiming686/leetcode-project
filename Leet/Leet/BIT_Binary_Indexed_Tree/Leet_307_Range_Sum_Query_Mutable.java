package Leet.BIT_Binary_Indexed_Tree;

import java.util.Arrays;

public class Leet_307_Range_Sum_Query_Mutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+(0) % 4);
//		System.out.println(""+(-1) % 4);
//		System.out.println(""+(-2) % 4);
//		System.out.println(""+(-3) % 4);
//		System.out.println(""+(-4) % 4);
//		System.out.println(""+(-5) % 4);
//		System.out.println(""+(-6) % 4);
//		System.out.println("------");
//		System.out.println(""+(0) / 4);
//		System.out.println(""+(-1) / 4);
//		System.out.println(""+(-2)/ 4);
//		System.out.println(""+(-3) / 4);
//		System.out.println("------");
//		System.out.println(""+(-4) / 4);
//		System.out.println(""+(-5) / 4);
//		System.out.println(""+(-6) / 4);
//		
//		System.out.println(""+(-7) / 4);
//		System.out.println("------");
//		System.out.println(""+(-8) / 4);
//		System.out.println(""+(-9) / 4);

		int[] arr = { 1, 3, 5 };

		BIT tree = new BIT(arr);
		System.out.println("" + BIT.sumRange(0, 2));
		BIT.update(1, 2);
		System.out.println("" + BIT.sumRange(0, 2));
	}

	static class BIT {
		public static int sumRange(int i, int j) {
			return sum(j) - sum(i - 1);
		}

		// 改变某个元素的值，num[i] to val, get delta first
		public static void update(int i, int val) {
			int diff = val - nums[i];

			nums[i] = val;
//			nums[i] = nums[i] + diff;

			updateBIT(i, diff);
		}

		// 更新树状数组Binary Indexed Tree, i + delta
		public static void updateBIT(int i, int val) {
			i++;
			while (i <= nums.length) {
				BITree[i] = BITree[i] + val;
				i = i + (i & -i);
			}
		}

		// 求出前 `i` 个元素的和
		public static int sum(int i) {
			int sum = 0;

			i++;
			while (i > 0) {
				sum = sum + BITree[i];
				i = i - (i & -i);
			}

			return sum;
		}
		// 树状数组Binary Indexed Tree

		static int[] BITree;

		static int[] nums;

		public BIT(int[] nums) {
			this.nums = nums;

			// 初始化树状数组Binary Indexed Tree
			// 索引都从1开始
			this.BITree = new int[nums.length + 1];

			for (int i = 0; i < nums.length; i++) {
				updateBIT(i, nums[i]);
			}
		}

	}

}

class NumArray {

	private int[] bitTree;
	private int[] arr;

	public NumArray(int[] arr) {
		this.arr = arr;
		this.bitTree = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			// bitTree[i+1] = arr[i];
			updateBitTree(i + 1, arr[i]);
		}
	}

	//i: 0 - len - 1
	public void update(int i, int val) {
		int diff = val - arr[i];
		arr[i] = val;
		updateBitTree(i + 1, diff);
	}

	//OK, i from 1 to len  + 1
	private void updateBitTree(int i, int diff) {
		for (int j = i; j < bitTree.length; j += lowbit(j)) {
			bitTree[j] += diff;
		}
	}

	//arr index
	public int sumRange(int i, int j) {
		return prefixSum(j + 1) - prefixSum(i);
	}

	//for bit tree, 0 to len 
	private int prefixSum(int i) {
		int sum = 0;
		for (int j = i; j > 0; j -= lowbit(j)) {
			sum += bitTree[j];
		}
		return sum;
	}

	//bitTree index i: 1 to len 
	private int lowbit(int i) {
		return i & (-i);
	}

}
