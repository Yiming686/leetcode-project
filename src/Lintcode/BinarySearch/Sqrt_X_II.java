package Lintcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
Sqrt(x)的扩展：

[扩展] 给定一个整数，返回一个从小到大的整数序列，使得他们的平方和为此给定整数。
[扩展] 给定一个整数，返回一个从大到小的整数序列，使得他们的平方和为此给定整数。

15:00
 Start
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))

Tags Expand 
Binary Search Mathematics Facebook


Related Problems Expand 
Medium Pow(x, n) 37 %
Easy First Position of Target

 *
 */
public class Sqrt_X_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("-5: "+sqrtII(-5));
//		System.out.println("-1: "+sqrtII(-1));
		System.out.println(" 0: "+sqrtII(0));
		System.out.println(" 1: "+sqrtII(1));
		System.out.println(" 2: "+sqrtII(2));
		System.out.println(" 3: "+sqrtII(3));
		System.out.println(" 4: "+sqrtII(4));
		System.out.println(" 5: "+sqrtII(5));
		System.out.println(" 6: "+sqrtII(6));
		System.out.println(" 7: "+sqrtII(7));
		System.out.println(" 8: "+sqrtII(8));
		System.out.println(" 9: "+sqrtII(9));
		System.out.println("10: "+sqrtII(10));
		System.out.println("15: "+sqrtII(15));
		System.out.println("16: "+sqrtII(16));
		System.out.println("99: "+sqrtII(99));
	}
	
	//输出平方和序列，从大到小排列
	//x：负数到整数，通吃，
    public static List<Integer> sqrtII(int x) {
    	List<Integer> list = new ArrayList<Integer>();
    	while(x>0){
    		int val= sqrt6(x);
    		list.add(val);
    		x -= val * val;
    	}
		return list;
    }

	//输出平方和序列，从小到大排列
	//x：负数到整数，通吃，
    public static List<Integer> sqrtII2(int x) {
    	List<Integer> list = new ArrayList<Integer>();
    	while(x>0){
    		int val= sqrt(x);
    		list.add(0, val);
    		x -= val * val;
    	}
		return list;
    }
    
    //核心算法
    public static int sqrt(int x) {
    	if(x<0) throw new IllegalArgumentException();
    	if(x==0) return 0;
        if(x==1) return 1;
        long low = 0;
        long hight = x;
        while(low <= hight){
            long mid = (low+hight)/2;
            if(x < mid*mid)
                hight = mid -1;
            else
                low = mid + 1;
        } 
        return (int) hight;
    }
    
    //worked, why
    public static int sqrt6(int x) {
        // write your code here
//    	if(x==0) return 0;
//        if(x==1) return 1;

        long low = 1; //1 worked, 0 does not.
        long high = x;
        while(low < high){
            high = (low+high)/2;
            low = x/high;
            System.out.println("x:high:low "+x+" "+high+" "+low);
        } 
        return (int) high;
    }


}
