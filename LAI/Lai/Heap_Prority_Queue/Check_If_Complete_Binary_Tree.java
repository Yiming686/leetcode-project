package Lai.Heap_Prority_Queue;

import java.util.LinkedList;
import java.util.Queue;

import Utils.TreeNodeUtils.TreeNode;

public class Check_If_Complete_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
	}

//	Best Solution, I have ever seen
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//允许添加null
		queue.offer(root);
		while (queue.peek() != null) {//不是判断isEmpty()。不断BFS，期间不判断是否为null，直接offer。只要不为null就继续，直到出现一个null
			TreeNode node = queue.poll();
			queue.offer(node.left);
			queue.offer(node.right);
		}
		while (!queue.isEmpty()) {//既然遇到了一个null，后面的依次弹出，发现第一个不为null的返回false；若默认发现，返回true;
			TreeNode node = queue.poll();
			if (node != null) {
				return false;
			}
		}
		return true;
//		while (!queue.isEmpty() && queue.peek() == null) {//出现了第一个null，把所有的null都弹出去
//			queue.poll();
//		}
//		return queue.isEmpty();//如果是空，true，否则false
	}

//	Sample soluton 
	public boolean isCompleteTree01(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//允许添加null
		queue.offer(root);
		boolean hasFound = false;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left == null) {//find first null node
				hasFound = true;
			}else if(hasFound){ //non-null node after null node
				return false;
			}else {
				queue.offer(node.left);
			}
			if(node.right == null) {
				hasFound = true;
			}else if(hasFound) {//non-null node after null node
				return false;
			}else {
				queue.offer(node.right);
			}
		}
		return true;
	}

}
