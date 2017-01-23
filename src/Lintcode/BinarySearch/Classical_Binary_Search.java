package Lintcode.BinarySearch;

public class Classical_Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,2};
		int target =2;
		System.out.println(""+findPosition(arr, target));
	}
	
    public static int findPosition(int[] A, int target) {
        // Write your code here

        return findPosition(A, 0, A.length - 1, target);
    }
    private static int findPosition(int[] A, int left, int right, int target){
        if(A == null || A.length == 0){
            return -1;                
        }
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        if(A[left]  == target)  return left;
        if(A[right] == target)  return right;

        return -1;
    }


}
