package Lintcode.Array.String.DP;

public class House_Robber_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	worked, best solution, O(n) and O(1)
    public static long houseRobber(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        long prevMax = 0;
        long currMax = 0;
        for(int val : arr){
            long temp = currMax;
            currMax = Math.max(currMax, prevMax + val);//update loop variable
            prevMax = temp;//update loop variable
        }
        return currMax;
    }

//	worked, best solution, O(n) and O(n)
    public static long houseRobber01(int[] arr) {
        // write your code here
        if(arr== null || arr.length==0){
            return 0;
        }
        int len = arr.length;
        if(len == 1){
            return arr[0];
        }
        if(len == 2){
            return Math.max(arr[0], arr[1]);
        }
        // 含义:走到当前位置所能得到的最大数量money
        long []max = new long[arr.length];
        long ans = 0;
        max[0] = arr[0];
        max[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < len; i++) {
            max[i] = Math.max(max[i-1], max[i-2]+ arr[i]);
        }
        return max[len-1];
    }
    
//  worked, TC is O(N), SC is O(N)
    public static long houseRobber02(int[] arr) {
        // write your code here
        if(arr== null || arr.length==0)
            return 0;
        int len = arr.length;
        // 含义:走到当前位置所能得到的最大数量money
        long []max = new long[arr.length];
        if(len >= 1) 
            max[0] = arr[0];
        if(len >= 2)
            max[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < len; i++) {
            max[i] = Math.max(max[i-1], max[i-2]+ arr[i]);
        }
        return max[len-1];
    }

//    worked, TC is O(N), SC is O(1)
    public static long houseRobber03(int[] arr) {
        // write your code here
        if(arr== null || arr.length==0)
            return 0;
        int len = arr.length;
        // 含义:走到当前位置所能得到的最大数量money
        long []max = new long[2];
        if(len >= 1) 
            max[0] = arr[0];
        if(len >= 2)
            max[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < len; i++) {
            max[i%2] = Math.max(max[(i-1)%2], max[(i-2)%2]+ arr[i]);
        }
        return max[(len-1)%2];
    }

}
