package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_103_Binary_Tree_Zigzag_Level_Order_Traversal {

	
//	Book上面的解法，用到两个queue,修改了书上的，比书上的好，书上的不断创建nextLevelQueue对象
//	其实就是用了两个Queue，然后交替进行处理，代码清晰
//	此题目增加难度，就在于
//	1.两个Queue的处理，
//	2.以及flag变量isLeft2Right的运用，
//	3.两个while循环，还都是真的同一个currLevelQueue
	
//	NOTE：如果真不是要求zigzag，就可以只要一个queue，去掉flag，只用一个while循环了
//	
//	推广：如果限定只用一个queue，那就采用下面的下面的solution
//	
//	Accepted, 320ms,{250,300,380}
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> currLevelQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();

		currLevelQueue.add(root);
		boolean isLeft2Right = true;
		while (!currLevelQueue.isEmpty()) {
			LinkedList<Integer> intList = new LinkedList<Integer>();
			while (!currLevelQueue.isEmpty()) {
				TreeNode curr = currLevelQueue.poll();

				if (curr.left != null)
					nextLevelQueue.add(curr.left);
				if (curr.right != null)
					nextLevelQueue.add(curr.right);
				
				if (isLeft2Right) {
					intList.addLast(curr.val);
				} else {
					intList.addFirst(curr.val);
				}
			}
			result.add(intList);
			
			Queue<TreeNode> currLevelQueue2 = currLevelQueue ; 
			currLevelQueue = nextLevelQueue;
			nextLevelQueue = currLevelQueue2;
			
			isLeft2Right = !isLeft2Right;
		}
		return result;
	}
	
//	 自己拍脑袋想出来的解决方案,当然没有优化,只是觉得可行
//	Accepted, 320ms,{250,300,380}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (root == null)
			return ll;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
		q.add(root);
		boolean isLeft2Right = true;
		while (!q.isEmpty()) {
			LinkedList<Integer> intList = new LinkedList<Integer>();
			while (!q.isEmpty()) {
				TreeNode curr = q.poll();
				if (isLeft2Right) {
					nodeList.addLast(curr);
					intList.addLast(curr.val);
				} else {
					nodeList.addFirst(curr);
					intList.addFirst(curr.val);
				}
			}
			ll.add(intList);
			if (isLeft2Right) {
				for(int i = 0; i< nodeList.size() ; i ++){
					TreeNode node = nodeList.get(i);
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				}
			} else {
				for(int i = nodeList.size() - 1; i >= 0 ; i --){
					TreeNode node = nodeList.get(i);
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				}
			}
			nodeList.clear();
//			isLeft2Right = isLeft2Right == false ? true : false;
			isLeft2Right = !isLeft2Right;

		}
		return ll;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
