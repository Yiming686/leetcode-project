package Lai.DB18.JQ_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_18_4_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,0,0};
		int target = 0;
		System.out.println(""+fourSum(arr, target));
		
	}

	public static List<List<Integer>> fourSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 3; i++) {
			if (i != 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			for (int j = i + 1; j < arr.length - 2; j++) {
				if (j != 0 && arr[j - 1] == arr[j]) {
					continue;
				}
				int left = j + 1;
				int right = arr.length - 1;
				while (left < right) {
					int sum = arr[i] + arr[j] + arr[left] + arr[right];
					if (sum == target) {
						List<Integer> list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[left]);
						list.add(arr[right]);
						result.add(list);
						left++;
						right--;
						while (left < right && arr[left - 1] == arr[left]) {
							left++;
						}
						while (left < right && arr[right + 1] == arr[right]) {
							right--;
						}
						// left++;
						// right--;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}

		}
		return result;
	}

}
