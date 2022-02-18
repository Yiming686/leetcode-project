package Lai.Midterm_I_II_III;

import static Utils.ArrayUtils.printIntArray;

import java.util.Arrays;

public class Perfect_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("16:" + numSquares(16));
//		System.out.println("4:" + numSquares(4));
		System.out.println("10:" + numSquares2(10));
//		for(int i = 1; i <= 4; i++) {
//			System.out.println(""+numSquares2(i));
//			System.out.println("------------------------------------------------");
//		}
	}

    public static int numSquares2(int n) {
	    	if(n <= 1) {
	    		return n;
	    	}
        int[] min = new int[n+1];
        min[1] = 1;
         for(int i = 1; i <= n; i++){
             min[i] = i;//min[i] = Integer.MAX_VALUE;
             printIntArray("befor:", min);
             for(int j = 1; j * j <= i; j++){
                min[i] = Math.min(min[i], min[i - j*j] + 1);
             }
             printIntArray("after:" , min);
         }  
        return min[n];
    }

	public static int numSquares(int num) {
		int[] min = new int[num + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 0; i * i <= num; ++i) {
			min[i * i] = 1;
		}

		for (int i = 0; i <= num; ++i) {
			for (int j = 1; j * j <= i; ++j) {
				min[i] = Math.min(min[i], min[i - j * j] + 1);
			}
		}

		return min[num];
	}
//	Time: O(N^1.5)
//	Space: O(N)

}
