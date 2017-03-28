package Lintcode.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
Word Search II Show result 

Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary 
that can be found in the matrix. A word can start from any position in the matrix 
and go left/right/up/down to the adjacent position. 


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
public class Word_Search_II {
	static List<String> chList = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][];;
//		board[0] = "zoaf".toCharArray();
//		board[1] = "agai".toCharArray();
//		board[2] = "dcan".toCharArray();
		board[0] = "1a98".toCharArray();
		board[1] = "2bc7".toCharArray();
		board[2] = "3456".toCharArray();

		ArrayList<String> words = new ArrayList<String>();
		String[] arr = {"dog", "dad", "dgdg", "can", "again","z"};
		words.addAll(Arrays.asList(arr));
		System.out.println(""+Matrix.fromMatrixToString(board));
		System.out.println(""+wordSearchII(board, words));
		System.out.println(""+Matrix.fromMatrixToString(board));
		System.out.println(""+chList);
	}
	
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<String>();
        //special cases
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) return result;
		//build trie tree
        TrieNode root = buildTrieTree(words);
        //search Trie Tree for each string starting with each character
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				search2(board, i, j, root, result);
			}
		}
		return result;
    }
    
    public static void search2(char[][] board, int x, int y, TrieNode root, ArrayList<String> result){
		if(board == null || root == null)  return;
		if(root.hasWord == true)
		{
			if(!result.contains(root.word)){
				result.add(root.word);
			}
		}
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]=='#')
			return ;
		char ch = board[x][y];
		board[x][y] = '#';
		
		search2(board, x+1, y,   root.map.get(ch), result);
		search2(board, x,   y+1, root.map.get(ch), result);
		search2(board, x-1, y,   root.map.get(ch), result);
		search2(board, x,   y-1, root.map.get(ch), result);
		
		board[x][y] = ch;
	}
    static class TrieNode {
		String word;
		 boolean hasWord;
		 HashMap<Character, TrieNode> map;
		 public TrieNode() {
			 hasWord = false;
			 map = new HashMap<Character, TrieNode>();
			 word = "";
		 }
	};

    public static TrieNode buildTrieTree(ArrayList<String> words){
        TrieNode root = new TrieNode();
		for(String word : words){
		    //reset now, 每次都从root开始
			TrieNode now = root;
			for (int i = 0; i < word.length(); i++) {
				if (!now.map.containsKey(word.charAt(i))) {
				    //核心操作，此for loop就是想干这个事
					now.map.put(word.charAt(i), new TrieNode());
				}
				now  =  now.map.get(word.charAt(i));
			}
			//每个字符插入完毕，之后的Node，插入word，并标记为true
			now.word = word;
			now.hasWord  = true;
		}
		//返回根节点
		return root;
    }

//worked
	//在当前Trie树中，搜索以board中的x，y处字符为开头的所有可能的words，然后加入集合
	public static void search(char[][] board, int x, int y, int []dx, int []dy,TrieNode root, ArrayList<String> ans){
		if(board == null || root == null)  return;
		if(root.hasWord == true)//首先检查，一旦发现，就加入，但不return
		{
			if(!ans.contains(root.word)){
				ans.add(root.word);
			}
		}
		//不是并列检查，必须放在if(root.hasWord == true)之后
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
			return ;
// 		if(root.subtreeMap.containsKey(board[x][y])){
		for(int i = 0; i < 4; i++){
			char ch = board[x][y];
			chList.add(ch+"");
			board[x][y] = 0;
			search(board, x+dx[i], y+dy[i],dx, dy, root.map.get(ch), ans);
			board[x][y] = ch;
		}
// 		}
	}
	
	public static void search2(char[][] board, int x, int y, int []dx, int []dy,TrieNode root, ArrayList<String> ans){
		if(board == null || root == null)  return;
		if(root.hasWord == true)//发现，就加入，但不return
		{
			if(!ans.contains(root.word)){
				ans.add(root.word);
			}
		}
		for(int i = 0; i < 4; i++){
		    int newX = x+dx[i];
		    int newY = y+dy[i];
		    if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] != 0 ){
    		    char ch = board[newX][newY];
    		    chList.add(ch+"");
    			board[newX][newY] = 0;
    			search2(board, newX, newY,dx, dy, root.map.get(ch), ans);
    			board[newX][newY] = ch;		    
		    }
	
		}
	}

	
}
