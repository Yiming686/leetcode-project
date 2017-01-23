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
    
    //count��������������ٴ���Ч�����ˣ���Ч����ʱ��ͳ�����ڵ�
    public static void search3(ArrayList<String> result, ArrayList<String> dict, char[][] board, int x, int y, String word, List<Integer> count){
    	//��һ����corner cases
		if(board == null)  return;
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]=='#')
			return ;
		//�ڶ����������word�����ֵ�ͼ��룬�����ӵ�
		word += board[x][y];//count���ڴ˾���棬�ͱ�������Ч����
		count.set(0, count.get(0)+1);
		if(word.length() == board.length * board[0].length)
		System.out.println(""+word +"  "+word.length() + "  " + count.get(0));
		
		if(dict.contains(word) && !result.contains(word)){
			result.add(word);
		}
		//������������Ѿ��������˵㣬ά���Ƿ�������ı��
		char ch = board[x][y];
		board[x][y] = '#';//����Ѿ�visited
		//���Ĳ�����ʼ�ĸ���������
		search3(result, dict, board, x+1,   y, word, count);
		search3(result, dict, board, x,   y+1, word, count);
		search3(result, dict, board, x-1,   y, word, count);
		search3(result, dict, board, x,   y-1, word, count);
		//���Ĳ���������ϣ���Ǹ�ԭ

		board[x][y] = ch;//�����ӽڵ㣬������ϣ����û��visited
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
