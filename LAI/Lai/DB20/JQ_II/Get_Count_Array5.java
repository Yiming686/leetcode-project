package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.List;

import Utils.ArrayUtils;
import Utils.TreeNodeUtils.TP;

public class Get_Count_Array5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,3,2};
//		int[] arr = {5,2,6,1};
		System.out.println(""+(5 >= 4));
//		int[] arr = {5,3,1,4, 2,6};
		ArrayUtils.print(arr);
		ArrayUtils.printIntArray(arr);
//		System.out.println(""+toStr(countArray(arr)));
		System.out.println(""+countSmaller(arr));
	}

    public static List<Integer> countSmaller(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return result;
        }
        int len = arr.length;
        int[] indexArr = new int[len];
        int[] prevIdArr = new int[len];//shared by all
        for(int i = 0; i < len; i++){
            indexArr[i] = i;
//            prevIdArr[i] = i;
            result.add(0);
        }
        countSmaller(result, arr, indexArr, prevIdArr, 0, len - 1);
		ArrayUtils.printIntArray("prevIdArr",prevIdArr);
		ArrayUtils.printIntArray("indexArr",indexArr);

        return result;
    }
    
    private static void countSmaller(List<Integer> result, int[] arr, int[] idArr, int[] prevIdArr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        countSmaller(result, arr, idArr, prevIdArr, start, mid);
        countSmaller(result, arr, idArr, prevIdArr, mid + 1, end);
        merge(result, arr, idArr, prevIdArr, start, mid, end); 
    }
    
    private static void merge(List<Integer> result, int[] arr, int[] indexArr, int[] prevIndexArr, int start, int mid, int end){
        for(int i = start; i <= end; i++){
            

        	[i] = indexArr[i];
        }
        int left = start;
        int right = mid + 1;
        int curr = start;
        while(left <= mid){
            if(right > end || arr[prevIndexArr[left]] <= arr[prevIndexArr[right]]){                
                result.set(prevIndexArr[left], result.get(prevIndexArr[left]) + (right - mid - 1));
                indexArr[curr++] = prevIndexArr[left++];
            }else{
                indexArr[curr++] = prevIndexArr[right++];
            }
        }
    }

}
