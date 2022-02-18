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
�¼���ʲô���и�
���ۣ���һ���ַ�����
1.�ǲ���palindrome�������и���и��ÿһ�ݿ����ǣ�Ҳ���ܲ���palindrome
2.�и��ж��֣��и����2^n
3.����и��ÿһ�ݶ���palindrome����ô�ж����и�������ܶ���
4.����и��Ϊ�˱�֤ÿһ�ݶ���palindrome����ô������Ҫ�и����
5.����и��Ϊ�˱�֤ÿһ�ݶ���palindrome�����ҷ������٣������ж����и
�ж����и����Ϊ����palindrome���ж����з���

min[i] ��ʾ��iλ�õ����һ����ĸ���и�Ϊpalindrome�������и�����
when isPal[i][len-1], check min[len],��ʾlen��len���ַ����������и�����Ϊ0
so min[i]: 0--len+1


*/
