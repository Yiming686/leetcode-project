package Lintcode.BinarySearch;

/**
Search in a Big Sorted Array 

 Description
 Notes
 Testcase
 Judge
Given a big sorted array with positive integers sorted by ascending order. 
The array is so big so that you can not get the length of the whole array directly, 
and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
Find the first index of a target number. Your algorithm should be in O(log k), 
where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.

 Notice

If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

Have you met this question in a real interview? Yes
Example
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

Challenge 
O(log k), k is the first index of the given target number.

Tags 
Binary Search Sorted Array
Related Problems 
Easy First Position of Target


 *
 */
public class Search_in_a_Big_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //worked
   public static int searchBigSortedArray(ArrayReader reader, int target) {
       // write your code here
       if(reader == null) return -1;
       int start = 0;
       int end = 1;
       while(reader.get(end-1) < target && reader.get(end - 1) != -1 ){
           end = end * 2;//0, 1, 3, 7, 15, 31,63, 
       }
       while(start + 1 < end){
           int mid = start + (end - start)/2;
           int midVal = reader.get(mid);
           if(midVal >= target) 
               end = mid;
           else 
               start = mid;
       }
       if(reader.get(start) == target) return start;
       if(reader.get(end) == target) return end;
       return -1;
   }

   private interface ArrayReader{
	int get(int index);   
   }
}
