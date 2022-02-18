package Lai.Bit_Manipulation;

import Utils.IntegerUtils;
import Utils.TreeNodeUtils.TP;

public class Number_Of_Different_Bits {
	static class AAA{
		Number_Of_Different_Bits ob = new Number_Of_Different_Bits();
//		private int counBits(int num, int bits) {
//			int num = (1 << 18) - 1 - 0;
//			ob.counBits(num, 32);
//			ob.counBits(num, bits)
//		}
	}
	public static void main(String[] args) {
		System.out.println("" + IntegerUtils.toBinaryString(13));
		System.out.println("" + IntegerUtils.toBinaryString(183));
		System.out.println(""+diffBitsLOG(127, 15));//127, 15 expected:<3> but was:<7>
//		System.out.println(""+ (1/2));
//		System.out.println(""+ (1%2));
//		System.out.println(""+ (31/2));
//		System.out.println(""+ (31%2));
		
		// TODO Auto-generated method stub
//		int num = (1 << 12) - 1;
//		int num = (1 << 28) - 1 - 837927220;
		int num = (1 << 28) - 1 - 837927220; // good number: (1 << 28) - 1 - 837927220;
		System.out.println("" + IntegerUtils.toBinaryString(num));
		System.out.println("" + Integer.toBinaryString(num));		
//		System.out.println(""+countBitsWhileLoop(num));
		
		System.out.println("" + counBits(num, 32));
		
		TP root = TP.build("level:num", "111", null, num, 31, 0);
//		System.out.println("" + counBits(num, 31, 0, root));
		System.out.println("" + counBits(num, 31 ,0, root));
		root.print();
//		int k = 200;
//		while( --k >= 0) {
////			System.out.println("num: "+num);
//			num -= k;
//			int expected = countBitsWhileLoop(num);
//			int actual = counBitsTP(num, 32, root);
////			int actual = counBits(num, 31, 0, root);
//			if(expected != actual) {
//				System.out.printf("=====================FALSE!!! expected:actual %s:%s \n", expected, actual);
//			}else {
////				System.out.printf("TRUE!!! \n");
//			}
//		}
//		System.out.println("" + counBits(num, 32));
	}

	public static int diffBitsLOG(int a, int b) {
		int num = a ^ b;
		System.out.println("" + IntegerUtils.toBinaryString(num));
		if (num == 0) {
			return 0;
		} else if (num > 0) {
			return (int) (Math.log(num) / Math.log(2) + 1);
		} else {
			num = ~num;
			System.out.println("" + IntegerUtils.toBinaryString(num));
			return 16 - (int) (Math.log(num) / Math.log(2) + 1);
		}
	}

	private static int countBitsWhileLoop(int xor) {
		// Write your solution here
		int count = 0;
		while (xor != 0) {
			count += xor & 1;
			xor >>>= 1;
		}
		return count;
	}

//	Time: O(N), Space: O(1)
	public static int diffBits(int a, int b) {
		// Write your solution here
		int xor = a ^ b;
		int count = 0;
		while (xor != 0) {
			count += xor & 1;
			xor >>>= 1;
		}
		return count;
	}

//	Time: O(logN), Space: O(log), where N is number of bit 1.
	public static int diffBitsII(int a, int b) {
		// Write your solution here
		int xor = a ^ b;
		return counBits(xor, 32);
//		return counBits(xor, 31, 0);
	}

//	num ����bits�� ͳ�Ƴ���
	private static int counBits(int num, int bits) {
		if (bits == 1) {
//			if ((num & 1) == 0) {
//				return 0;
//			}
//			if ((num & 1) == 1) {
//				return 1;
//			}
			//better than above
			return (num & 1) == 0 ? 0 : 1;
		}
		bits /= 2;
		return counBits(num >>> bits, bits) + counBits((num << bits) >>> bits, bits);
	}
	
	
	/**
	 * @param num һ��������bit����������
	 * @param bits ��ǰҪ����bit�����ķ�Χ��ȣ�32����0-31��16����0-15��2����0-1��1�������Ǿ�ʣ1λ�ˣ�Ҳ����base case����ҲҪ��num�ĵ�0λ�������һλ
	 * @param root
	 * @return
	 * 
//	��ô������ȷ�ģ���Ͳ������⣬���򣺲��2^N��1�������ֲ㣬ÿһ��bitλ���ᱻ�ݹ鵽�������һ��ֻҪnum�ĵ�0λ����ȷ�ṩ�ģ���ô������������ȷ�ء�
//		���򣺸����������ķ��������ݶ��壬���������ֵķ���ֵ����Ӽ�Ϊ�µķ���ֵ��
//           ͬʱҪ�����Ҳ��ṩ��ȷ��num����������ȷ��num�ĵ�0λ�����ʵ�ʼ���[bits-1 <--> bits/2]��bit�����Ҳ�ʵ�ʼ���[bits/2 - 1 <--> 0]��bit��

	 */
	private static int counBitsTP(int num, int bits, TP root) {
		if (bits == 1) {
			if ((num & 1) == 0) {
				return 0;
			}
			if ((num & 1) == 1) {
				return 1;
			}
		}
		bits /= 2;
//		return counBitsTP(num >>> bits, bits, TP.build(root,num >>> bits, bits )) + counBitsTP((num << bits) >>> bits, bits, TP.build(root, (num << bits) >>> bits , bits));
//		return counBitsTP(num >>> bits, bits, TP.build(root,num >>> bits, bits )) + counBitsTP(num, bits, TP.build(root, num , bits));
		
		return counBitsTP(num >>> bits , bits, TP.build(root, num >>> bits , bits )) + counBitsTP(num, bits, TP.build(root, num , bits));
	}

//	num ����bits�� left and right vary from 0 to 31, all zero in [left, right]
	private static int counBits(int num, int left, int right, TP root) {
//		System.out.printf("left:right %s:%s \n", left, right);
		if (left <= right) {
//			num >>>= right;
			if ((num & 1) == 0) {
				return 0;
			}
			if ((num & 1) == 1) {
				return 1;
			}
		}
//		int mid = left + (right - left) / 2;  IntegerUtils.toBinaryString(num >>> (mid + 1 - right), false)
		int mid = right + (left - right) / 2;
		
		return    counBits(num >>> (mid + 1 - right), left, mid + 1, TP.build(root, num >>> (mid + 1 - right), left, mid + 1))
				+ counBits((num << (left - mid)), mid, right,TP.build(root, (num << (left - mid)), mid, right));

//		return    counBits(num >>> (mid + 1 - right), left, mid + 1, TP.build(root, num >>> (mid + 1 - right), left, mid + 1))
//				+ counBits(num, mid, right,TP.build(root, num , mid, right));
//		return    counBits(num >>> (mid + 1 - right), left, mid + 1, TP.build(root, num >>> (mid + 1 - right), left, mid + 1))
//				+ counBits(num >>> right, mid, right,TP.build(root, num >>> right , mid, right));
		
//		worked, if num >>>= right; when left <= right
//		return    counBits(num , left, mid + 1, TP.build(root, num, left, mid + 1))
//				+ counBits(num , mid, right,TP.build(root, num , mid, right));

		
		
//		return    counBits(num >>> (mid + 1 - right), left, mid + 1, TP.build(root, IntegerUtils.toBinaryString(num >>> (mid + 1 - right), false), left, mid + 1))
//				+ counBits(num, mid, right,TP.build(root, IntegerUtils.toBinaryString(num, false) , mid, right));

		
//		return counBits( num >>> (mid - right), left, mid) + counBits((num << (left - mid -1)), mid + 1, right);
	}

}
