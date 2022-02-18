package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayList;
import java.util.List;

import Utils.ArrayUtils;
import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class Get_Count_Array3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,3,2};
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
        for(int i = 0; i < len; i++){
            indexArr[i] = i;
            result.add(0);
        }
        int[] prevIdArr = new int[len];//shared by all
        TP root = TP.build("", "011111","root", null);
        countSmaller(result, arr, indexArr, prevIdArr, 0, len - 1, root); TP.build("root", null, result, StringUtils.toStr(arr), StringUtils.toStr(indexArr), StringUtils.toStr(prevIdArr), 0, arr.length - 1);
        root.print();
        return result;
    }
    
    private static void countSmaller(List<Integer> result, int[] arr, int[] idArr, int[] prevIdArr, int start, int end, TP root){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        countSmaller(result, arr, idArr, prevIdArr, start, mid, TP.build("left", root)); TP.build("left", root, result, StringUtils.toStr(arr), StringUtils.toStr(idArr), StringUtils.toStr(prevIdArr), start, mid);
        countSmaller(result, arr, idArr, prevIdArr, mid + 1, end,TP.build("right", root)); TP.build("right", root, result, StringUtils.toStr(arr), StringUtils.toStr(idArr),StringUtils.toStr(prevIdArr), mid + 1, end);
        merge(result, arr, idArr, prevIdArr, start, mid, end);
		ArrayUtils.printIntArray("idArr-",idArr);
		ArrayUtils.printIntArray("result-",result.toArray(new Integer[0]));
		ArrayUtils.printIntArray("prevIdArr-",prevIdArr);

    }
    
    private static void merge(List<Integer> result, int[] arr, int[] idArr, int[] prevIdArr, int start, int mid, int end){
        for(int i = start; i <= end; i++){
            prevIdArr[i] = idArr[i];
        }
		ArrayUtils.printConsecutiveChar('-', 100);
		ArrayUtils.printIntArray("arr-",arr);
		System.out.println(""+String.format("[left, mid], [mid + 1, right]: [%d, %d], [%d, %d]  ", start, mid, mid+1, end));
		ArrayUtils.printIntArray("idArr-",idArr);
		ArrayUtils.printIntArray("result-",result.toArray(new Integer[0]));
		ArrayUtils.printIntArray("prevIdArr-",prevIdArr);

        int left = start;
        int right = mid + 1;
        int curr = start;
        while(left <= mid){
            if(right > end || arr[prevIdArr[left]] <= arr[prevIdArr[right]]){                
                idArr[curr++] = prevIdArr[left++];
                result.set(prevIdArr[left], result.get(prevIdArr[left]) + (right - mid - 1));
            }else{
                idArr[curr++] = prevIdArr[right++];
            }
        }
    }
    class Pair{
        int index;
        int val;
        Pair(int index, int val){
          this.index = index;
          this.val = val;
        }
        
      }
}
