package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
Building Outline Show result 

Given N buildings in a x-axis£¬each building is a rectangle and can be represented by a triple (start, end, height)£¬where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. Buildings may overlap if you see them from far away£¬find the outline of them¡£

An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.

Building Outline

Have you met this question in a real interview? Yes
Example
Given 3 buildings£º

[
  [1, 3, 3],
  [2, 4, 4],
  [5, 6, 1]
]
The outlines are£º

[
  [1, 2, 3],
  [2, 4, 4],
  [5, 6, 1]
]
Note
Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.

Tags Expand 
LintCode Copyright Heap Google


 *
 */
public class Building_Outline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[][] buildings = new int[][]{
			{2, 9, 10},
			{3, 7, 15},
			{5, 12, 12},
			{15, 20, 10},
			{19, 24, 8}
		};
		int[][] buildings2 = new int[][]{
			{1,3,3},
			{2,4,4},
			{5,6,1}
		};

//		[[1,3,3],[2,4,4],[5,6,1]]
//		System.out.println(""+getSkyline(buildings));
//		ArrayList<ArrayList<Integer>> list =  buildingOutline(buildings);
		ArrayList<ArrayList<Integer>> list =  buildingOutline(buildings2);
		for(ArrayList<Integer> arr : list){
			System.out.print(" ["+arr.get(0)+","+arr.get(1)+","+arr.get(2)+"]");
		}
//		 [2,10] [3,15] [7,12] [12,0] [15,10] [20,8] [24,0]
//		 [2,3,10] [5,7,15] [9,12,12] [19,20,10] [20,24,8]
	}

    public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(buildings == null || buildings.length == 0) return result;
        List<int[]> heights = new ArrayList<int[]>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        pq.offer(0);
        int prev = pq.peek();
        
        int start = 0;
        int end = 0;
        int height = prev;
        for(int[] h : heights){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != 0){
            	if(prev != curr){
            		ArrayList<Integer> newList = new ArrayList<Integer>();
            		end = h[0];
            		newList.add(start);newList.add(end);newList.add(height);
            		result.add(newList);
            		start = h[0];
            	}
            }else{
            	start = h[0];
            }
            prev = curr;
            height = curr;
        }
        return result;
        
        // ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
        // int start = 0;
        // int end = 0;
        // int height = 0;
        // for(int i = 1; i < result.size(); i++){
        //     height   = result.get(i-1).get(1);
        //     if(height > 0){
        //         start = result.get(i-1).get(0);
        //         end   = result.get(i).get(0);
        //         height   = result.get(i-1).get(1);
        //         ArrayList<Integer> newList = new ArrayList<Integer>();
        //         newList.add(start);newList.add(end);newList.add(height);
        //         result2.add(newList);
        //     }
        // }
        // return result;
    }

	
	
    public static ArrayList<ArrayList<Integer>> buildingOutline2(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(buildings == null || buildings.length == 0) return result;
        List<int[]> heights = new ArrayList<int[]>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
//        System.out.println(""+heights);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        pq.offer(0);
        int prev = pq.peek();
        for(int[] h : heights){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != curr){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(h[0]);newList.add(curr);
                result.add(newList);
                prev = curr;
            }
        }
        return result;
    }
    
	
}
