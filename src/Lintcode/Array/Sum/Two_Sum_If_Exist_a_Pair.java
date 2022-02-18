package Lintcode.Array.Sum;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Two_Sum_If_Exist_a_Pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		System.out.println(""+twoSum(arr, 8));
		System.out.println(""+twoSum(arr, 9));
		System.out.println(""+twoSum(arr, 10));
		System.out.println(""+twoSum(arr, 11));
		System.out.println(""+twoSum(arr, 12));
		System.out.println(""+twoSum(arr, 13));
		System.out.println(""+twoSum(arr, 15));
		System.out.println(""+twoSum(arr, 16));
		System.out.println(""+twoSum(arr, 17));
	}
	
	@Test
	private void TestTwoSum(){
		
	}
	
    public static boolean twoSum(int[] nums, int target) {
    	if(nums == null || nums.length <2){
    		return false;
    	}
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            if(set.contains(target - val)){
                return true;
            }else{
                set.add(val);
            }
        }
        return false;
    }

}
