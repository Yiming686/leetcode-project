package Company.Facebook;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**

Amazing Number

Define amazing number as: its value is less than or equal to its index. Given a circular array, find the starting position, such that the total number of amazing numbers in the array is maximized./ ]. q% {$ a1 X6 h
Example 1: 0, 1, 2, 3
Ouptut: 0. When starting point at position 0, all the elements in the array are equal to its index. So all the numbers are amazing number.

Example 2: 1, 0 , 0
Output: 1. When starting point at position 1, the array becomes 0, 0, 1. All the elements are amazing number.! W, f3 d8 w6 {6 {% ?/ q
If there are multiple positions, return the smallest one.
9 v- ?$ G9 V8 K
should get a solution with time complexity less than O(N^2)0


 *
 */
public class Amazing_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 6, 8, 0, 3, 2, 3};
        //         6  7  0  1  2  3  4  5 = 6
        //         7  0  1  2  3  4  5  6 = 5
        //         4  5  6  7  0  1  2  3 = 6
		
		arr = new int[]{3, 4, 1, 5, 2};
		System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));
//		System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+bruteForce2(arr));
        arr = new int[]{0, 1, 2, 3};
//        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+bruteForce2(arr));
        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));
        arr = new int[]{1, 0, 0};
//        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+bruteForce2(arr));
        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));
        arr = new int[]{4, 2, 8, 2, 4, 5, 3};
//        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+bruteForce2(arr));
        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));
        arr = new int[]{4444, 2333, 8444, 2444, 443333, 5434, 33211};
//        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+bruteForce2(arr));
        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));

        arr = new int[]{1, 2, 3, 4, 5, 1, 2, 9, 10, 11, 1, 2, 3, 4, 5, 6};
        System.out.println("===========================================> expected::actual " + bruteForce(arr) +", "+amazingNumber(arr));

	}
    private static int bruteForce(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                int p = j + i;
//                从0到len-1个遍历，累加所有的amazing numbers的个数
                if (j - arr[p % arr.length] >= 0) {
                	count++;
//                	System.out.println(MessageFormat.format("i,j,p,arr[],count,max,res:: {0},{1},{2},[{3}],{4},{5},{6}", i,j,p,arr[p % arr.length],count,max,res));
                }else{
//                	count = 0;
                }
            }
//            return the smallest one, so >, if return the largest one, so >=
            if (count > max) {
//            	System.out.println("max found! i, count :: " +i+", "+count);
                max = count;
                res = i;
            }
        }
//        System.out.println("", );
        return res;
    }

//    brute force, by myself
    private static int bruteForce2(int[] arr) {
    	int index = 0;	
    	int max = 0;
    	int len = arr.length;
    	for(int i = 0; i < len; i++){
    		int count = 0;
    		for(int j = 0; j < len; j++){
    			int p = i + j;
    			if(j - arr[p%len] >= 0){
    				count++;
    			}
    		}
    		if(count > max){
    			max = count;
    			index = i;
    		}
    	}
    	return index;
    }
//    不能排序，乱序结果不对，
//    private static int bruteForce2(int[] arr) {
//    }
    public static int amazingNumber_Orig(int[] a) {
        int len = a.length;
        LinkedList<Interval> intervals = new LinkedList<>();

        // find all the intervals that if the array starts at any index in the interval, there will
        // be at least 1 element is amazing number
//        start:从下一个元素开始就算index，当前位置是肯定的算一个，所以后面就可以++
//        end:
        for (int i = 0; i < len; i++) {
            if (a[i] >= len) continue;
            int start = (i+1) % len;//怎么确定start和end？什么含义？
            int end = (len + (i - a[i])) % len;
//            System.out.println(i + ": " + start + " - " + end);
            intervals.add(new Interval(start, end));
        }

        // now our problem has just become: "find the year that has the maximum number of people
        // alive"
//        Wrong：count[]表示以i开始向后len个元素的满足条件的元素个数
//      count[]表示以i开始向后len个元素的满足条件的元素个数
        int[] count = new int[len];
        for (Interval i : intervals) {
//        	System.out.println("start:end  "+i.start +", "+i.end);
            count[i.start]++;
            if (i.end+1 < count.length){
            	count[i.end+1]--;
            } 
//            System.out.println(""+Arrays.toString(count));
        }
        int max = 0;
        int counter = 0;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            counter += count[i];
            if (counter > max) { 
                max = counter;
                idx = i;
            }
        } 
//        System.out.println("idx:counter:max: "+idx+", "+counter+", "+max);
        return idx;
    }

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static int amazingNumber(int[] arr) {
    	int len = arr.length;
    	List<Interval> list = new ArrayList<>();
    	for(int i = 0; i< len; i++){
    		if(arr[i] >= len) continue;
    		int start = (i + 1) % len;
    		int end = (len + i - arr[i])%len;
    		list.add(new Interval(start, end));
    	}
    	int[] count = new int[len];
    	for(Interval itv : list){
    		count[itv.start]++;
    		if(itv.end + 1 < len){
    			count[itv.end + 1]--;
    		}
    	}
    	int index = 0;
    	int max = 0;
    	int counter = 0;
    	for(int i = 0; i<len; i++){
    		counter += count[i];
    		if(counter > max){
    			max = counter;
    			index = i;
    		}
    	}
    	return index;
    }
    
    
}
