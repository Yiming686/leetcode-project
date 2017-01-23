package Lintcode.Array.Sum;

import java.util.Arrays;
import java.util.HashMap;

/**
Two Sum Show result 

30:00
 Start
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

Have you met this question in a real interview? Yes
Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]

Note
You may assume that each input would have exactly one solution

Challenge
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
Tags Expand 
Two Pointers Sort Hash Table Array Airbnb Facebook


Related Problems Expand 
Medium 3Sum Closest 29 %
Medium 4Sum 18 %
Medium 3Sum
 *
 */
public class Two_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    // Best solution, O(n) Space, O(n) Time
    public int[] twoSum(int[] numbers, int target) {  
       // a map that maps integer to its index  
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
       int[] indexes = new int[2];  
       for (int i=0; i<numbers.length; ++i) {  
            int x = target - numbers[i];
            //  if (map.get(x) != null) {  
            if (map.containsKey(x)) {  
                indexes[0] = map.get(x) + 1;  
                indexes[1] = i + 1;  
            } else {  
                map.put(numbers[i], i);  
            }  
       }  
       return indexes;  
     }     
    
    // Jiuzhang, Not best solution, O(n) Space, O(n) Time
    public int[] twoSum77(int[] numbers, int target) {
    	if(numbers == null || numbers.length < 2) {
    		return null;
    	}
    	//map记录元素和index, in order to make it O(N), to create a hashMap and get the index
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            hs.put(numbers[i], i+1);
        }       
        
        int[] a = new int[2];
        
        for(int i=0; i<numbers.length ; i++){
            if ( hs.containsKey( target - numbers[i] )){
                // int index1 = i+1;
                // int index2 = hs.get(target - numbers[i]);
                //重要考察点：相等时就是一个元素，所以除外
                // if (index1 == index2){
                if (hs.get(target - numbers[i]) == i+1){
                    continue;
                }
                // a[0] = index1;
                // a[1] = index2;
                a[0] = i+1;
                a[1] = hs.get(target - numbers[i]);
                return a;
            }
        }
        return a;
    }

     // Can’t use the sort method here, since the question asks for indexes.
    public int[] twoSum3(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) return result;
        
        Arrays.sort(numbers);
        
        int start = 0;
        int end = numbers.length -1;
        
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            } else{
                end--;
            }
        }
        return result;
    }
	
}
