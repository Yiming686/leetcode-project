package Lai.Bit_Manipulation;

import Utils.IntegerUtils;
import Utils.LongUtils;

/**
 * Reverse bits of a 32-bit integer.
 * 
 * Note: In different programming languages, integers might be implemented
 * differently in terms of number of bits, signed, unsigned, etc. However it
 * should not affect your implementation on this problem. In java, the type of
 * input is long, but you just need to work on the last 32-bit and consider it
 * as an unsigned 32-bit integer.
 * 
 * Example 1:
 * 
 * Input: 1234 (0b'00000000000000000000010011010010)
 * 
 * Output: 1260388352 (0b'01001011001000000000000000000000)
 *
 *
 * 
 * 
 */
public class Reverse_Bits {

	public static void main(String[] args) {
		
		Integer a = 3;
		Integer b = 9;
		Integer c = 3;
		System.out.println("a==c: "+a.equals(c));
		
//		System.out.println(""+(Integer.MAX_VALUE));
		long y = 255L;
		System.out.println(""+ LongUtils.toBinaryString(y));
		System.out.println(""+ IntegerUtils.toBinaryString(1 << 31));
		System.out.println(""+ LongUtils.toBinaryString(y ^ (1 << 31)));
		
//		System.out.println(""+ LongUtils.toBinaryString(y ^ (1 << 31)));
//		System.out.println(""+ LongUtils.toBinaryString(y ^ (1 << 31)));
//		System.out.println(""+ LongUtils.toBinaryString(y ^ (1 << 31)));
		System.out.println(""+ LongUtils.toBinaryString(Long.valueOf(1 << 31)));
		System.out.println(""+ IntegerUtils.toBinaryString(Integer.valueOf(1 << 31)));
		System.out.println("==>"+(Long.valueOf(1 << 31)));
		System.out.println("==>"+( 1 << 31));
		
		
		
		
		
//		System.out.println(""+(Long.valueOf(1) << 31));
		System.out.println(""+(y ^ (1 << 31)));
		System.out.println(""+(y ^ (Long.valueOf(1) << 31)));
		int num = 131;
		int num2 = -131;
		System.out.println("" + IntegerUtils.toBinaryString(num));
		System.out.println("" + IntegerUtils.toBinaryString(num2));
//		reverseBitsII(num);
		
//		short a = -1;
//		
//		System.out.println("" + (int) a);
//		char b = (char) a;
//		System.out.println("" + (int) b);
//
//		System.out.println("" + IntegerUtils.toBinaryString((int) a));
//		System.out.println("" + IntegerUtils.toBinaryString((int) b));
		// TODO Auto-generated method stub
//		int num = -231;
//		long num = 32768L;
//		System.out.println(""+IntegerUtils.toBinaryString(num));
//		System.out.println(""+IntegerUtils.toBinaryString(num >> 3));

//		System.out.println(""+IntegerUtils.toBinaryString(reverseBits(num, 7, 4)));

//		System.out.println("" + LongUtils.toBinaryString(num));
//		System.out.println("" + LongUtils.toBinaryString(reverseBits(num, 31, 0)));
//		Long r_num = reverseBits(num);
//		System.out.println(""+LongUtils.toBinaryString(reverseBits(num)));
	}

//	public static int reverseBits(int n, int high, int low) {//index ���� ex. 0-31
//		
//	}
//	��չ������int ��ת high to low
	public static int reverseBits(int n, int high, int low) {//index ���� ex. 0-31
		int width = high - low + 1;
		for (int offset = 0; offset < width / 2; offset++) {//offset�������壺��ͷ[upper, lower], ��0��һ��,����bit��0λ�õľ���
			long right = (n >> (low + offset)) & 1;//lowerPos+offset
			long left = (n >> (high - offset)) & 1;//upperPos-offset
			if (left != right) {
				n ^= (1 << (low + offset));
				n ^= (1 << (high - offset));
			}
		}
		return n;
	}

//	����Long ��ת high to low
	public static long reverseBits(long n, int high, int low) {//index ���� ex. 0-31
		int width = high - low + 1;
		for (int offset = 0; offset <= width / 2; offset++) {//offset�������壺��ͷ[upper, lower], ��0��һ��,����bit��0λ�õľ���
			long right = (n >> (low + offset)) & 1;//lowerPos+offset
			long left = (n >> (high - offset)) & 1;//upperPos-offset
			if (left != right) {
				n ^= (1L << (low + offset));
				n ^= (1L << (high - offset));
			}
		}
		return n;
	}

	public static long reverseBits(long n) {
		// Write your solution here
		for (int offset = 0; offset < 16; offset++) {//offset�������壺��ͷ[31, 0], ��0��һ��,����bit��0λ�õľ���
			long right = (n >> offset) & 1; //0+offset
			long left = (n >> (31 - offset)) & 1;//31-offset
			if (left != right) {
				n ^= (1L << offset);
				n ^= (1L << (31 - offset));
			}
		}
		return n;
	}

	public static long reverseBitsII(int num) {
		num = ((num & 0xFFFF0000) >>> 16) | ((num & 0x0000FFFF) << 16); System.out.println("" + IntegerUtils.toBinaryString(num));
		num = ((num & 0xFF00FF00) >>> 8) | ((num & 0x00FF00FF) << 8);   System.out.println("" + IntegerUtils.toBinaryString(num));
		num = ((num & 0xF0F0F0F0) >>> 4) | ((num & 0x0F0F0F0F) << 4); System.out.println("" + IntegerUtils.toBinaryString(num));
		num = ((num & 0xCCCCCCCC) >>> 2) | ((num & 0x33333333) << 2); System.out.println("" + IntegerUtils.toBinaryString(num));
		num = ((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1); System.out.println("" + IntegerUtils.toBinaryString(num));
		return num;
	}

}
