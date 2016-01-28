package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 �� Li, Ri �� INT_MAX, 0 < Hi �� INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
Credits:
Special thanks to @stellari for adding this problem, creating these two awesome images and all test cases.

Subscribe to see which companies asked this question

Hide Tags Divide and Conquer Heap


 *
 */
public class The_Skyline_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = new int[][]{
			{2, 9, 10},
			{3, 7, 15},
			{5, 12, 12},
			{15, 20, 10},
			{19, 24, 8}
		};
//		System.out.println(""+getSkyline(buildings));
		List<int[]> list =  getSkyline(buildings);
		for(int[] arr : list){
			System.out.print(" ["+arr[0]+","+arr[1]+"]");
		}
//		 [2,10] [3,15] [7,12] [12,0] [15,10] [20,8] [24,0]
	}

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        // �����Σ�����������б�
        for(int[] b:buildings) {
            // �󶥵��Ϊ����
            height.add(new int[]{b[0], -b[2]});
            // �Ҷ����Ϊ����
            height.add(new int[]{b[1], b[2]});
        }
        // ���ݺ�������б�������ͬ������ĵ�������С������ǰ��
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        // �����ѣ��������������жϴ�С
        Queue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        // ����ƽ��ֵ9�ȼ������
         pq.offer(0);//���ӵĻ���peek()�ͻ���NullPointerException
        // prev���ڼ�¼�ϴ�keypoint�ĸ߶�
        int prev = 0;
        for(int[] h:height) {
            // ���󶥵�������
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
            // ���Ҷ����Ӧ���󶥵���ȥ
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            // ����ѵ��¶������ϸ�keypoint�߶Ȳ�һ���������һ���µ�keypoint
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
 
    
}
