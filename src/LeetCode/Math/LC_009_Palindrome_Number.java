package LeetCode.Math;

public class LC_009_Palindrome_Number {

    public static boolean isPalindrome(int x) {
        if (x < 0)  
            return false;  
              
        if (x < 10)  
            return true;  
              
        // int digits = 0;  
        int t = x;  
        // int d = 0;  
        long d = 1;  
        while(t != 0){ 
            t /= 10;
            d *= 10;
            System.out.println(t);

            System.out.println(d);
            // d++;
        }
        System.out.println("out:" +d);
        int left = (int)(d/10);
    //   int left =(int)Math.pow(10, d - 1);  
        int right = 1;  
        while( left > right)  
        {  
            if (x / left % 10 != x / right % 10)  
                return false;  
              
            left /= 10;  
            right *= 10;  
        }  
        return true;    
     
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(1000000001);
        System.out.println(isPalindrome(1000000001));

	}

}
