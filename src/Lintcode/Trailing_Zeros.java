package Lintcode;

import java.util.Arrays;

/**
Trailing Zeros

Write an algorithm which computes the number of trailing zeros in n factorial.

Have you met this question in a real interview? Yes
Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time

Tags Expand 
Mathematics


Related Problems Expand

 *
 */
public class Trailing_Zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 50;
		long[] arr = new long[size];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i< size; i++){
			arr[i] = i*arr[i-1];
		}
		for(int i = 2; i< size; i++){
//			System.out.printf(" %d!=%d, ", i, arr[i]);
			System.out.printf(" %d!=%d %s, ", i, arr[i], arr[i] > Integer.MAX_VALUE);
		}
		System.out.println("");
		for(int i = 2; i< size; i++){
			System.out.println("i:arr[i]  " +i + " != "+arr[i]);
			trailingZeros(i);
//			System.out.printf(" %d!=%d: %d, ", i, arr[i], trailingZeros(arr[i]));
		}
		System.out.println("");
		System.out.println(""+Integer.MAX_VALUE);
		System.out.println(""+Integer.MIN_VALUE);
		System.out.println(""+Arrays.toString(arr));
//		479001600
//		2147483647
	}
//	public static long getFactor(long n) {
//		
//	}
	
    public static long trailingZeros(long n) {
    	System.out.println("\n   n:"+n);
        long count = 0;
        //循环变量为count和n
        while (n != 0) {
            //业务逻辑
            long temp = n / 5;
            System.out.println("temp: "+temp);
            //修改循环变量
            count += temp;
            // sum ++;//错误
            n = temp;
        }
        System.out.println("count: "+count);
        System.out.println("\n===========================\n"+n);
        return count;
    }

}
