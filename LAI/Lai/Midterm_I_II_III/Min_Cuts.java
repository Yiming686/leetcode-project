package Lai.Midterm_I_II_III;

import Lintcode.Matrix.Matrix;

public class Min_Cuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbabb";
		System.out.println(""+str);
		System.out.println(""+minCuts_01(str));
		System.out.println(""+minCuts_02(str));
	}

	public static int minCuts_01(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		int len = s.length();
		int min[] = new int[len + 1];
		boolean[][] isPal = new boolean[len][len];
		for (int i = 0; i <= len; i++) {
			min[i] = len - i - 1;//max cuts
		}

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1])) {
					isPal[i][j] = true;
					min[i] = Math.min(min[i], min[j + 1] + 1);
				}
			}
		}
		return min[0];
	}
	
	//M[i][j] min cuts from i to j
	//M[0][0] = 1
	//M[i][j] = M[i+1][j-1]      ;                                         if arr[i] == arr[j]
//	              Math.min(M[i+1][j], M[i][j-1]) + 1                 otherwise
	  public static int minCuts_02(String input) {
	    // Write your solution here
	    if(input == null || input.length() <= 1){
	      return 0;
	    }
	    int len = input.length();
	    int[][] min = new int[len][len];
	    for(int i = len - 1; i >= 0; i--){
	      for(int j = i+1; j < len; j++){
	        if(input.charAt(i) != input.charAt(j)){
	          if(j - i == 1){
	            min[i][j] = 1;
	          }else{
	            min[i][j] = Math.min(min[i+1][j], min[i][j-1]) + 1;
	          }
	        }else{
	          min[i][j] = min[i+1][j-1] + 2;
	        }
	      }
	    }
	    System.out.println(""+Matrix.fromMatrixToString(min));
	    return min[0][len - 1];

	  }


}

/*
事件是什么：切割
结论：对一个字符串：
1.是不是palindrome？采用切割法，切割后每一份可能是，也可能不是palindrome
2.切割有多种，切割方法？2^n
3.如果切割后，每一份都是palindrome，那么有多种切割方法？可能多种
4.如果切割后，为了保证每一份都是palindrome，那么最少需要切割几刀？
5.如果切割后，为了保证每一份都是palindrome，并且份数最少？可能有多种切割法
有多种切割方法？为了是palindrome，有多种切法？

min[i] 表示从i位置到最后一个字母，切割为palindrome的最少切割数，
when isPal[i][len-1], check min[len],表示len到len空字符串，最少切割树，为0
so min[i]: 0--len+1


*/
