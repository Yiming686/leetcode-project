package Lintcode.Matrix;

public class Minimum_Path_Sum {

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
		System.out.println("minPathSum: "+minPathSum(matrix));
	}

    public static int minPathSum(int[][] grid) {
        // write your code here
        if(grid == null) return 0;;
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows ==0 || cols==0) return 0;
        
        int[][] min = new int[rows][cols];
        //初始条件
        min[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++){
            int j = 0;
            min[i][j] = min[i-1][j] + grid[i][j];
        }
        for(int j = 1; j < cols; j++){
            int i = 0;
            min[i][j] = min[i][j-1] + grid[i][j];
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                //状态方程
                min[i][j] = Math.min(min[i-1][j], min[i][j-1])+grid[i][j];
            }
        }
        //运行结束，最终结果
        return min[rows-1][cols-1];
    }

}
