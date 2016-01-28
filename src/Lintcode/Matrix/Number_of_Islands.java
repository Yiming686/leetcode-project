package Lintcode.Matrix;

import java.util.Arrays;

/**
Number of Islands

Given a boolean 2D matrix, find the number of islands.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Note
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Tags Expand 
Facebook Zenefits Google


Related Problems Expand 
Medium Surrounded Regions

 *
 *
 */
public class Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 1, 1, 1, 0}, {1, 1, 0, 0, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 0, 0},{1, 1, 0, 0, 1} };
		boolean[][] matrix2 = null;
//		boolean[][] matrix = {
//				{true, true, false, false, false}, 
//				{false, false, false, false, false}, 
//				{false, false, false, false, false}, 
//				{false, false, false, false, false},
//				{false, false, false, false, false} };
		System.out.println("before:\n"+Matrix.fromMatrixToString(matrix));
		int num = numIslands(matrix2);
		System.out.println(""+num);
		System.out.println("after:\n"+Matrix.fromMatrixToString(matrix));
		System.out.println(""+num);
	}
	
    public static int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        int count = 0;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == true){
                    count++;
                    removeIsLands(grid, i, j);
                    // grid[i][j] = true;
                }
            }
        }
        return count;        
    }
    
    private static void removeIsLands(boolean[][] grid, int i, int j){
        // if(grid == null)  return;
        //���������������и����еݹ���ƶ��˹���������Ҳ������basecases
        if (i < 0 || i>= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == false) return; 
        if(grid[i][j] == true)  grid[i][j] = false; 
        
        removeIsLands(grid, i+1, j  );
        removeIsLands(grid, i,   j+1);
        removeIsLands(grid, i-1, j  );
        removeIsLands(grid, i,   j-1);
    }
    
	//====================================================================================
	//previous version
	//====================================================================================
    
    public static int numIslands44(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        int[] di = {0, -1, 0, 1};
        int[] dj = {1, 0, -1, 0};
        
        int count = 0;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1){
                    count++;
                    removeIsland44(grid, i, j, di, dj);
//                    grid[i][j] = 1;
                }
            }
        }
        return count;        
    }
    //ȥ�Ѻ�ij��ͨ�ĵط�ȫ������Ϊ0
    private static void removeIsland44(int[][] grid, int i, int j, int[] di, int[] dj){
    	//�ȴ����Լ���Ȼ���ܱ��������ϼ�������
        grid[i][j] = 0;
        for(int index = 0; index < di.length; index++){
            int ii = i + di[index];
            int jj = j + dj[index];
            if(ii >= 0 && ii < grid.length && jj >=0 && jj < grid[0].length && grid[ii][jj] == 1) {
            	System.out.println("i:j "+i+":" +j+" \n");
            	System.out.println("be:ii:jj "+ii+":" +jj+" \n"+ Matrix.fromMatrixToString(grid));
//                grid[ii][jj] = 0;
                if(i == 4 && j == 4) System.out.println("======");
                removeIsland44(grid, ii, jj, di, dj);
//                System.out.println("af:ii:jj "+ii+":" +jj+" \n"+ Matrix.fromMatrixToString(grid));
            }
        }
//        grid[i][j] = 1;
        
    }

}