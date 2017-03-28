package Company.Samsung;

import java.util.Arrays;

public class Find_First_Middle_Balance_Point {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
        //         -1, 2, -2, 3, 4, -2, 0, 1
//                  1, 2, -1, 3,-2, -3, 3, 1 
//                [-1, 2, -2, 3, 4, -2, 0, 1]

        System.out.println(solution(A));
    }
    
    public static int solution2(int[] A) {
        int i = 4;
        int j = 1;
        int k = 0;
        
        for (i = 0; i < 3; i++){
            k += j;
            j = 1 - j;
        }
        return k;
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length <= 1) {
            return -1;
        }
            
        int[] sum = new int[A.length];
        int cum = 0;
        int len = A.length;
        
        for (int i = 0; i < len; i++) {
            cum += A[i];
            sum[i] = cum;
        }
        System.out.println(""+Arrays.toString(sum));
        for (int i = 1; i < len; i++) {
            System.out.println("sum[i]: "+sum[i]);
            if (sum[i - 1] == sum[len - 1] - sum[i]) {
            	System.out.println("i: "+i);
//                return i;
            }
        }
        return -1;
    }


}
