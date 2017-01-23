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

//	 ���ַ�������firstС�ڵ��ڵ��������������С��Ŀ��ֵ��λ�ã�  find Last that is less than sqrt(x)
//	�������飬Ѱ�Ҳ���λ�ã����ڲ�����С�Ĵ�������λ�ã�������С�ĵ��ڵ�λ�ã�first���ڻ�first����
//	f(k) = k^2, k^2 = x, f(mid) <= f(k), mid^2 <= k^2 = x
//	best, easy to understand
//	1.����Ŀ�������ս��������Χ
//	2.���㣺�ȿ��ǣ�����ʱ��low = hight��������hight��������
//	3.�����㣺
//	4.�����㼰���ϣ�����������
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
    
 // worked, must be long��code two long, ignore it
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
