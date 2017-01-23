package Lintcode.BinarySearch;

/**
Sqrt(x)

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
public class Sqrt_X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+sqrt(-5));
//		System.out.println(""+sqrt(-1));
		System.out.println(""+sqrt(0));
		System.out.println(""+sqrt(1));
		System.out.println(""+sqrt(2));
		System.out.println(""+sqrt(8));
		System.out.println(""+sqrt(9));
		System.out.println(""+sqrt(10));
		System.out.println(""+sqrt(15));
		System.out.println(""+sqrt(16));
		System.out.println(""+sqrt(17));
		System.out.println(""+sqrt(18));
		System.out.println(""+sqrt(19));
		System.out.println(""+sqrt(20));
		System.out.println(""+sqrt(21));
		System.out.println(""+sqrt(22));
		System.out.println(""+sqrt(23));
	}

//	 二分法：查找first小于等于的情况，查找最大的小于目标值的位置，  find Last that is less than sqrt(x)
//	排序数组，寻找插入位置，属于查找最小的大于它的位置，或者最小的等于的位置，first大于或first等于
//	f(k) = k^2, k^2 = x, f(mid) <= f(k), mid^2 <= k^2 = x
//	best, easy to understand
//	1.此题目允许最终结果超出范围
//	2.单点：先考虑，单点时，low = hight，跳动后，hight就是所求
//	3.二个点：
//	4.三个点及以上：豪放跳进，
    public static int sqrt(int x) {
        // write your code here
        if(x<0) throw new IllegalArgumentException();
        long left = 0;
        long right = x;
        while(left <= right){
            long mid = (left+right)/2;
            long product = mid * mid;
//            System.out.println("mid: "+mid);
//            if(x == product){
//            	return (int)mid;
//            }else 
            	if(x < product){
            	right = mid -1;
            }else{
            	left = mid + 1;
            }
        } 
        System.out.println(""+(right == left -1));
        return (int) right;
    }
    
 // worked, must be long，code two long, ignore it
    public int sqrt9(int x) {
        if(x<0) throw new IllegalArgumentException();
        long left = 0;
        long right = x;
        while(left + 1 < right){
            long mid = left + (right - left)/2;
            long product = mid * mid;
//            if( x == product){
//                return (int)mid;
//            }else 
            	if( x < product){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(right * right == x){
            return (int)right;
        }
        if(left * left <= x){
            return (int)left;
        }else{
            return (int)left -1;
        }
    }

    //worked, why
    public static int sqrt2(int x) {
        // write your code here
        long low = 1; //1 worked, 0 does not.
        long hight = x;
        while(low < hight){
            hight = (low+hight)/2;
            low = x/hight;
        } 
        return (int) hight;
    }


}
