package Lai.Probability_Sampling;

import java.util.ArrayList;
import java.util.List;

public class Random7_Using_Rando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + random7());
//		System.out.println(""+15624%7);
//		System.out.println(""+ Math.pow(5, 5) );
//		System.out.println(""+ 4 * Math.pow(5, 5) + 4);
	}

//	A  0, 0, 0, 0, 0,   1, 1, 1, 1, 1,   2, 2, 2, 2, 2,   3, 3, 3, 3, 3,   4, 4, 4, 4, 4,
//	B  0, 1, 2, 3, 4,   0, 1, 2, 3, 4,   0, 1, 2, 3, 4,   0, 1, 2, 3, 4,   0, 1, 2, 3, 4,
//  C  0, 1, 2, 3, 4,   5, 6, 7, 8, 9,  10,11,12,13,14,  15,16,17,18,19,  20,21,22,23,24,
//	结果：C = A * 5 + B
//	以上方案：A和B等概率，组合A和B都是等概论
//	理由：A和B独立，等概率20%得到一个数，得到的组合也是等概率的。
//	4 * 5^0 = 4
//	4 * 5^0 + 4 * 5^1 = 24
//	4 * 5^0 + 4 * 5^1 + 4 * 5^2 = 124
//	4 * 5^0 + 4 * 5^1 + 4 * 5^2 + 4 * 5^3 = 624, 3124, 15624,  ??? val where val % 7 == 0  
	public static int pefect_random7() {
		// write your solution here
		// you can use RandomFive.random5() for generating
		// 0 - 4 with equal probability.
		int radix = 5;
		int val = radix - 1;
		int cof = 1;
		int n = 0;
		List<Integer> list = new ArrayList<>();
		list.add(cof);
		while (val % 7 != 0) {
//			val = val * radix + radix - 1;
			cof = cof * radix;
			val = val + (radix - 1) * cof;
			n++;
			list.add(cof);
		}
		System.out.println("val: " + val);
		System.out.println("n:" + n);
		int result = 0;
		for (int m : list) {
			result += random5() * m;
		}
		System.out.println("result: " + result);
		System.out.println("list:" + list);
		return val;
	}

	private static int random5() {
		// TODO Auto-generated method stub
		return (int) (Math.random() * 5);
	}

	public static int random7() {
		// write your solution here
		// you can use RandomFive.random5() for generating
		// 0 - 4 with equal probability.
//		    while(true){
//		      int val = random5()  * 5 + random5();
//		      if(val < 21 ){
//		        return val % 7;
//		      }
//		    }
		int val = random5() * 5 + random5();
		while (val > 20) {
			val = random5() * 5 + random5();
		}
		return val % 7;
		//val = val  * 5 + RandomFive.random5();

	}

}
