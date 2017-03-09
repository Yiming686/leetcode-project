package Lintcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Lintcode.Array.Matrix;

/**
207. Course Schedule 

Total Accepted: 67912
Total Submissions: 222004
Difficulty: Medium
Contributors: Admin
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Subscribe to see which companies asked this question

Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
Hide Similar Problems (M) Course Schedule II (M) Graph Valid Tree (M) Minimum Height Trees


 *
 *
 */

public class Course_Schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numCourses = 10;
		int[][] prerequisites = new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
//		"[[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]";
		System.out.println(""+canFinish(numCourses, prerequisites ));
	}

	//��ȫ�����ˣ���û��prerequisites�Ŀγ̿�ʼBFS�������ܷŽ�queue�Ķ��ǿ�ѡ�Ŀ�
	// ���Ƚ�pop�����ĸ����Ƿ�����ܹ��γ̸���
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[][] matrix = new int[numCourses][numCourses]; // i -> j
	        int[] indegree = new int[numCourses];
	        
	        for (int i=0; i<prerequisites.length; i++) {
	            int ready = prerequisites[i][0];
	            int pre = prerequisites[i][1];
	             if (matrix[pre][ready] == 0){
	                indegree[ready]++; //duplicate case
	             }
	            matrix[pre][ready] = 1;
	        }
	        System.out.println(""+Matrix.fromMatrixToString(matrix));
	        System.out.println("                         "+Arrays.toString(indegree));
	        
	        int count = 0;
	        Queue<Integer> queue = new LinkedList();
	        // ��ѡû��prerequisites�ĿΣ�����ѡ�Σ�����ͳ��
	        for (int i=0; i<indegree.length; i++) {
	            if (indegree[i] == 0) queue.offer(i);
	        }
	        while (!queue.isEmpty()) {
	            int course = queue.poll();
	            count++;//��pop�����Ķ��ǿ���ѡ��Ŀ�
	            for (int i=0; i<numCourses; i++) {
	                if (matrix[course][i] != 0) {//����й���
	                    if (--indegree[i] == 0){//��������һ��degree����ʾ���е�prerequisites���Ѿ�ͳ�Ƶ��ˣ����Կ�����ѡ��
	                        queue.offer(i);
	                    }
	                }
	            }
	        }
	        return count == numCourses;
	    }
}
