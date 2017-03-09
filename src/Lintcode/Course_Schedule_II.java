package Lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**

Course Schedule II

 Description
 Notes
 Testcase
 Judge
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Have you met this question in a real interview? Yes
Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]

Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]

Tags 
Amazon Breadth First Search Facebook Zenefits Topological Sort
Related Problems 
Medium Topological Sorting 29 %


 *
 */
public class Course_Schedule_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 6;
		int[][] prerequisites = {};
		
		System.out.println(""+Arrays.toString(findOrder(numCourses, prerequisites)));
	}

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        if(numCourses == 0 || prerequisites == null ){
            return result;
        }
        List<Integer>[] edges = new ArrayList[numCourses];//课程集合：是哪些课程的先修课程
        int[] degree = new int[numCourses];//个数：有多少个先修课程
        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if (degree[i] == 0) {//先修课程为0，图中的root节点，bfs第一层节点
                queue.add(i);
            }
        }
        int count = 0;//index
        // int[] order = new int[numCourses];//最终输出
        while(!queue.isEmpty()){
            int course = queue.poll();//加入序列的course
            result[count++] = course;//加入序列
            int size = edges[course].size();
            for(int i = 0; i < size; i++){
                int next = edges[course].get(i);
                degree[next]--;
                if(degree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        System.out.println(""+count);
        return result;

    }
}
