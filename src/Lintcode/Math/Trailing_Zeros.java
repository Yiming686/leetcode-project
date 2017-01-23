package Lintcode.Math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println(""+trailingZeros(5*5*3));
		// TODO Auto-generated method stub                                                 
		int size = 129;
		long[] arr = new long[size];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i< size; i++){
			arr[i] = i*arr[i-1];
			System.out.printf(" %d!=%d %s, ", i, arr[i], arr[i] > Integer.MAX_VALUE);
		}
		System.out.println("");
		System.out.println("\n===================================================\n");
		String str = "1";
		long step = 0;
		Map<Long, Long> edges = new HashMap<>();
		for(int i = 2; i< size; i++){
			System.out.println("i:arr[i]  " +i + "! = "+(str+=" * "+i)+" = "+arr[i]);
			long num = trailingZeros(i);
			if(step != num){
				step = num;
				edges.put(num, (long) i );
			}
			System.out.printf(" %d!=%d ==> It has %d zeros! ", i, arr[i], num);
			System.out.println("\n===================================================\n");
		}
//		System.out.println("Edges: "+edges);
//		System.out.println("");
//		System.out.println(""+Integer.MAX_VALUE);
//		System.out.println(""+Integer.MIN_VALUE);
//		System.out.println(""+Arrays.toString(arr));

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
        System.out.println("\n------------------------------\n");
        return count;
    }

}
/* 示例如下：

 0             
 1             
 2             
 3             
 4             
 5*1           
 6             
 7             
 8             
 9             
 5*2           
 .             
 .             
 .             
 5*3           
 .             
 .             
 .             
 5*4           
 .             
 .             
 .             
 5*5*1  （5+1 = 6）         
 .             
 .             
 .             
 5*5*2  （5*2 + 2 = 12）
 .             
 .             
 .             
 5*5*3  （5*3 + 3 = 18）
 .             
 .             
 .             
 5*5*5*3 (5*5*3+5*3+3 = 75+15+3 = 93)         

*/


