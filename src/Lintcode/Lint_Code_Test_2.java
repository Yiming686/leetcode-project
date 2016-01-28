package Lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lint_Code_Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-33,-19,30,26,21,-9};
//		rerange(arr);
//		System.out.println(""+Arrays.toString(arr));
		
		System.out.println(""+Integer.valueOf("9"));
//		System.out.println(""+isHappy(19));
	}
    public static boolean isHappy(int n) {
        // Write your code here
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1 || !set.contains(n)){
            String str = String.valueOf(n);        
            int sum = 0;
            for(char ch : str.toCharArray()){
                int digit = Integer.valueOf(ch);
                sum += digit * digit;
            }
            System.out.println(""+sum);
            set.add(sum);
            n = sum;
        }
        if(n == 1) 
            return true;
        else
            return false;
    }
}
