package Lintcode.Array.Sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Two_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[]{1,5,3,9,12};
		int[] arr = new int[]{5,5,3,9,12};
		int target = 10;
		System.out.println("twoSumII : "+twoSumII(arr, target));
		System.out.println("twoSumII2: "+twoSumII2(arr, target));
	}
	
    // Best solution, O(n) Space, O(n) Time
	//只要看set里面有没有target - numbers[i]? 有，就是找到了;没有，就把自己添加进去。
	//有重复元素吗？有影响吗？
    public static boolean twoSumII(int[] numbers, int target) {  
       Set<Integer> set = new HashSet<Integer>();  
       for (int i=0; i<numbers.length; ++i) {
    	   System.out.println(""+numbers[i]);
            if (set.contains(target - numbers[i])) {  
               return true;
            } else {  
                set.add(numbers[i]);  
            }  
       }  
       return false;  
     }     

//    // Best solution, O(n) Space, O(n) Time
//    public static boolean twoSumII(int[] numbers, int target) {  
//       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
//       for (int i=0; i<numbers.length; ++i) {  
//            int x = target - numbers[i];
//            if (map.containsKey(x)) {  
//               return true;
//            } else {  
//                map.put(numbers[i], i);  
//            }  
//       }  
//       return false;  
//     }     
    

     // Can’t use the sort method here, since the question asks for indexes.
    public static boolean twoSumII2(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) return false;
        
        Arrays.sort(numbers);
        
        int start = 0;
        int end = numbers.length -1;
        
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                return true;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            } else{
                end--;
            }
        }
        return false;
    }


}
