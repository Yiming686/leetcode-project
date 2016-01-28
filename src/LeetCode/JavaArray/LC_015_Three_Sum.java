package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 Hide Tags Array Two Pointers

 * 
 */
public class LC_015_Three_Sum {
	
	//Jiuzhang solution
	//����Ŀ�ľ��ʿ��������ȥ�أ�����Ҫ3��ȥ��
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//��Ȼ��3sum, С��3��Ԫ�ض����ؿ�
		if(num == null || num.length < 3) {
			return result;
		}
		//ֻҪֵ����Ҫindex���Կ��Կ�������
		Arrays.sort(num);
		//��ʼѭ����Ԫ�أ���β��length-2
		for (int i = 0; i < num.length - 2; i++) {
		    //��Ե�ǰԪ�أ������кܶ��Ԫ�أ�ʹ�������ܺ�Ϊ0
		    if(num[i]>0)break;
		    //�����ظ���Ԫ��
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			//here, search for all the interger pairs,and add them to result
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					result.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		if (nums == null)
			return null;
		int len = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (len < 3)
			return result;
		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
//			����Ŀ���ʵ����������д��룬ȱһ���ɣ�ǰ��������
			// ��Ϊ�������
			if (nums[i] > 0)
				break;
			// �ӵڶ���Ԫ�ؿ�ʼ�����ظ���˵��ǰ��һ���Ѿ������ˣ�continue��ȥ���ظ�
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum < 0) {
					start++;
				} else if (sum > 0) {
					end--;
				} else {
					List<Integer> intList = new ArrayList<Integer>();
					intList.add(nums[i]);
					intList.add(nums[start]);
					intList.add(nums[end]);
					result.add(intList);
//					����Ŀ��ξ��ʵ����������д���
					do {
						start++;
					} while (start < end && nums[start] == nums[start - 1]);
					do {
						end--;
					} while (start < end && nums[end] == nums[end - 1]);
				}
			}

		}
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { -1, 0, 1, 2, -1, -4 };
		threeSum(S);
	}
	
	
    public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		int closet = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)'
		for (int i = 0; i < num.length - 2; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
			}
		}
		return closet;
	}
    
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0) return null;
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for(String key : words){
            if(!map1.containsKey(key)){
                map1.put(key, 1);
            }else{
                map1.put(key, map1.get(key)+1);
            }
        }
        Map<Integer, List<String>> map2 = new HashMap<Integer, List<String>>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(!map2.containsKey(entry.getValue())){
                List<String> list = new ArrayList<String>();
                list.add(entry.getKey());
                map2.put(entry.getValue(), list);
            }else{
                List<String> list = map2.get(entry.getValue());
                list.add(entry.getKey());
                map2.put(entry.getValue(), list);
            }
        }
        return map2.get(k).toArray(new String[0]);
    }

}
