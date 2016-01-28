package Lintcode.Bit.Manipulation;

/**
Flip Bits Show result 

Determine the number of bits required to flip if you want to convert integer n to integer m.

Have you met this question in a real interview? Yes
Example
Given n = 31 (11111), m = 14 (01110), return 2.

Note
Both n and m are 32-bit integers.

Tags Expand 
Cracking The Coding Interview Bit Manipulation


 *
 */
public class Flip_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
   public static int bitSwapRequired(int a, int b) {
       // write your code here
       int xor = a ^ b;
       int count = 0;
       while(xor != 0){
           xor = xor & (xor-1);
           count++;
       }
       return count;
   }

}
