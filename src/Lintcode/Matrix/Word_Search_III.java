package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.jmx.mbeanserver.DefaultMXBeanMappingFactory;

/**
Word Search II Show result 

Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 


Have you met this question in a real interview? Yes
Example
Given matrix:
doaf
agai
dcan
and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


dog:
doaf
agai
dcan
dad:
doaf
agai
dcan
can:
doaf
agai
dcan
again:
doaf
agai
dcan
Challenge
Using trie to implement your algorithm.

Tags Expand 
LintCode Copyright Airbnb Trie *
 */
public class Word_Search_III {
	static List<String> chList = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][];;
		board[0] = "ALIH".toCharArray();
		board[1] = "BKJG".toCharArray();
		board[2] = "CDEF".toCharArray();

//		board[0] = "alih".toCharArray();
//		board[1] = "bkjg".toCharArray();
//		board[2] = "cdef".toCharArray();
//		board[0] = "zoaf".toCharArray();
//		board[1] = "agai".toCharArray();
//		board[2] = "dcan".toCharArray();

//		board[0] = "1a98".toCharArray();
//		board[1] = "2bc7".toCharArray();
//		board[2] = "3456".toCharArray();

		ArrayList<String> words = new ArrayList<String>();
		String[] arr = {"dog", "dad", "dgdg", "can", "again","z","zagc"};
		words.addAll(Arrays.asList(arr));
		System.out.println(""+Matrix.fromMatrixToString(board));
		System.out.println(""+wordSearchIII(board, words));
//		System.out.println(""+Matrix.fromMatrixToString(board));
//		System.out.println(""+chList);
	}
	
    public static ArrayList<String> wordSearchIII(char[][] board, ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<String>();
        //special cases
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) return result;
		//build trie tree
//        TrieNode root = buildTrieTree(words);
        //search Trie Tree for each string starting with each character
        List<Integer> count = new ArrayList<Integer>();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				count.clear(); 
				count.add(0);
				search3(result, words, board, i, j, "" , count);
//				System.out.println(board[i][j]+"  "+count.get(0));
				break;
			}
			break;
		}
		return result;
    }
    
    //count是这个方法被多少次有效调用了？无效调用时不统计在内的
    public static void search3(ArrayList<String> result, ArrayList<String> dict, char[][] board, int x, int y, String word, List<Integer> count){
    	//第一步：corner cases
		if(board == null)  return;
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]=='#')
			return ;
		//第二步：组成新word，在字典就加入，否则扔掉
		word += board[x][y];//count放在此句后面，就表明是有效调用
		count.set(0, count.get(0)+1);
		if(word.length() == board.length * board[0].length)
		System.out.println(""+word +"  "+word.length() + "  " + count.get(0));
		
		if(dict.contains(word) && !result.contains(word)){
			result.add(word);
		}
		//第三步：标记已经搜索过此点，维护是否遍历过的标记
		char ch = board[x][y];
		board[x][y] = '#';//标记已经visited
		//第四步：开始四个方向搜索
		search3(result, dict, board, x+1,   y, word, count);
		search3(result, dict, board, x,   y+1, word, count);
		search3(result, dict, board, x-1,   y, word, count);
		search3(result, dict, board, x,   y-1, word, count);
		//第四步：搜索完毕，标记复原

		board[x][y] = ch;//四周子节点，遍历完毕，标记没有visited
//		System.out.println(""+Matrix.fromMatrixToString(board));
	}

//============================================================================================
    
    public static ArrayList<String> wordSearchIII2(char[][] board, ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<String>();
        //special cases
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) return result;
		//build trie tree
//        TrieNode root = buildTrieTree(words);
        //search Trie Tree for each string starting with each character
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				List<Character> word = new ArrayList<Character>();;
				word.add(board[i][j]);
				search32(result, words, board, i, j, word );
//				break;
			}
//			break;
		}
		return result;
    }
    
    public static void search32(ArrayList<String> result, ArrayList<String> words, char[][] board, int x, int y, List<Character> list){
		if(board == null)  return;
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]=='#')
			return ;
		
		String word = "";
		for(char ch : list){
			word += ch;
		}
		System.out.println(""+word);
		if(words.contains(word) && !result.contains(word)){
			result.add(word);
		}
		char ch = board[x][y];
		board[x][y] = '#';
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		for(int i = 0; i < 4; i++){
			int xx = x+ dx[i];
			int yy = y+ dy[i];
			if(xx>=0 && xx < board.length && yy>=0 && yy < board[0].length){
				list.add(board[xx][yy]);
				search32(result, words, board, xx, yy, list);
				list.remove(list.size()-1);
			}
		}
		board[x][y] = ch;
	}


    
    
	
}
