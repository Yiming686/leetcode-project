package LeetCode.JavaArray;


/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Hide Tags Array Binary Search

 */
public class LC_153_Find_Minimum_in_Rotated_Sorted_Array {
	
//	Accepted, O(logN)
//	这个思想就是mid要和end比，不能和start比
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while( start<end ){
            int mid = (start+end)/2;
            if (num[mid] > num[end])
                start = mid+1;
            else if (num[mid]<num[end])
                end = mid;
        }
        return num[start];
    }
    
//    Accepted, O(N)
    public int findMin3(int[] num) {
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }
    
//   Accepted, O(logN)
    public int findMin4(int[] num) {
    	if(num == null || num.length == 0) return -1;
    	
    	return findMin4(num, 0, num.length - 1);
    }
    public int findMin4(int[] num, int start, int end) {
    	if(start == end )  return num[start];
        int mid = (start+end)/2;
        if (num[mid] > num[end])
        	return findMin4(num, mid + 1, num.length - 1);
        else
        	return findMin4(num, start, mid);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
