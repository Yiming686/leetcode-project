package Lai.Ace.Mock;

import static Utils.ArrayUtils.printf;

public class Sqrt_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 8;// 4 <= 8 < 9, return 2;
		System.out.println("max:"+Integer.MAX_VALUE);
		System.out.println("max:"+1000000007);
		int num = 2147395599;
		System.out.println(""+num);
		System.out.println(""+Integer.MAX_VALUE);
		System.out.println(""+sqrt(num));
	}
	public static int sqrt(int num) {
		if(num == 0 || num == 1) {
			return num;
		}
		int left = 1;
		int right = num;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			printf("left:mid:right %d:%d:%d", left, mid, right);
			long square = mid * mid;
			if(square == num) {
				return mid;
			}else if(square > 0 && square <= Integer.MAX_VALUE && square < num) {
				left = mid;
			}else {
				right = mid;
			}
		}
		if(right * right == num) {
			return right;
		}
		return left;
	}

}
