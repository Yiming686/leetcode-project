package Lintcode.Matrix;

/**
Word Search Show result 

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Have you met this question in a real interview? Yes
Example
Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Tags Expand 
Backtracking Facebook

 *
 */
public class Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word == null || word.length() == 0)
            return false;
        
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                // if(board[i][j] == word.charAt(0)){
                    //含义就是check所有以i,j为起点的字符串
                    //2 lines bolow worked
//                    boolean isFound = find(board, i, j, word, 0, isVisited);
                     boolean isFound = find(board, i, j, word, 0);
                    if(isFound == true)
                        return true;
                // }
            }
        }
        return false;
    }
    
    //对start的理解和运用是难点也是精彩之处
    //从ij开始找word，非也，
    //在矩阵board中，从ij开始找从start开始的word中的字符串
    //board中ij是动态变化的，word中start是动态变化的
    //所以看到(i-1, j,start+1), (i, j-1,start+1), (i+1, j,start+1), (i, j+1,start+1)
    //一个方法的调用将整个矩阵面全部遍历一遍，矩阵有多少元素，就得遍历多少遍才可以
    private static boolean find(char[][] board, int i, int j, String word, int start){
        //遍历规则：下面三行给所有递归点制定了规则三条，也是三条basecases
        if(start == word.length()) return true;
        if (i < 0 || i>= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(start)) return false;
        char ch = board[i][j];
        board[i][j] = '#'; // should remember to mark it
        boolean rst = find(board, i-1, j,   word, start+1) || 
                      find(board, i,   j-1, word, start+1) || 
                      find(board, i+1, j,   word, start+1) || 
                      find(board, i,   j+1, word, start+1);
        board[i][j] = ch;
        return rst;
    }
    
    //对start的理解和运用是难点也是精彩之处
    //从ij开始找word，非也，
    //在矩阵board中，从ij开始找从start开始的word中的字符串
    //board中ij是动态变化的，word中start是动态变化的
    //所以看到(i-1, j,start+1), (i, j-1,start+1), (i+1, j,start+1), (i, j+1,start+1)
    //一个方法的调用将整个矩阵面全部遍历一遍，矩阵有多少元素，就得遍历多少遍才可以
    private static boolean find(char[][] board, int i, int j, String word, int start, boolean[][] isVisited){
        //遍历规则：下面三行给所有递归点制定了规则三条，也是三条basecases
        if(start == word.length()) return true;
        if (i < 0 || i>= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(start)) return false;
        if(isVisited[i][j] == true) return false;
        
        isVisited[i][j] = true;
        boolean isFound =   find(board, i-1, j,   word, start+1, isVisited) || 
                            find(board, i,   j-1, word, start+1, isVisited) || 
                            find(board, i+1, j,   word, start+1, isVisited) || 
                            find(board, i,   j+1, word, start+1, isVisited);
        isVisited[i][j] = false;
        return isFound;
    }

}
