package Lai.Array.Binary_Search;

import Utils.SU;

public class Leet_852_Peak_Index_in_a_Mountain_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.leet("1209. Remove All Adjacent Duplicates in String II");
	}

//	Leet_852_Peak_Index_in_a_Mountain_Array The same as Leet_162_Find_Peak_Element
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
    //     recuresive solution
    public int peakIndexInMountainArray_rec(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return peakIndexInMountainArray(arr, left, right);
    }
    private int peakIndexInMountainArray(int[] arr, int left, int right) {
        if(left == right) return left;
        int mid = left + (right - left)/2;           
        if(arr[mid] < arr[mid+1]){
            left = mid + 1;
            return peakIndexInMountainArray(arr, left, right);
        }else{
            right = mid;
            return peakIndexInMountainArray(arr, left, right);
        }
    }


}
