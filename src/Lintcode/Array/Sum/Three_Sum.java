package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Have you met this question in a real interview? Yes
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
Note
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Tags Expand 
Two Pointers Sort Array Facebook


Related Problems Expand 
Medium 3Sum Closest 29 %
Medium 4Sum 18 %
Medium Two Sum

 *
 */
public class Three_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//既然是3sum, 小于3个元素都返回空
		if(num == null || num.length < 3) {
			return result;
		}
		//只要值，不要index所以可以考虑排序
		Arrays.sort(num);
		//i从0到倒数第三个数
		for (int i = 0; i < num.length - 2; i++) {
		    //针对当前元素，可能有很多对元素，使得他们总和为0
		    if(num[i]>0)break;//因为left和right就是针对i找的，所以只能找一次
			if (i != 0 && num[i] == num[i - 1]) {//[容易忘记地方]对i的去重,就是当前和后面的对比
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					result.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { //对left的去重,就是当前和后面的对比// to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) {//对right的去重,就是当前和后面的对比 // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

}
