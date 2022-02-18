package Leet.OA.Microsoft;

import java.util.HashMap;
import java.util.Map;

import Utils.ArrayUtils;
import Utils.SU;

public class Number_With_Equal_Digit_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MaxSumPair obj = new MaxSumPair();
//		System.out.println(obj.solution(new int[] {51,71,17,42}));//93, 88
//		System.out.println(obj.solution(new int[] {42,33,60}));//42+60 = 102
//		System.out.println(obj.solution(new int[] {51, 32, 43}));//-1
//		ArrayUtils.generateIntArrayNoDup(6, -20, 40);
//		int[] arr = new int[] { 51, 71, 17, 42 };
//		int[] arr = new int[] {42,33,60};
		int[] arr = new int[] {51, 32, 43};
		System.out.println("" + maxSum(arr));
//		System.out.println(""+sumDigits(arr));
	}
	
//num1, num2, num3, num4, how to find max two
//	对某一个key来说，依次调用sumDigits(num),就会生成一组对应的序列，而且这个序列是没有排好序的
//	那么怎么就是说针对这一的序列，怎么找到两个其和是最大的
//	在针对所有的key，找到两个其和是最大的
//	prevMax, curr, newMax
//	Case1: 如果先遍历到全局最大的max1，那么
//		case 1.1 如果max2在左边,可能，OK,没问题，一定在map里面；
//		case 1.2 如果max2在右边，也没有问题，因为当遍历到max2是，一定会找到左边的max1的；
//	Case2: 如果先遍历到全局最第二大的max2，那么
//		case 1.1 如果max1在左边, 是不可能的，OK,没问题；
//		case 1.2 如果max1在右边，也没有问题，因为当遍历到max2是，一定会找到左边的max1的；
	
//	分析：a+b = b+a, 每一个元素
//	Time: O(N), Space: O(N)
	public static int maxSum(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<>();//key: sum of digits , val: previous Max Number
		int maxSum = -1;
		for (int currNum : arr) {
			int digitSum = sumDigits(currNum);
			Integer prevMaxNum = map.get(digitSum);
			if (prevMaxNum == null) {
				map.put(digitSum, currNum);//sum, num
			}else {
				maxSum = Math.max(maxSum, currNum + prevMaxNum);
				if (currNum > prevMaxNum) {
					map.put(digitSum, currNum);
				}
			}

		}
		return maxSum;
	}

	private static int sumDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}
}
