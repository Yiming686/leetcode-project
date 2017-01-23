package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.org.apache.xalan.internal.xsltc.dom.SAXImpl.NamespaceWildcardIterator;

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

//只要遇到一组就返回
public class Three_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[]{-1, 0,5,7, 1, 2, -1, -4};
		int[] arr = new int[]{-4, -1, -1, 0, 1, 2, 5, 7};
		
		System.out.println(""+threeSum(arr));
		System.out.println(""+threeSum(arr, 13));
	}

    public static boolean threeSum(int[] num) {
		
		//既然是3sum, 小于3个元素都返回空
		if(num == null || num.length < 3) {
			return false;
		}
		//只要值，不要index所以可以考虑排序
		Arrays.sort(num);
		//i从0到倒数第三个数
		System.out.println(""+Arrays.toString(num));
		for (int i = 0; i < num.length - 2; i++) {
			
		    if(num[i]>0)break;//因为left和right就是针对i找的，所以只能找一次
			if (i != 0 && num[i] == num[i - 1]) {//[容易忘记地方]对i的去重,就是当前和后面的对比
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
//				System.out.println(""+num[i]+" "+num[left]+" "+num[right]);
//				System.out.println(""+sum);
				if (sum == 0) {
					return true;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return false;
	}

    public static boolean threeSum(int[] num, int target) {
		
		//既然是3sum, 小于3个元素都返回空
		if(num == null || num.length < 3) {
			return false;
		}
		//只要值，不要index所以可以考虑排序
		Arrays.sort(num);
		//i从0到倒数第三个数
		System.out.println(""+Arrays.toString(num));
		for (int i = 0; i < num.length - 2; i++) {
			
		    if(num[i]>0)break;//因为left和right就是针对i找的，所以只能找一次
			if (i != 0 && num[i] == num[i - 1]) {//[容易忘记地方]对i的去重,就是当前和后面的对比
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
//				System.out.println(""+num[i]+" "+num[left]+" "+num[right]);
//				System.out.println(""+sum);
				if (sum == target) {
					System.out.println(""+num[i]+" "+num[left]+" "+num[right]);

					return true;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return false;
	}

    
}
