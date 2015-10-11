package JavaInterviewQueston;

//一个矩阵其所有行由以1开头和0结尾的序列组成
//求每行包含的1的个数
public class Find_Longest_Ones_In_Matrix {

	
	public static int find_Longest_Ones_In_Matrix(int[][] matrix){
		if(matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int i = 0, j = 0;//i from 0 to n-1, j from 0 to m -1
//		【考察点】i，j范围不一样，避免ArrayIndexOutOfBoundsException
//		【考察点】返回的是1的个数，所以是i+1
		while( i < n -1 && j < m ){
			if(matrix[j][i+1] == 1){
				i++;
			}else{
				j++;
			}
		}
		return i + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = { {0,0,0,0,0},{0,0,0,0,0 },{ 1,1,1,1,1 } };
		int[][] matrix = { {1} };
//		int[][] matrix = { {1} };
//		int[][] matrix = { {0,0},{1,1} };
		
		System.out.println(find_Longest_Ones_In_Matrix(matrix));
	}

}
