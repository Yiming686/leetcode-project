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
[1,3,5,6], 5 �� 2

[1,3,5,6], 2 �� 1

[1,3,5,6], 7 �� 4

[1,3,5,6], 0 �� 0

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
	
    //��һ�ⷨ�����޽���target, only 3, ������Ծ����Jiuzhang, worked, as a template��ʵ���м��߼���ע���������ȷ�������߼�
    // �����ʼ�����Ա�֤��target��������0 - (n-1) ��Χ��
    // �����봦��������,��ΧΪ(MIN, MAX)
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
            return end + 1;//���ǳ������鳤�ȵ����
        }
    }
    
    //��һ�ⷨ�����޽���target, only 3, ������Ծ��
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
	//�������a,�Ͳ���a��index��λ�ã��������a,b����Ԫ���м䣬����b��index
	//���С����߽�left������left;��������ұ߽磬����right+1
    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        //ѭ����start��end�ķ�Χ��0--len-1�� �Ⱥ�̫�ؼ��ˣ�
        //����Ϊ������������ֱ����ΧΪ0���������е�С�ں͵���
        while (start <= end) {//׼����start��end�м�search
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+ mid);
            if (A[mid] == target) {//л��л�أ��ҵ��ˣ����ݹ���ֱ�ӷ���
                return mid;
            } else if (A[mid] < target) {//�ҵ���С�ˣ��ұ���
                start = mid+1;//start�п��ܱ�Ϊlen,��ʱmidΪlen
//                System.out.println("start: "+start);
            } else {//�ҵ��Ĵ��ˣ������
                end = mid -1; ////end�п��ܱ�Ϊ-1,��ʱmidΪ0
//                System.out.println("end: "+end);
            }
        }
        return start;//end+1����start
    }
    
    
    //list�汾
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
