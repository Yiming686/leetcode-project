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
//	��ĳһ��key��˵�����ε���sumDigits(num),�ͻ�����һ���Ӧ�����У��������������û���ź����
//	��ô��ô����˵�����һ�����У���ô�ҵ��������������
//	��������е�key���ҵ��������������
//	prevMax, curr, newMax
//	Case1: ����ȱ�����ȫ������max1����ô
//		case 1.1 ���max2�����,���ܣ�OK,û���⣬һ����map���棻
//		case 1.2 ���max2���ұߣ�Ҳû�����⣬��Ϊ��������max2�ǣ�һ�����ҵ���ߵ�max1�ģ�
//	Case2: ����ȱ�����ȫ����ڶ����max2����ô
//		case 1.1 ���max1�����, �ǲ����ܵģ�OK,û���⣻
//		case 1.2 ���max1���ұߣ�Ҳû�����⣬��Ϊ��������max2�ǣ�һ�����ҵ���ߵ�max1�ģ�
	
//	������a+b = b+a, ÿһ��Ԫ��
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
