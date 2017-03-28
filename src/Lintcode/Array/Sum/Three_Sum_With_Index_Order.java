package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.apple.laf.resources.aqua_pt_BR;

/**

Three Sum With Index Order

by Walmart
 
题目是  3-sum 变形. 

给一个数组 a, 求出 里面的三个数的组合 满足以下三个条件:-google 1point3acres

1. a[i] + a[j] + a[k] < target
2. a[i] < a[j] < a[k]. 1point3acres.com/bbs
3. i < j < k    (i, j ,k 是数的index)

要求返回所有满足条件的组合.
例如 a [-2, 3, 0, 4]    target:  6   应该返回:    [[-2, 0, 4], [-2, 3, 4]]. 
如果是 [-3, 2, 0, -2, 1, 5] target: 6 应该返回 [[-3, 0, 1], [-3, 0, 5], [-3, 2, 5], [-3, 1, 5], [-2, 1, 5]]

要求时间复杂度是 O(n^2) 的.

楼主试了很多方法都没法用O(n^2)完成, 只给出了 O(n^3)的解法. 

最后 面试官给了一个方法, 先排序, 保存二元元祖(a[i], i)
然后先取 中间元素k, 从中间往俩边遍历. 我觉得没法在O(n^2)时间内做出来, 但是因为时间不够了,所以也没法深入的聊.

楼主的其他面都很好, 但是这一轮没做出来, 最后面试官把 a[i] + a[j] + a[k] < target 改成了 a[i] + a[j] + a[k] = target.. visit 1point3acres.com for more.
楼主写了个 O(n^2)的解法.

总之, 楼主觉得这个题目各种扯, 想了好几天都没想出来合理的解法, 有大神给一个详细的解法吗?


 *
 */
public class Three_Sum_With_Index_Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1, 0, 1, 2, -1, -4};
		int target = 0;
		System.out.println(""+threeSum3(arr, target));
		arr = new int[]{-2, 3, 0, 2,4};
		target = 6;
		System.out.println(""+threeSum3(arr, target));
		arr = new int[]{-3, 2, 0, -2, 1, 5};
		target =6;
		System.out.println(""+threeSum3(arr, target));
		
	}

    static class Node{
        int val;
        int index;
        Node(int val, int index){
        	this.val = val;
        	this.index = index;
        }
    }

    //这是否返回sum <  target
    public static List<List<Integer>> threeSum3(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        int len = nums.length;
        Node[] arr = new Node[len];
        for(int i = 0; i < len; i++){
            arr[i] = new Node(nums[i], i);
        }
        Arrays.sort(arr, (Node a, Node b) -> a.val - b.val);//asc order
        for(int i = 0; i + 2 < len; i++){
            if(i>0 && arr[i].val == arr[i-1].val) continue;//去重
            int left = i+1;
            int right = len - 1;
            while(left < right){
                    int sum = arr[i].val + arr[left].val + arr[right].val;
                    if(sum == target){
                        while(left<right && arr[left].val == arr[left+1].val){
                            left++;
                        }
                        while(left<right && arr[right].val == arr[right-1].val){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < target){
                    	if(arr[i].index < arr[left].index && arr[left].index < arr[right].index){
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i].val);list.add(arr[left].val);list.add(arr[right].val);
                            result.add(list);
                    	}
                        left++;
                    }else{
                        right--;
                    }
            }
        }
        return result;
    }

    
//    //这是否返回sum<  target
//    public static List<List<Integer>> threeSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(nums == null || nums.length < 3){
//            return result;
//        }
//        int len = nums.length;
//        Node[] arr = new Node[len];
//        for(int i = 0; i < len; i++){
//            arr[i] = new Node(nums[i], i);
//        }
//        Arrays.sort(arr, (Node a, Node b) -> a.val - b.val);//asc order
//        for(int i = 0; i + 2 < len; i++){
//            if(i>0 && arr[i].val == arr[i-1].val) continue;//去重
//            int left = i + 1 + (len-1 - i - 1)/2;
//            int right = left+1;
//            while(left > i && right < len){
//                    int sum = arr[i].val + arr[left].val + arr[right].val;
//                    if(sum >= target ){
//                    	left--;
//                    	right--;
//                    }else if(sum < target){
//                    	if(arr[i].index < arr[left].index && arr[left].index < arr[right].index){
//	                    	List<Integer> list = new ArrayList<>();
//	                    	list.add(arr[i].val);list.add(arr[left].val);list.add(arr[right].val);
//	                    	result.add(list);
//	                    	while(left<right && arr[left].val == arr[left+1].val){
//	                    		left++;
//	                    	}
//	                    	while(left<right && arr[right].val == arr[right-1].val){
//	                    		right--;
//	                    	}
//	                    	left++;
//	                    	right--;
//                    	}
//                    }
//            }
//        }
//        return result;
//    }
    
    //这是否返回sum== target
    public static List<List<Integer>> threeSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        int len = nums.length;
        Node[] arr = new Node[len];
        for(int i = 0; i < len; i++){
            arr[i] = new Node(nums[i], i);
        }
        Arrays.sort(arr, (Node a, Node b) -> a.val - b.val);//asc order
        for(int i = 0; i + 2 < len; i++){
            if(i>0 && arr[i].val == arr[i-1].val) continue;//去重
            int left = i+1;
            int right = len - 1;
            while(left < right){
                    int sum = arr[i].val + arr[left].val + arr[right].val;
                    if(sum == target && arr[i].index < arr[left].index && arr[left].index < arr[right].index){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i].val);list.add(arr[left].val);list.add(arr[right].val);
                        result.add(list);
                        while(left<right && arr[left].val == arr[left+1].val){
                            left++;
                        }
                        while(left<right && arr[right].val == arr[right-1].val){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
            }
        }
        return result;
    }
}
