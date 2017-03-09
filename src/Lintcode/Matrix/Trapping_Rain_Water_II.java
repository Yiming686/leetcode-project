package Lintcode.Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Trapping Rain Water II

 Description
 Notes
 Testcase
 Judge
Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, compute how much water it is able to trap after raining.



Have you met this question in a real interview? Yes
Example
Given 5*4 matrix

[12,13,0,12]
[13,4,13,12]
[13,8,10,12]
[12,13,12,12]
[13,13,13,13]
return 14.

Tags 
LintCode Copyright Heap Matrix
Related Problems 
Medium Trapping Rain Water 3


 *
 *
 */
public class Trapping_Rain_Water_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix2 = new int[][]{
			{1,8,2},
			{6,7,5},
			{3,5,2},
			};

		int[][] matrix = new int[][]{
				{3,2,1,0,6},
				{0,3,2,2,5},
				{4,2,2,6,3},
				{7,6,6,7,9},
				{8,7,2,7,8},
				};
		matrix = new int[][]{
			{12,13,0,12},
			{13,4,13,12},
			{13,8,10,12},
			{12,13,12,12},
			{13,13,13,13},
			};
		System.out.println("Trapping_Rain_Water_II: "+trapRainWater(matrix));

	}

	
	
    public static int trapRainWater(int[][] heights) {
        // write your code here
        if(heights == null || heights.length == 0){
            return 0;
        } 
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] dx = {1, 0, -1,  0};
        int[] dy = {0, 1,  0, -1};
//        最小堆，默认的
         PriorityQueue<Cell> queue = new PriorityQueue<>((Cell cell1, Cell cell12) -> cell1.height - cell12.height);
//        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(1, new Comparator<Cell>(){
//            @Override
//           public int compare(Cell bar1, Cell bar2){
//               return bar1.height - bar2.height;
//           } 
//        });
        visited[0][0] = true;      visited[0][cols-1] = true;
        visited[rows-1][0] = true; visited[rows-1][cols-1] = true;
        for(int i = 1; i < rows - 1; i++){
            queue.offer(new Cell(i, 0, heights[i][0]));
            visited[i][0] = true;
            queue.offer(new Cell(i, cols - 1, heights[i][cols - 1]));
            visited[i][cols-1] = true;
        }
        for(int j = 1; j < cols - 1; j++){
            queue.offer(new Cell(0, j, heights[0][j]));
            visited[0][j] = true;
            queue.offer(new Cell(rows - 1, j, heights[rows - 1][j]));
            visited[rows-1][j] = true;
        }
        int count = 0;
        while(!queue.isEmpty()){
            Cell bar = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = bar.x + dx[i];
                int newY = bar.y + dy[i];
            	System.out.println("bar.height::heights[bar.x][bar.y]   "+bar.height+", "+heights[bar.x][bar.y]);

                if(newX >= 0 && newX < rows && newY>=0 && newY<cols && !visited[newX][newY]){
//                	System.out.println(""+heights[bar.x][bar.y]);
//                    if(heights[newX][newY] < heights[bar.x][bar.y]){
//                        count += heights[bar.x][bar.y] - heights[newX][newY];
//                        visited[newX][newY] = true;
//                        queue.offer(new Bar(newX, newY, heights[bar.x][bar.y]));
//                    }else{
//                        visited[newX][newY] = true;
//                        queue.offer(new Bar(newX, newY, heights[newX][newY]));
//                    }
//                	System.out.println("check:"+(heights[bar.x][bar.y] == bar.height));
//                	System.out.println("bar.height::heights[bar.x][bar.y]   "+bar.height+", "+heights[bar.x][bar.y]);
                    if(heights[newX][newY] < bar.height){
                        count += bar.height - heights[newX][newY];
                        visited[newX][newY] = true;
                        queue.offer(new Cell(newX, newY, bar.height));
                    }else{
                        visited[newX][newY] = true;
                        queue.offer(new Cell(newX, newY, heights[newX][newY]));
                    }
                }
            }
        }
        return count;
    }

   static class Cell{
        int x, y;
        int height;
        Cell(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    
}



