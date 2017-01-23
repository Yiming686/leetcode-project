package Lintcode.BinarySearch;

import java.util.List;

import Lintcode.BinarySearch.RocketFuel_Racer_Rater_3.SpaceShip;

/**
Search Insert Position

15:00
 Start
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Have you met this question in a real interview? Yes
Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0

Challenge
O(log(n)) time

Tags Expand 
Binary Search Sorted Array Array

 *
 */
public class Search_Insert_Position {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = new int[]{1,3,5,6};
		int target = -1;
//		target = 5;System.out.println(""+searchInsert(arr1, target));
		target = 2;System.out.println(""+searchInsert(arr1, target));
//		target = -12;System.out.println(""+searchInsert(arr1, target));
//		target = 0;System.out.println(""+searchInsert(arr1, target));
		target = 63;System.out.println(""+searchInsert(arr1, target));
	}
	
    //第一解法：【无界外target, only 3, 激进跳跃】，Jiuzhang, worked, as a template，实现中间逻辑，注意根据题意确认最后的逻辑
    // 如果开始不加以保证，target必须落在0 - (n-1) 范围内
    // 最后必须处理各种情况,范围为(MIN, MAX)
    public static int searchInsert11(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                // the two lines below work
                // end = mid - 1;
                end = mid ;
            }
        }
        // (MIN, start] insert start, (start, end] insert end, (end, MAX) insert end + 1
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;//考虑超出数组长度的情况
        }
    }
    
    //第一解法：【无界外target, only 3, 激进跳跃】
    public static int searchInsert12(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
//        if(target < A[0]) return 0;
//        if(target > A[A.length-1]) return A.length;
        int start = 0, end = A.length - 1;
        while (start +1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println("start: "+ start + ", end: " + end);
            System.out.println("mid: "+ mid);
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //   if (A[start] > target) return start; 
        // System.out.print(start);
        System.out.println("start: "+ start + ", end: " + end);
        if (A[start] < target) 
            return end; 
        else
            return start;
    }

    
    //worked, best solution, leetcode worked
	//如果等于a,就插入a的index此位置，如果介于a,b两个元素中间，返回b的index
	//如果小于左边界left，返回left;如果大于右边界，返回right+1
    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        //循环中start和end的范围：0--len-1， 等号太关键了：
        //命名为：大步搜索法，直到范围为0，包含所有的小于和等于
        while (start <= end) {//准备在start和end中间search
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+ mid);
            if (A[mid] == target) {//谢天谢地，找到了，根据规则，直接返回
                return mid;
            } else if (A[mid] < target) {//找到的小了，右边找
                start = mid+1;//start有可能变为len,此时mid为len
//                System.out.println("start: "+start);
            } else {//找到的大了，左边找
                end = mid -1; ////end有可能变为-1,此时mid为0
//                System.out.println("end: "+end);
            }
        }
        return start;//end+1就是start
    }
    
    
    //list版本
	private static int getIndexToInsert(List<Integer> listByStartTime, Integer ss) {
		int left = 0;
		int right = listByStartTime.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (ss == listByStartTime.get(mid))
				return mid;
			if (ss < listByStartTime.get(mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

	private static int getIndexToInsert(List<SpaceShip> listByStartTime, SpaceShip ss) {
		int left = 0;
		int right = listByStartTime.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (ss.startTime == listByStartTime.get(mid).startTime)
				return mid;
			if (ss.startTime < listByStartTime.get(mid).startTime)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}


}
