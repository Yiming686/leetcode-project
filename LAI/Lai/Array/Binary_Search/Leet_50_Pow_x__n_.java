package Lai.Array.Binary_Search;

import static Utils.TreeNodeUtils.BINARY_TREE_GENERAL_01;

import Utils.SU;

public class Leet_50_Pow_x__n_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = -2147483648; i < 20; i++) {
//			System.out.println(""+myPow(1, -i));
//		}
//		System.out.println("" + -1073741824/2);
//		System.out.println("" + myPow(2.3, -2147483648));		
//		System.out.println("" + myPow(2.3, -2147483648/2));
//		System.out.println("" + myPow(2.3, -5));
		System.out.println("" + myPow(1, -2147483648));
//		System.out.println("" + myPow(1, -2147483648));
//		System.out.println(""+myPow(2.3, -2));
		SU.leet("315. Count of Smaller Numbers After Self\n" + 
				"");
	}

    public static double myPow(double x, int m) {
    		long n = m;
       return myPow(x, n);
    }
    
    public static double myPow(double x, long m) {
		long n = m;
    double result = 0;
    if(n == 0){
        return 1.0;
    }
    if(n == 1){
        return x;
    }
    if(n < 0){
        return 1.0 / myPow(x, -n);
    }
    double half = myPow(x, n / 2);
    if(n % 2 == 0){
        return half * half;
    }else{
        return half * half * x;
    }
}
	
//	public static double myPow(double x, int n) {
//		double result = 0;
//		if (n == 0) {
//			return 1.0;
//		}
//		if (n < 0) {
//			return 1.0 / pow(x, -n);
//		} else {
//			return pow(x, n);
//		}
//	}
//
//	public static double pow(double x, int n) {
//		double result = 0;
//		if (n == 0) {
//			return 1.0;
//		}
//		if (n == 1) {
//			return x;
//		}
//		double half = pow(x, n / 2);
//		if (n % 2 == 0) {
//			return half * half;
//		} else {
//			return half * half * x;
//		}
//	}

}
