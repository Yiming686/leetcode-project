package Lintcode.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
Largest Number

 Description
 Notes
 Testcase
 Judge
Given a list of non negative integers, arrange them such that they form the largest number.

 Notice

The result may be very large, so you need to return a string instead of an integer.

Have you met this question in a real interview? Yes
Example
Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

Challenge 
Do it in O(nlogn) time complexity.

Tags 
Sort
Related Problems 
Easy Kth Largest in N Arrays 24 %
Medium Delete Digits 19 %

 *
 */
public class Largest_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+"306".compareTo("630"));
		System.out.println(""+"8".compareTo("4"));
		System.out.println(""+"4".compareTo("8"));
//		int[] arr = {1, 20, 23, 4, 8};
		int[] arr = {6, 30, 59, 3, 43, 300, 92,21};
		System.out.println(""+largestNumber(arr));
		
	}
	//此题目就要我们把comparator一定要搞清楚
//	对于给定的两个元素如何排序呢？标准一旦制定好，无论s1,s2还是s2,s1,将来排序后的次序是一样的
//	比如string类型的变量s1和 s2，s1+s2大还是s2+s1大呢？
    public static String largestNumber(int[] nums) {
        // write your code here
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // strs[i] = Integer.toString(nums[i]);
            strs[i] = String.valueOf(nums[i]);
        }
        System.out.println("Original        : "+Arrays.toString(strs));//original order
         Arrays.sort(strs);//字典顺序排列
         System.out.println("Original+sorted1: "+Arrays.toString(strs));//字典顺序 order
        Arrays.sort(strs, new Comparator<String>(){
        	@Override
        	public int compare(String s1, String s2) {//return -1, 0, 1
        		return ( s2).compareTo(s1);
//        		return (s2 + s1).compareTo(s1 + s2);
//                 return (s1 + s2).compareTo(s2 + s1);
        	}
        });
        System.out.println("Original+sorted2: "+Arrays.toString(strs));//字典逆序排列
        Arrays.sort(strs, new Comparator<String>(){
        	@Override
        	public int compare(String s1, String s2) {//return -1, 0, 1
        		return (s2 + s1).compareTo(s1 + s2);
//        		return (s2 + s1).compareTo(s1 + s2);
//                 return (s1 + s2).compareTo(s2 + s1);
        	}
        });
        System.out.println("Original+sorted3: "+Arrays.toString(strs));//original order
//        System.out.println(""+Arrays.toString(strs));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }


}
