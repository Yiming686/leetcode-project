package LeetCode.JavaArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class LC_001_Two_Sum_II_Test {

	@Test
	public void test() {
		LC_001_Two_Sum_II twosum = new LC_001_Two_Sum_II();
//		int[] nums = { 2, 7, 11, 15 };
		int[] nums = { 3,3,2,4 ,3};

//		int target = 18;
		int target = 6;

		int[] result = twosum.twoSum_II_WithDups_ON(nums, target);
		System.out.println(result[0] + " " + result[1]);

	}
}