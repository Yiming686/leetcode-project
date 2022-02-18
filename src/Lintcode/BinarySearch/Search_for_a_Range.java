package Lintcode.BinarySearch;

/**

Search for a Range 

 Description
 Notes
 Testcase
 Judge
Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Have you met this question in a real interview? Yes
Example
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Challenge 
O(log n) time.

Tags 
Binary Search Sorted Array Array
Related Problems 
Medium Range Sum Query 2D - Immutable 31 %
Easy Total Occurrence of Target

 *
 */
public class Search_for_a_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

/*
 ��if-else-if-else ����������
 �������ڣ�ֻ����һ����ִ�У��������ǲ��ǲ��еģ����������ȼ���
 �����һ���������㣬�ӵ�һ���ڳ�ȥ�����ڿ��Ǻ������
 �����һ�����������㣬����ڶ���������
 ����ڶ����������㣬�ӵڶ����ڳ�ȥ�����ڿ��Ǻ������
 ����ڶ������������㣬ֱ�Ӵӵ��������ڳ�ȥ
 
 LintCode case 
 * */
	
	
    //  worked, BEST, keep in mind
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[]{-1, -1}; 
        if (A == null || A.length == 0) {
            return range;
        }
        int len = A.length;
        int start = 0; 
        int end = len-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] >= target){//���������ҵ�һ��
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        if(A[start] == target){
            range[0] = start;
        }else if(A[end] == target){
            range[0] = end;
        }else{
            return range;//û�ҵ������ü����ˣ�ֱ�ӷ���
        }
        //hereby: start must be less than end
        end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] <= target){//���������ҵ����һ��
                start = mid;
            }else{
                end = mid - 1;
            }
        }
        if(A[end] == target){
            range[1] = end;
        }else if(A[start] == target){
            range[1] = start;
        }
        return range;
    }     

    
}
