package Lintcode.Math.Integer;

/**
Reverse Integer Show result 

Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

Have you met this question in a real interview? Yes
Example
Given x = 123, return 321

Given x = -123, return -321

Tags Expand 
Integer


Related Problems Expand 

 *
 */
public class Reverse_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+reverseInteger(321));
//		System.out.println(""+reverseInteger(-321));
		System.out.println(""+(546384741*10+2));
		System.out.println(""+reverseInteger(Integer.MAX_VALUE - 2));
	}

//	2147483645
//	5463847412
    public static int reverseInteger(int x) {
        // Write your code here
        int rst = 0;
        System.out.println(""+x);
        while(x != 0) {
            int next_rst = rst * 10 + x % 10;//乘10加现在的digit
            System.out.println(" --:-- "+next_rst +":"+ rst);
            if(next_rst/10 != rst) {
                rst  = 0;
                break;
            }
            rst = next_rst;
            x = x / 10;
        }
        return rst;
    }
}
