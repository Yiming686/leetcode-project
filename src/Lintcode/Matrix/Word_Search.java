package Lintcode.Matrix;

import Lintcode.String.Valid_Number;

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
		char[][] board = new char[3][];;
//		board[0] = "zoaf".toCharArray();
//		board[1] = "agai".toCharArray();
//		board[2] = "dcan".toCharArray();
		board[0] = "1a98".toCharArray();
		board[1] = "2bc7".toCharArray();
		board[2] = "3456".toCharArray();
		System.out.println(""+Matrix.fromMatrixToString(board));
		System.out.println(""+exist2(board, "c789ab"));
	

	}
    public static boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word == null || word.length() == 0)
            return false;
        
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        boolean hasWord = false;
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
            	if(hasWord(board, word, 0, i , j)){
            		return true;
            	}
            }
        }
        return hasWord;
    }
    private static boolean hasWord(char[][] board, String word, int pos, int i, int j) {
		// TODO Auto-generated method stub
    	if(pos == word.length()) return true;
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
		System.out.println("i:j "+i+", "+j+",    "+word.substring(0,pos+1));
		if(board[i][j] != word.charAt(pos)) return false;
		char ch = board[i][j];
		board[i][j] = '#';
    	boolean hasWord = hasWord(board, word, pos + 1, i + 1, j    ) ||//����
    					  hasWord(board, word, pos + 1, i,     j + 1) ||//����
    					  hasWord(board, word, pos + 1, i - 1, j    ) ||//����
    					  hasWord(board, word, pos + 1, i,     j - 1);  //����
    	board[i][j] = ch; 
    	return hasWord;
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
                    //�������check������i,jΪ�����ַ���
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
    
    //��start�������������ѵ�Ҳ�Ǿ���֮��
    //��ij��ʼ��word����Ҳ��
    //�ھ���board�У���ij��ʼ�Ҵ�start��ʼ��word�е��ַ���
    //board��ij�Ƕ�̬�仯�ģ�word��start�Ƕ�̬�仯��
    //���Կ���(i-1, j,start+1), (i, j-1,start+1), (i+1, j,start+1), (i, j+1,start+1)
    //һ�������ĵ��ý�����������ȫ������һ�飬�����ж���Ԫ�أ��͵ñ������ٱ�ſ���
    private static boolean find(char[][] board, int i, int j, String word, int start){
        //���������������и����еݹ���ƶ��˹���������Ҳ������basecases
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
    
    //��start�������������ѵ�Ҳ�Ǿ���֮��
    //��ij��ʼ��word����Ҳ��
    //�ھ���board�У���ij��ʼ�Ҵ�start��ʼ��word�е��ַ���
    //board��ij�Ƕ�̬�仯�ģ�word��start�Ƕ�̬�仯��
    //���Կ���(i-1, j,start+1), (i, j-1,start+1), (i+1, j,start+1), (i, j+1,start+1)
    //һ�������ĵ��ý�����������ȫ������һ�飬�����ж���Ԫ�أ��͵ñ������ٱ�ſ���
    private static boolean find(char[][] board, int i, int j, String word, int start, boolean[][] isVisited){
        //���������������и����еݹ���ƶ��˹���������Ҳ������basecases
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
