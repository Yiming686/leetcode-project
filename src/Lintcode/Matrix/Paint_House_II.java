package Lintcode.Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.StyleConstants.CharacterConstants;

/**

Paint House II

 Description
 Notes
 Testcase
 Judge
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Notice

All costs are positive integers.

Have you met this question in a real interview? Yes
Example
Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10

Challenge 
Tags 
Related Problems 
Medium Paint House 36 %
Easy Paint Fence 29 %
Hard Sliding Window Median 19 %
Super Sliding Window Maximum 27 %
Easy Product of Array Exclude Itself 26 %


 *
 */
public class Paint_House_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = new int[][]{
			{3,2,1,0,6},
			{0,3,2,2,5},
			{4,2,2,6,3},
			{7,6,6,7,9},
			{8,7,2,7,8},
			};
		costs = new int[][]{
				{14,2,11},
				{11,14,5},
				{14,3,10}
				};			
		System.out.println(""+minCostII(costs));
	}

	// Worked, Best of Best, works for Paint House and Paint House II
    public static int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int prevMin = 0, prevSecMin = 0, prevIndexOfMin = -1;
        for(int i = 0; i < costs.length; i++){
            int currMin = Integer.MAX_VALUE, currSecMin = Integer.MAX_VALUE, currIndexOfMin = -1;
            for(int j = 0; j < costs[0].length; j++){
                costs[i][j] += (j == prevIndexOfMin) ? prevSecMin : prevMin;
                // 找出最小和次小的，最小的要记录下标，方便下一轮判断
                if(costs[i][j] < currMin){
                    currSecMin = currMin;
                    currMin = costs[i][j];
                    currIndexOfMin = j;
                } else if (costs[i][j] < currSecMin){
                    currSecMin = costs[i][j];
                }
            }
            prevMin = currMin;
            prevSecMin = currSecMin;
            prevIndexOfMin = currIndexOfMin;
        }
        return prevMin;
    }

    public static int minCostII12(int[][] costs) {
        // Write your code here
        if(costs == null || costs.length == 0 ) return 0;
        int globalMin = Integer.MAX_VALUE;
        // int localMin = 0;
        int rows = costs.length;         
        int cols = costs[0].length;
        // Queue<Node> queue = new PriorityQueue<>(1, (Node node1, Node node2) -> node1.val - node2.val);
        Queue<Node> queue = new PriorityQueue<>(1, new Comparator<Node>(){
            public int compare(Node node1, Node node2){
                return node1.val - node2.val;
            }    
        });
        for(int i = 1; i < rows; i++){
            queue.clear();
            for(int m = 0; m < cols; m++){
                queue.offer(new Node(m, costs[i-1][m]));    
            }
            for(int j = 0; j < cols; j++){
                if(queue.peek().j != j){
                    costs[i][j] += queue.peek().val; 
                }else{
                    Node node = queue.poll();
                    costs[i][j] += queue.peek().val; 
                    queue.offer(node);
                }
            }
            System.out.println(""+Matrix.fromMatrixToString(costs));
        }
         queue.clear();
         for(int m = 0; m < cols; m++){
             queue.offer(new Node(m, costs[rows-1][m]));    
         }        
        return queue.peek().val;
    }
    
    static class Node{
        int j;
        int val;
        Node(int j, int val){
            this.j = j;
            this.val = val;
        }
        
    }
	
}
