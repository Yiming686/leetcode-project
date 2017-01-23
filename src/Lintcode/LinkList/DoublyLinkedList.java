package Lintcode.LinkList;

import java.util.Arrays;
import java.util.Scanner;

public class DoublyLinkedList {

    int val;
    DoublyListNode next;
    DoublyListNode prev;
    DoublyLinkedList(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    
    public static String fromListToString(DoublyListNode head) {
        if (head == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while(head!=null && head.next!=null && head.next!=tail){
        	sb.append(head.val + "-->");
        	head = head.next;
        }
        if(head.next == null) sb.append(head.val +"");
        
        sb.append("}");
        return sb.toString();
    }

    public static DoublyListNode fromStringToList(String str) {
    	if(str == null || str.length() == 0) return null;
    	String[] arr = str.split(",");
    	DoublyListNode dummy = new DoublyListNode(0);
    	DoublyListNode node = dummy;
    	for(String s : arr){
    		node.next = new DoublyListNode(Integer.valueOf(s.trim()));
    		node = node.next;
    	}
    	return dummy.next;
    	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	DoublyListNode list = fromStringToList(" 4  ,   2 ,   5   , 77   ,   33   ");
    	System.out.println(""+DoublyLinkedList.fromListToString(list));;
    	DoublyListNode toAdd = new DoublyListNode(54);
    	addNodeToList(toAdd);
    	System.out.println(""+fromListToString(list));;
    	System.out.println(""+DoublyLinkedList.fromListToString(head));;

	}
    
    static DoublyListNode head = new DoublyListNode(-1);// points to first node
    static DoublyListNode tail = new DoublyListNode(-1); // points to the last node

    static {
		head.next = tail;
		tail.prev = head;
		head.prev = tail;
		tail.next = head;
	}

	// addNodeToList() - add the inputted node to the end of the list
	// - if the node is already in the list, move it to the end
	// - HINT moving a node to the end is the same as removing and adding to the
	// end
	public static void addNodeToList(DoublyListNode toAdd) {
		System.out.println("start:"+DoublyLinkedList.fromListToString(head.next));;
		if (toAdd == null)
			return;

		if (head.next != tail) {
			DoublyListNode curr = head;
			DoublyListNode next = head.next;
			while (next != tail) {
				if (next == toAdd) {
					// remove the node
					curr.next = next.next;
					next.next.prev = curr;
					break;
				}
				curr = next;
				next = next.next;
			}
			// add to the end
			tail.prev.next = next;
			next.prev = tail.prev;
			next.next = tail;
			tail.prev = next;

		} else {
			// if list is empty, add node
			head.next = toAdd;
			toAdd.prev = head;
			toAdd.next = tail;
			tail.prev = toAdd;
		}
    	System.out.println(" end:"+DoublyLinkedList.fromListToString(head.next));;

	}

	// removeNode() - remove the inputted node
	// - if the node is not in the list do nothing
	public  static void removeNode(DoublyListNode toRemove) {
		if (toRemove == null)
			return;
		if (head.next == tail)
			return;
		DoublyListNode curr = head;
		DoublyListNode next = head.next;
		while (next != tail) {
			if (next == toRemove) {
				// remove the node
				curr.next = next.next;
				next.next.prev = curr;
				break;
			}
			curr = next;
			next = next.next;
		}
		return;
	}

	// popNodeFromStart() - remove the node at the start of the list and return
	// it
	public static  DoublyListNode popNodeFromStart() {
		if (head.next == tail)
			return null;
		DoublyListNode node = head.next;
		head.next = node.next;
		head.next.prev = head;
		return node;

	}

	// popNodeFromEnd() - remove the node at the end of the list and return it
	public  static DoublyListNode popNodeFromEnd() {
		if (head.next == tail)
			return null;
		DoublyListNode node = tail.prev;
		node.prev.next = tail;
		tail.prev = node.prev;
		return node;
	}


}

 class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int []di = { 1 , -1, 0 , 0  };
        int []dj = { 0 , 0 , 1 , -1 };
        int[][] maxLenMatrix = new int [rows][cols];//当前点开始的最长递增序列的长度，初始化为0
        int max = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs( matrix, maxLenMatrix, rows, cols, i, j, di, dj));
            }
        }
        return max;
    }
    //在矩阵中，计算以当前点开始的最长递增序列的长度,最小值为
    int dfs(int[][] matrix, int[][] maxLenMatrix, int rows, int cols, int i, int j, int []di, int []dj) {
        if (maxLenMatrix[i][j] != 0) return maxLenMatrix[i][j];//如果不为0,说明已经计算过了,直接返回
        int maxLen = 0;
        for (int k = 0; k < di.length; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];
            //朝四个方向搜索，如果不大于跳过
            if (newI >= 0 && newJ >= 0 && newI < rows && newJ < cols && matrix[newI][newJ] > matrix[i][j]) {
                maxLen = Math.max(maxLen, dfs(matrix, maxLenMatrix, rows, cols, newI, newJ, di, dj));//深度优先搜索，找四个方向找最大的
            }
        }
        maxLenMatrix[i][j] = maxLen+1;
        return maxLenMatrix[i][j] ;
    }
    
    
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
	}
	
    public boolean isValidSudoku(int[][] board) {
        boolean[] visited = new boolean[9];
        
        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }
        
        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }
        
        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                    return false;                   
                }
            }
        }
        return true;
        
    }
    
    private boolean process(boolean[] visited, int num){
        
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }
        
        visited[num-1] = true;
        return true;
    }


}
 
 

