package Leet.Array;

import static Utils.ArrayUtils.toStr;

import java.util.Arrays;

import Utils.TreeNodeUtils.TP;

public class Leet_698_Partition_to_K_Equal_Sum_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {4, 3, 2, 3, 5, 2, 1};
//		int k = 4;
		int[] arr = {4, 3, 2, 3};
		int k = 2;
		System.out.println(""+canPartitionKSubsets(arr, k));
	}
//	新的思路, 转化为01背包问题，给定数组和target, 看看能否装满，需要O(target*n)，之后，继续看看所有k能否装满，总体复杂度 O(k*target*n)
//	
	private boolean canFill(int[] arr, boolean[] visited, int target) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		boolean[] canFill = new boolean[target+1];
		canFill[0] = true;
		for(int i = 0; i < arr.length && visited[i]; i++) {
			for(int j = target; j >= 0; j--) {
				if(j - arr[i] >= 0) {
					canFill[j] = canFill[j] | canFill[j-arr[i]]; 
				}
			}
		}
		return canFill[target];
	}
//	Time Limit Exceeded: Time: O(K^N) Space: O(N)??
    public static boolean canPartitionKSubsets(int[] arr, int k) {
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        Arrays.sort(arr);
        int pos = 0;
        int currSum = 0;
        int[] groups = new int[k];
        TP tp = TP.build("pos:groups:currSum", "110", "root", null, pos + 1, toStr(groups), currSum);
        boolean canPartition = canPartition(arr, target, pos, groups, currSum, tp);
        tp.print();
        return canPartition;
    }
    //从pos开始search，
    static boolean canPartition(int[] arr, int target, int pos, int[] groups, int currSum, TP tp){
        if(pos == arr.length){
            for(int group : groups){
                if(group != target){
                    return false;
                }
            }
            return true;
        }
        for(int i = 0; i < groups.length; i++){
            // if(groups[i] + arr[pos] > target){
            //     continue;
            // }
            groups[i] += arr[pos];
            if(canPartition(arr, target, pos + 1, groups, currSum, TP.build(tp, pos + 1, toStr(groups), currSum))){
                return true;
            }
            groups[i] -= arr[pos];
        }
        return false;
    }

}
