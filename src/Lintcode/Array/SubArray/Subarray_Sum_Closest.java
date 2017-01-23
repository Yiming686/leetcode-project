package Lintcode.Array.SubArray;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
Subarray Sum Closest

 Description
 Notes
 Testcase
 Judge
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time

Tags 
Subarray Sort
Related Problems 
Medium Submatrix Sum 24 %
Medium Minimum Size Subarray Sum 26 %
Easy Subarray Sum 29 %

 *
 *
 */
public class Subarray_Sum_Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,10,5,3,2,1,1,-2,-4,3};
//		int[] arr = {6,-4,-8,3,1,7};
//		             0, 6,-4, -8,  3,  1, 7
//		            -1, 0, 1,  2,  3,  4, 5
//					0,-1;  6,0;  2,1;  -6,2;  -3,3;  -2,4;  5,5;  
//		     		(-6, 2)(-3,3)(-2,4)(0,-1)(2,1)(5,5)(6,0)
//					3,
		System.out.println(""+Arrays.toString(subarraySumClosest(arr)));
	}

    public static int[] subarraySumClosest(int[] nums) {
        return subarraySumClosest(nums, 0);
    }
    public static int[] subarraySumClosest(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        } 
        
        int len = nums.length;
        if(len == 1) {
            return res;
        }
        Pair[] sums = new Pair[len];
        //���ǰi���Ԫ�غ�
        sums[0] = new Pair(nums[0], 0);
        for (int i = 1; i < len; i++) {
            sums[i] = new Pair(sums[i-1].sum + nums[i], i);
        }
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            //�����ȷ����ļ���С�ģ���ʵ���Ǽ��˾���ֵ���Ҿ���ֵ��С
            if (sums[i].sum - sums[i-1].sum - target < ans) {
                ans = sums[i].sum - sums[i-1].sum;
                
                if(sums[i].index < sums[i - 1].index){
                    res[0] = sums[i].index+1;//�Ѿ���1��
                    res[1] = sums[i-1].index;//���Դ˴�Ҫ��1
                }else{
                    res[0] = sums[i-1].index+1;//�Ѿ���1��
                    res[1] = sums[i].index;//��
                }

                // int[] temp = new int[]{sums[i].index, sums[i - 1].index};//������index����Ҫ��1��
                // // Arrays.sort(temp);
                // res[0] = (temp[0] + 1);//�ǵñ����1����Ϊ��һ��λ�ò��ǿ�ʼλ��
                // res[1]= (temp[1]);
            }
        }
        return res;
    }
    
    static class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }
	
	
    //��TreeMap����,���У���Ϊsum�������ظ�ֵ
    //�Ľ��棬better than jiuzhang, ��Ȼworked
    public static int[] subarraySumClosest77(int[] nums) {
            // write your code here
            int[] res = new int[2];
            if (nums == null || nums.length == 0) {
                return res;
            } 
            int len = nums.length;
            if(len == 1) {
                return res;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int prev = 0;
            map.put(0, -1);
            for (int i = 0; i < len; i++) {
                prev += nums[i];
                System.out.println(""+prev);
                map.put(prev, i);
            }

            int ans = Integer.MAX_VALUE;
            Map.Entry<Integer, Integer> prevEntry = null;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(prevEntry != null && entry.getKey() - prevEntry.getKey() < ans ){
                    ans = entry.getKey() - prevEntry.getKey();
                    if(entry.getValue() < prevEntry.getValue()){
                        res[0] = entry.getValue()+1;//�Ѿ���1��
                        res[1] = prevEntry.getValue();//���Դ˴�Ҫ��1
                    }else{
                        res[0] = prevEntry.getValue()+1;//�Ѿ���1��
                        res[1] = entry.getValue();//���Դ˴�Ҫ��1
                    }
//                    System.out.println(MessageFormat.format("ans:{0}, res:{1}:{2} "));
                    System.out.println(MessageFormat.format("ans:{0}, res:{1}:{2} ", ans, res[0], res[1]));
                }
                prevEntry = entry; 
            }
            return res;
        }

}
